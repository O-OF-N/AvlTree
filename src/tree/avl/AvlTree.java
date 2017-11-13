package tree.avl;

/**
 * Created by vm033450 on 10/17/17.
 */
public class AvlTree {

    private Node root;

    public void add(int value) {
        root = addChild(value, root);
    }

    public Node getRoot() {
        return root;
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    private int getBalanceFactor(Node node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private Node addChild(int value, Node parent) {
        if (parent == null) {
            Node child = new Node(value);
            child.setHeight(getHeight(child));
            return child;
        } else if (parent.getValue() < value) {
            Node child = addChild(value, parent.getRight());
            parent.setRight(child);
        } else {
            Node child = addChild(value, parent.getLeft());
            parent.setLeft(child);
        }
        int balanceFactor = getBalanceFactor(parent);
        parent = balanceFactor < -1 ? rotateLeft(parent) : balanceFactor > 1 ? rotateRight(parent) : parent;
        parent.setHeight(getHeight(parent));
        return parent;
    }

    private Node rotateLeft(Node n) {
        Node right = n.getRight();
        if (getBalanceFactor(right) > 0)
            right = rotateRight(right);
        n.setRight(right.getLeft());
        right.setLeft(n);
        n.setHeight(getHeight(n));
        right.setHeight(getHeight(right));
        return right;
    }

    private Node rotateRight(Node n) {
        Node left = n.getLeft();
        if (getBalanceFactor(left) < 0)
            left = rotateLeft(left);
        n.setLeft(left.getRight());
        left.setRight(n);
        n.setHeight(getHeight(n));
        left.setHeight(getHeight(left));
        return left;
    }

}
