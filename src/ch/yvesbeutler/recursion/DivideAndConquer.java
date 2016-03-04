package ch.yvesbeutler.recursion;

import ch.yvesbeutler.recursion.node.Node;

/**
 * @author yvesbeutler
 * @since 04.03.2016
 * Divide and conquer is a powerful recursive-iterative algorithm template. DC works top-down and combines the
 * strengths of recursion with iteration. A usual problem will be divided (by recursion) into smaller parts
 * which are now solvable and afterwards put back together to the origin problem.
 */
public class DivideAndConquer {

    public static void main(String[] args) {

        // create node structure
        Node node = Node.initialize();

        // summarize all child nodes
        System.out.println("The number of all leaves is: " + node.summarizeChildren());
    }
}
