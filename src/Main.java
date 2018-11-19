import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

/**
 * The Main class prints the path of three.
 */
public class Main {

  /**
   * Initializes a HashMap of all the nodes (keys) in the tree set to false (values).
   * @param adjacencyList tree of nodes
   * @return HashMap with all values set to false.
   */
  private static HashMap<String, Boolean> exploreFalse(LinkedHashMap<String,
          List<Node>> adjacencyList) {
    HashMap<String, Boolean>  explored = new HashMap<>();

    for (String key : adjacencyList.keySet()) {
      explored.put(key, false);
    }
    return explored;
  }

  /**
   * Builds a tree (adjacency list) from nodes.
   * @return the root node
   */
  private static LinkedHashMap<String, List<Node>> buildTree(){

    // initialize tree
    LinkedHashMap<String, List<Node>> tree = new LinkedHashMap<>();

    // initialize all nodes
    Node start = new Node();
    Node a1 = new Node();
    Node a2 = new Node();
    Node b1 = new Node();
    Node b2 = new Node();
    Node c1 = new Node();
    Node d1 = new Node();
    Node e1 = new Node();
    Node findMe = new Node();

    // set all node names
    start.setName("Start");
    a1.setName("A1");
    a2.setName("A2");
    b1.setName("B1");
    b2.setName("B2");
    c1.setName("C1");
    d1.setName("D1");
    e1.setName("E1");
    findMe.setName("Find Me");

    // initialize all the children of tree
    List<Node> startBranch = new ArrayList<>();
    List<Node> a1Branch = new ArrayList<>();
    List<Node> a2Branch = new ArrayList<>();
    List<Node> b1Branch = new ArrayList<>();
    List<Node> b2Branch = new ArrayList<>();
    List<Node> d1Branch = new ArrayList<>();

    // create branches
    d1Branch.add(e1);
    b1Branch.add(findMe);
    b2Branch.add(c1);
    a2Branch.add(b1);
    a2Branch.add(b2);
    a1Branch.add(d1);
    startBranch.add(a1);
    startBranch.add(a2);

    // build adjacency list in HasMap form
    tree.put(start.getName(), startBranch);
    tree.put(a1.getName(), a1Branch);
    tree.put(a2.getName(), a2Branch);
    tree.put(d1.getName(), d1Branch);
    tree.put(b1.getName(), b1Branch);
    tree.put(b2.getName(), b2Branch);
    tree.put(e1.getName(), null);
    tree.put(findMe.getName(), null);
    tree.put(c1.getName(), null);

    return tree;
  }

  /**
   * Runs DFS on adjacency list to determine path of three that leads to "Find Me".
   * @param tree tree of nodes
   * @return the path of thre tree that lead to node "Find Me"
   */
  private static List<String> dfs(LinkedHashMap<String, List<Node>> tree) {

    HashMap<String, Boolean> explore = exploreFalse(tree);
    HashMap<String, Boolean> finished = exploreFalse(tree);

    List<String> allPaths = new ArrayList<>();

    // Initialize S to be a stack with one element s
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < explore.size(); i++) {
      stack.push("Start");
      List<String> path = new ArrayList<>();
      while (!stack.empty()) {
        // Take a node u from S
        String node = stack.pop();
        // If Finished = false then
        if (!finished.get(node)) {
          // add node to path
          path.add(node);
          if (node.equals("Find Me")) {
            return path;
          }
          // Set Explored[u] = true
          explore.put(node, true);
          // if u has incident edges
          List<Node> listOfNodes = tree.get(node);
          if (listOfNodes != null) {
            Boolean allVisited = true;
            // For each edge (u, v) incident to u
            for (int j = 0; j < listOfNodes.size(); j++) {
              if (!listOfNodes.isEmpty()) {
                if (!explore.get(listOfNodes.get(j).getName())) {
                  allVisited = false;
                  // Add v to the stack S
                  stack.push(listOfNodes.get(j).getName());
                }
              }
            }
            if (allVisited) {
              finished.put(node, true);
              allPaths.add(node);
              stack.addAll(path);
              path = new ArrayList<>();
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Prints out path of Nodes.
   * @param path path of nodes that leads "Find Me"
   */
  private static void printPath(List<String> path) {
    for (int i = 0; i < path.size(); i++) {
      System.out.println(path.get(i));
    }
  }
  
  /**
   * Builds the tree, runs DFS to find "Find Me", prints results.
   * @param arguments none
   */
  public static void main(String[] arguments) {

    // builds tree of nodes in adjacency list form
    LinkedHashMap<String, List<Node>> tree = buildTree();

    // runs DFS on the tree to determine location of 'Find Me'
    List<String> path = dfs(tree);

    // print out path
    printPath(path);


  }

}


