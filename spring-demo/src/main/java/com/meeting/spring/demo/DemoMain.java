package com.meeting.spring.demo;

import com.alibaba.fastjson.JSONObject;
import com.meeting.spring.demo.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {
    public static void main(String[] args) {
        JSONObject.toJSONString("");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        JSONObject object = (JSONObject) context.getBean("jsonObject");
        String s = object.toJSONString(context);
        System.out.println(s);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo) {
        int rootVal = preorder[preFrom];
        int inRootIndex = 0;
        for (int i = inFrom; i < inTo; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                break;
            }
        }
        int rightSonLength = inTo - inRootIndex;
        int leftPreFrom = preFrom + 1;
        int leftProTo = preTo - rightSonLength;
        int leftInFrom = inFrom;
        int leftInTo = inRootIndex - 1;
        TreeNode node = new TreeNode(inorder[inRootIndex]);
        node.left = buildTree(preorder, inorder, leftPreFrom, leftProTo, leftInFrom, leftInTo);
        int rightPreFrom = leftProTo + 1;
        int rightPreTo = preTo;
        int rightInFrom = leftInTo + 2;
        int rightInTo = inTo;
        node.right = buildTree(preorder, inorder, rightPreFrom, rightPreTo, rightInFrom, rightInTo);
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
