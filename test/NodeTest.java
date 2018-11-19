import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests the node class correctly builds node.
 */
public class NodeTest {

  private Node node;
  private List<Node> children;
  private Node childOne;
  private Node childTwo;
  private Node childThree;

  /**
   * Initializes an instance of node in order to test.
   */
  @Before
  public void setup() {
    node = new Node();
    children = new ArrayList<>();
    childOne = new Node();
    childTwo = new Node();
    childThree = new Node();
  }

  /**
   * Tests the method getName() returns the initial form of a node;
   */
  @Test
  public void testGetNameNull() {
    assertEquals(null, node.getName());
  }

  /**
   * Tests the method getChildren() returns the initial form of a node;
   */
  @Test
  public void testGetChildrenNull() {
    assertEquals(null, node.getChildren());
  }

  /**
   * Tests the method setName() sets the name passed in;
   */
  @Test
  public void testSetName() {
    node.setName("foo");
    assertEquals("foo", node.getName());
  }

  /**
   * Tests the method setChildren() sets the list of Children;
   */
  @Test
  public void testSetChildren() {

    childOne.setName("one");
    childTwo.setName("two");
    childThree.setName("three");

    children.add(childOne);
    children.add(childTwo);
    children.add(childThree);

    node.setChildren(children);

    assertEquals(3, node.getChildren().size());
    assertEquals("one", node.getChildren().get(0).getName());
    assertEquals("two", node.getChildren().get(1).getName());
    assertEquals("three", node.getChildren().get(2).getName());
  }

}
