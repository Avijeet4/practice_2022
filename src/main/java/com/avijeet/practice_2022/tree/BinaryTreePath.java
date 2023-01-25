package com.avijeet.practice_2022.tree;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode1 root) {
        return new MyList(root);
    }
    static String sl = "->";
    static class MyList extends ArrayList<String> {
        TreeNode1 root;
        public MyList(TreeNode1 root) {
            this.root = root;
        }
        public int size() {
            if (root!=null)
                method();

            return super.size();
        }
        private void method() {
            String s = String.valueOf(root.val);
            if (root.left==null&&root.right==null) {
                super.add(s);
                root=null;
                return;
            }
            if (root.left!=null)
                method(root.left,s);
            if (root.right!=null)
                method(root.right,s);
            root=null;
        }
        private void method(TreeNode1 n, String s) {
            s = s.concat(sl.concat(String.valueOf(n.val)));
            if (n.left==null&&n.right==null) {
                super.add(s);
                return;
            }
            if (n.left!=null)
                method(n.left,s);
            if (n.right!=null)
                method(n.right,s);

        }
    }

    public static void main(String[] args) {
        TreeNode1 root=new TreeNode1(1);
        root.left=new TreeNode1(2);
        root.right=new TreeNode1(3);
        System.out.println(binaryTreePaths(root));

    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
