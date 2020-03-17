package fc.avl;

public class AVLNode {
    public int data;// 保存节点数据
    public int depth;// 保存节点深度
    public int balance;// 是否平衡
    public AVLNode parent;// 指向父节点
    public AVLNode left;// 指向左子树
    public AVLNode right;// 指向右子树

    public AVLNode(int data) {
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }
}