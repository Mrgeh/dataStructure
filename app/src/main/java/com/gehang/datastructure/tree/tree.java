package com.gehang.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ge Hang
 * @packageName com.gehang.datastructure.tree
 * @Admonish This is the ancestral code from Ge Hang, please check!
 * @time 2021/2/5 10:20
 */
public class tree {

    private static java.lang.Object Object;

    /**
     * 构建二叉树
     * @param inputList
     * @return
     */
    public  static TreeNode CreateBinaryTree(LinkedList<Integer> inputList){
            TreeNode  node = null;

        if (inputList==null || inputList.isEmpty()){
            return  null;
        }

        Integer data = inputList.removeFirst();//若此处为空，则不再进一步递归

        if (data !=null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }


        return node;
    }

    private static Object createBinaryTree(LinkedList<Integer> inputList) {
        return Object;
    }


    /**
     * 二叉树的前序遍历  栈方式
     * @param root
     */
    public static  void  preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode treeNode = root;

        while (treeNode==null||!stack.isEmpty()){

            while (treeNode !=null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode= (TreeNode) treeNode.leftChild;

            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()){
                treeNode =stack.pop();
                treeNode = (TreeNode) treeNode.rightChild;
            }
        }




    }

    /**
     * 二叉树的层序遍历   用队列实现
     * @param root  二叉树的根节点
     */
    public  static  void  leveOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){


            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                System.out.println(node.data);
                if (node.leftChild!=null){
                    queue.offer((TreeNode) node.leftChild);

                }
                if (node.rightChild!=null){

                    queue.offer((TreeNode) node.rightChild);
                }
            }

        }

    }




}
