package datastructure;

import java.util.Arrays;
import java.util.Random;

public class RedBlackTree {
    private static final int RED = 1;
    private static final int BLACK = 2;

    static final class Node {
        int color = RED;
        Node left;
        Node right;
        Node parent;
        int val;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " " + (color == RED ? "red" : "black") + ": ["
                    + (left == null ? "null" : left.toString()) + ", " 
                    + (right == null ? "null" : right.toString()) + "]";
        }
    }

    private Node head;

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] node = {5, 5, 6, 9, 7, 7, 3, 1, 6, 8};
        for (int i = 0; i < 10; i++) {
            tree.insert(node[i]);
        }
        System.out.println(tree.head.toString());

        RedBlackTree tree1 = new RedBlackTree();
        for (int i = 1; i <= 10; i++) {
            tree1.insert(i);
        }
        System.out.println(tree1.head.toString());

        RedBlackTree tree2 = new RedBlackTree();
        for (int i = 10; i > 0; i--) {
            tree2.insert(i);
        }
        System.out.println(tree2.head.toString());

        int[] random = new int[10];
        Random r = new Random();
        RedBlackTree tree3 = new RedBlackTree();
        for (int i = 0; i < 10; i++) {
            random[i] = r.nextInt(10);
            tree3.insert(random[i]);
        }
        System.out.println(Arrays.toString(random));
        System.out.println(tree3.head.toString());
    }

    private void insert(int n) {
        if (head == null) {
            head = new Node(n);
            insertRoot(head);
        } else {
            Node parent = head;
            while (true) {
                if (n >= parent.val) {
                    if (parent.right == null) {
                        Node tmp = new Node(n);
                        tmp.parent = parent;
                        parent.right = tmp;
                        insertRoot(tmp);
                        return;
                    }
                    parent = parent.right;
                } else {
                    if (parent.left == null) {
                        Node tmp = new Node(n);
                        tmp.parent = parent;
                        parent.left = tmp;
                        insertRoot(tmp);
                        return;
                    }
                    parent = parent.left;
                }
            }
        }
    }

    private void insertRoot(Node n) {
        if (n.parent == null) {
            n.color = BLACK;
        } else {
            if (n.parent.color == BLACK) {
                return;
            }

            if (uncle(n) != null && uncle(n).color == RED) {
                n.parent.color = BLACK;
                uncle(n).color = BLACK;
                grandparent(n).color = RED;
                insertRoot(grandparent(n));
                return;
            }

            if (n.parent == grandparent(n).left && n == n.parent.right) {
                leftRotate(n);
                n = n.left;
            } else if (n.parent == grandparent(n).right && n == n.parent.left) {
                rightRotate(n);
                n = n.right;
            }

            grandparent(n).color = RED;
            n.parent.color = BLACK;
            if (n.parent == grandparent(n).left) {
                rightRotate(n.parent);
            } else {
                leftRotate(n.parent);
            }
        }
    }

    private Node uncle(Node n) {
        if (n.parent == grandparent(n).left) {
            return grandparent(n).right;
        } else {
            return grandparent(n).left;
        }
    }

    private Node grandparent(Node n) {
        return n.parent.parent;
    }

    private void leftRotate(Node n) {
        Node parent = n.parent;
        Node grandparent = parent.parent;

        Node left = n.left;
        parent.right = left;
        if (left != null) {
            left.parent = parent;
        }
        parent.parent = n;

        n.parent = grandparent;
        n.left = parent;
        if (grandparent != null) {
            if (grandparent.right == parent) {
                grandparent.right = n;
            } else {
                grandparent.left = n;
            }
        } else {
            head = n;
        }
    }

    private void rightRotate(Node n) {
        Node parent = n.parent;
        Node grandparent = parent.parent;

        Node right = n.right;
        parent.left = right;
        if (right != null) {
            right.parent = parent;
        }
        parent.parent = n;

        n.parent = grandparent;
        n.right = parent;
        if (grandparent != null) {
            if (grandparent.left == parent) {
                grandparent.left = n;
            } else {
                grandparent.right = n;
            }
        } else {
            head = n;
        }
    }
}
