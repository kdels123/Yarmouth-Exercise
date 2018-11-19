import java.util.List;

/**
 * Defines a node of a tree
 */
public class Node {

  private String name;
  private List<Node> children;

  public Node() {

  }

  /**
   * Sets the name of a node.
   * @param name name of node
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the name of a node.
   * @return name of node
   */
  public String getName() {
    return this.name;
  }


  /**
   * Sets children for a node.
   * @param children children of parent node
   */
  public void setChildren(List<Node> children) {
    this.children = children;
  }

  /**
   * Sets children for a node.
   * @return children children of parent node
   */
  public List<Node> getChildren() {
    return this.children;
  }


}
