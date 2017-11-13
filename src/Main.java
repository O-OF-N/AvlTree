import tree.avl.AvlTree;
import tree.avl.Node;

/**
 * Created by vm033450 on 10/17/17.
 */
public class Main {

    public static void main(String[] args) {
        AvlTree t1 = new AvlTree();
        t1.add(1);
        t1.add(2);
        t1.add(3);
        t1.add(4);
        t1.add(5);
        t1.add(-1);
        t1.add(-2);
        t1.add(-3);
        print(t1.getRoot());
    }

    public static void print(Node n1) {
        inOrder(n1);
    }

    private static void inOrder(Node t1) {
        if (t1 != null) {
            inOrder(t1.getLeft());
            System.out.println(t1);
            inOrder(t1.getRight());
        }
    }
}
