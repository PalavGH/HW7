package com.company;

class BinarySearchTree
{
    class Node
    {
        int data;
        Node left, right;

        public Node(int value)
        {
            data = value;
            left = null;
            right = null;
        }
    }

    Node root;
    BinarySearchTree()
    {
        root = null;
    }

    void rootDelete(int data)
    {
        root = deleteByCopying(root, data);
    }

    Node deleteByCopying(Node root, int data)
    {
        if (root == null)
        {
            return null;
        }


        if (data < root.data)
        {
            root.left = deleteByCopying(root.left, data);
        }
        else if (data > root.data)
        {
            root.right = deleteByCopying(root.right, data);
        }
        else
        {
            if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteByCopying(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;

        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }

        return minv;
    }

    void insert(int data)
    {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data)
    {
        if (root == null)
        {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
        {
            root.left = insertRec(root.left, data);
        }
        else if (data > root.data)
        {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    void inorder()
    {
        inorderRec(root);
    }

    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    Node findNode(Node root, int key)
    {
        if (root.data == key)
        {
            System.out.println("Time to return");
            System.out.println(root.data);
            return root;
        }
        if (key < root.data)
        {
            findNode(root.left, key);
        }
        else
        {
            findNode(root.right, key);
        }
        return null;
    }

    void deleteByMerging(Node root, int key)
    {

    }


    public static void main(String[] args)
    {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        Node findNode = binarySearchTree.findNode(binarySearchTree.root, 70);
        System.out.println("Gittest");

      /*  System.out.println("Inorder traversal of the given binarySearchTree");
        binarySearchTree.inorder();

        System.out.println("\nDelete 20");
        binarySearchTree.rootDelete(20);
        System.out.println("Inorder traversal of the modified binarySearchTree");
        binarySearchTree.inorder();

        System.out.println("\nDelete 30");
        binarySearchTree.rootDelete(30);
        System.out.println("Inorder traversal of the modified binarySearchTree");
        binarySearchTree.inorder();

        System.out.println("\nDelete 50");
        binarySearchTree.rootDelete(50);
        System.out.println("Inorder traversal of the modified binarySearchTree");
        binarySearchTree.inorder();*/
    }
}