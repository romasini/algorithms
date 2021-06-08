package ru.romasini.lessons.homeworks.hw_6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int level;

        public NodeAndParent(Node<E> current, Node<E> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }
    }

    private int size;
    private int maxLevel;
    private Node<E> root;

    public TreeImpl() {
        this(0);
    }

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean add(E value) {

        if(maxLevel == 0){
            return false;
        }

        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);

        if (nodeAndParent.current != null) {
            return false;
        }

        Node<E> prev = nodeAndParent.parent;
        int level = nodeAndParent.level;

        if (prev == null) {
            root = node;
        } else if (level < maxLevel) {
            if (prev.isLeftChild(value)) {
                prev.setLeftChild(node);
            } else {
                prev.setRightChild(node);
            }
        } else {
            return false;
        }

        size++;
        return true;
    }

    private NodeAndParent doFind(E value){
        Node<E> current = root;
        Node<E> prev = null;
        int level = 0;

        while (current != null) {
            level++;
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, prev, level);
            }

            prev = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, prev, level);
    };

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.current;
        Node<E> parentNode = nodeAndParent.parent;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removedLeaf(removedNode, parentNode);
        } else if (removedNode.hasOnlyOneChild()) {
            removedNodeWithOnlyOneChild(removedNode, parentNode);
        } else {
            removedNodeWithAllChildren(removedNode, parentNode);
        }

        size--;
        return true;
    }

    private void removedNodeWithAllChildren(Node<E> removedNode, Node<E> parentNode) {
        Node<E> successor = getSuccessor(removedNode);

        if (removedNode == root) {
            root = successor;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(successor);
        } else {
            parentNode.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removedNodeWithOnlyOneChild(Node<E> removedNode, Node<E> parentNode) {
        Node<E> child = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = child;
        } else if (parentNode.isLeftChild(root.getValue())) {
            parentNode.setLeftChild(child);
        } else {
            parentNode.setRightChild(child);
        }
    }

    private void removedLeaf(Node<E> removedNode, Node<E> parentNode) {
        if (removedNode == root) {
            root = null;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode){
            case IN_ORDER: inOrder(root);
                break;
            case PRE_ORDER: preOrder(root);
                break;
            case POST_ORDER: postOrder(root);
                break;
            default: throw new IllegalArgumentException("Unknown traverse mode");
        }
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current.getValue());

    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getValue());
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());

    }

    private void inOrder(Node<E> current) {

        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());

    }

    @Override
    public boolean isBalanced(){
        return Node.isBalanced(root);
    }

}
