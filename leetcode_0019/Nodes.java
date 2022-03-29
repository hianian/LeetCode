/**
 * @Author : hianian
 * @Time : 2022/3/29 20:10
 * @File : Nodes.java
 */
public class Nodes {

    public int val;
    public Nodes left;
    public Nodes right;
    public Nodes next;

    public Nodes() {}

    public Nodes(int _val) {
        val = _val;
    }

    public Nodes(int _val, Nodes _left, Nodes _right, Nodes _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
