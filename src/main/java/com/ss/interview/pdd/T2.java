package com.ss.interview.pdd;

import com.ss.struct.TreeNode;

public class T2 {

    static int res = 0;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        new T2().getDistance(t1, t4, t5);
        System.out.println(res);
    }

    public int getDistance(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null) {
            return 0;
        }
        int left = getDistance(root.left, q, p);
        int right = getDistance(root.right, q, p);

        if (root == p || root == q) {
            if (left != 0) {
                res = left;
                return 0;
            }
            if (right != 0) {
                res = right;
                return 0;
            }
            return 1;
        }
        if (left != 0 && right != 0) {
            res = left + right;
            return 0;
        }
        if (left == 0 && right == 0) {
            return 0;
        }
        if (left != 0) {
            return left + 1;
        }
        return right + 1;

    }
}
