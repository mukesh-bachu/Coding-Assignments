package com.company;

public class BST {
        /* Class containing left
        and right child of current node
        and value*/
        class Node
        {
            int val;
            Node left, right;

            public Node(int key)
            {
                val = key;
                left = right = null;
            }
        }

        // Root of BST
        Node root;

        // Constructor
        BST()
        {
            root = null;
        }

        // This method mainly calls the function insertNode()
        void insert(int val)
        {
            root = insertNode(root, val);
        }

        /*function to insert a new val in BST */
        Node insertNode(Node root, int val)
        {

		/* If the tree is empty, returning a new node */
            if (root == null)
            {
                root = new Node(val);
                return root;
            }

            /* Otherwise, recurring down the tree */
            if (val < root.val)
                root.left = insertNode(root.left, val);
            else if (val > root.val)
                root.right = insertNode(root.right, val);

            return root;
        }

        // This method mainly calls the function for InorderTraversal()
        void inorder()
        {
            inorderTraversal(root);
        }

        //function for inorder traversal of BST
        void inorderTraversal(Node root)
        {
            if (root != null) {
                inorderTraversal(root.left);
                System.out.println(root.val);
                inorderTraversal(root.right);
            }
            }

        // This method mainly calls the function deleteVal()
        void delete(int val) { root = deleteVal(root, val); }

        /* function to delete an existing val in BST */
        Node deleteVal(Node root, int val)
        {
            /* Base Case: If the tree is empty */
            if (root == null)
                return root;

            /* Otherwise, recurring down the tree */
            if (val < root.val)
                root.left = deleteVal(root.left, val);
            else if (val > root.val)
                root.right = deleteVal(root.right, val);

                // if val is same as root's
                // val, then this is the
                // node to be deleted
            else {
                // node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // node with two children: Getting the
                // successor (smallest in the right subtree)
                root.val = minValue(root.right);

                // Deleting the successor
                root.right = deleteVal(root.right, root.val);
            }

            return root;
        }

        int minValue(Node root)
        {
            int minv = root.val;
            while (root.left != null)
            {
                minv = root.left.val;
                root = root.left;
            }
            return minv;
        }


        // Driver Code
        public static void main(String[] args)
        {
            BST bstree = new BST();

            bstree.insert(40);
            bstree.insert(60);
            bstree.insert(20);
            bstree.insert(80);
            bstree.insert(50);
            bstree.insert(10);
            bstree.insert(30);
            bstree.insert(15);
            bstree.insert(5);
            bstree.insert(35);
            bstree.insert(25);
            bstree.insert(45);
            bstree.insert(55);
            bstree.insert(70);
            bstree.insert(90);
            bstree.insert(32);
            bstree.insert(33);
            bstree.insert(48);
            bstree.insert(46);

            // printing inorder traversal of the BST
            System.out.print("Printing the inorder traversal of the BST after inserting the nodes\n");
            bstree.inorder();
            // deleting 40 using its successor
            bstree.delete(40);
            // printing inorder traversal of the BST after deleting 40
            System.out.print("Printing the inorder traversal of the BST after deleting 40\n");
            bstree.inorder();
            // deleting 40 using its successor.
            bstree.delete(20);
            // printing inorder traversal of the BST after deleting 20
            System.out.print("Printing the inorder traversal of the BST after deleting 20\n");
            bstree.inorder();
        }
}
