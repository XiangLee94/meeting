package com.meeting.datastructure.tree.searchtree;

public class BlackRedTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;//键
        Value value;//值
        Node left;//左子树
        Node right; // 右子树
        int N; //这棵子树中的节点总数
        boolean color; //节点颜色

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    /**
     * 左旋node的右链接
     * @param node
     * @return
     */
    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        right.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return right;
    }


    static class Key {
    }

    static class Value {
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }


}
