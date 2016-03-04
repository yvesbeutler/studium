package ch.yvesbeutler.recursion.node;

import java.util.Vector;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * This class represents a node structure which has its integer value and optional children.
 */
public class Node {

    Integer tag;
    Vector<Node> children = new Vector<Node>();

    public Node(Integer tag) {
        this.tag = tag;
    }

    boolean isLeaf() {
        return children.isEmpty();
    }

    Node addChild(Node node) {
        children.add(node);
        return this;
    }

    /**
     * Returns the value of itself with all of its children values.
     */
    public int summarizeChildren() {
        if (isLeaf()) {
            return tag;
        } else {
            int sum = 0;
            for(Node child : children) {
                sum += child.summarizeChildren();
            }
            return sum + tag;
        }
    }

    /**
     * Initializes a simple node structure
     */
    public static Node initialize() {

        Node root = new Node(4);
        Node child1 = new Node(8);
        Node child2 = new Node(2);

        child1.addChild(new Node(7));
        child1.addChild(new Node(4));
        child2.addChild(new Node(3));
        child2.addChild(new Node(5));
        child2.addChild(new Node(6));

        root.addChild(child1);
        root.addChild(child2);

        return root;
    }

}
