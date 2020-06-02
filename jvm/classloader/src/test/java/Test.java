//public class Test {
//    private void doAcquireShared(int arg) {
//        final Node node = addWaiter(Node.SHARED);//加入队列尾部
//        boolean failed = true;//是否成功标志
//        try {
//            boolean interrupted = false;//等待过程中是否被中断过的标志
//            for (; ; ) {
//                final Node p = node.predecessor();//前驱
//                if (p == head) {//如果到head的下一个，因为head是拿到资源的线程，此时node被唤醒，很可能是head用完资源来唤醒自己的
//                    int r = tryAcquireShared(arg);//尝试获取资源
//                    if (r >= 0) {//成功
//                        setHeadAndPropagate(node, r);//将head指向自己，还有剩余资源可以再唤醒之后的线程
//                        p.next = null; // help GC
//                        if (interrupted)//如果等待过程中被打断过，此时将中断补上。
//                            selfInterrupt();
//                        failed = false;
//                        return;
//                    }
//                }
//
//                //判断状态，寻找安全点，进入waiting状态，等着被unpark()或interrupt()
//                if (shouldParkAfterFailedAcquire(p, node) &&
//                        parkAndCheckInterrupt())
//                    interrupted = true;
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node);
//        }
//    }
//}