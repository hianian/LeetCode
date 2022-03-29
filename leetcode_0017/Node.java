import java.util.List;

/**
 * @Author : hianian
 * @Time : 2022/3/28 19:39
 * @File : Node.java
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
