package de.ratsch0k;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SyntaxTreeBuilder {

    public static void main(String[] args) {
        if (args.length == 0 || args[0] == null) {
            System.exit(1);
        }

        String term = args[0];

        String[] tokens = parse(term);

        if (tokens.length <= 0) {
            System.exit(1);
        }

        final Node root = buildTree(tokens);

        System.out.print(new GsonBuilder().setPrettyPrinting().create().toJson(root));
    }

    /**
     * Parses a term and returns an array of operators or numbers
     * @param str   The string to parse
     * @return      An array string which are either operators or numbers
     */
    public static String[] parse(String str) {
        return str.split(" ");
    }

    /**
     * Creates a syntax tree from the given array
     * @param array The array for which to creates the syntax tree
     * @return  The root node of the syntax tree
     */
    public static Node buildTree(String[] array) {
        /*
         * If the array only contains one item, build the node and return
         */
        if (array.length == 1) {
            return new Node(array[0]);
        } else {
            // Check if the root value is an operator
            if (array[0].equals("*") || array[0].equals("+")) {
                // Because length of array is greater than 1 the left child must exist. Get the left child
                Node leftChild = buildTree(Arrays.copyOfRange(array, 1, array.length));

                // Get the amount nodes which are contained in the left child
                int leftNodes = leftChild.getAmountOfNodes();

                // If the left path doesn't include all items of the array build the right child
                Node rightChild = null;
                if (leftNodes + 1 < array.length) {
                    rightChild = buildTree(Arrays.copyOfRange(array, leftNodes + 1, array.length));
                }

                return new Node(array[0], leftChild, rightChild);
            } else {
                return new Node(array[0]);
            }
        }
    }
}