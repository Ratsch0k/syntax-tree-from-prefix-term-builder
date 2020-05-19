/**
 * This class represents a node of a binary tree.
 * If the node is a lae
 */
public class Node {
  /**
   * Value of the node.
   * Either an integer or an operator
   */
  public String value;

  /**
   * Left child of the node.
   * Either a node or null if this node is leaf.
   */
  public Node leftChild;

  /**
   * Left child of the node.
   * Either a node or null if this node is leaf.
   */
  public Node rightChild;

  /**
   * Creates an instance of this class.
   * @param value       Value of the node
   * @param leftChild   left child of the node
   * @param rightChild  right child of the node
   */
  public Node(String value, Node leftChild, Node rightChild) {
    this.value = value;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  /**
   * Creates an instance of this class with all attributes set to null.
   */
  public Node() {
    this.value = null;
    this.leftChild = null;
    this.rightChild = null;
  }

  /**
   * Creates an instance of this class with only the value set
   * @param value The value of this node
   */
  public Node(String value) {
    this.value = value;
    this.leftChild = null;
    this.rightChild = null;
  }

  /**
   * Returns the amount of nodes this node contains (includes nodes of left and right child)
   * @return  The amount of nodes of this and children nodes.
   */
  public int getAmountOfNodes() {
    int amount = 1;

    if (leftChild != null) {
      amount += leftChild.getAmountOfNodes();
    }

    if (rightChild != null) {
      amount += rightChild.getAmountOfNodes();
    }

    return amount;
  }
}
