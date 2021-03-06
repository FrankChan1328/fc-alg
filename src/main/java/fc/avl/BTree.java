package fc.avl;

public class BTree {
    /**
     * 插入数据
     */
    public void insert(AVLNode root, int data) {
        // 如果说插入的数据小于根节点，往左边递归插入
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new AVLNode(data);
                root.left.parent = root;
            }
        }
        // 如果说插入的数据小于根节点，往左边递归插入
        else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new AVLNode(data);
                root.right.parent = root;
            }
        }
        // 插入之后，计算平衡银子
        root.balance = calcBalance(root);
        // 左子树高，应该右旋
        if (root.balance >= 2) {
            // 右孙高，先左旋
            if (root.left.balance == -1) {
                left_rotate(root.left);
            }
            right_rotate(root);
        }
        // 右子树高，左旋
        if (root.balance <= -2) {
            // 左孙高，先右旋
            if (root.right.balance == 1) {
                right_rotate(root.right);
            }
            left_rotate(root);
        }
        // 调整之后，重新计算平衡因子和树的深度
        root.balance = calcBalance(root);
        root.depth = calcDepth(root);
    }

    /**
     *  右旋
     */
    private void right_rotate(AVLNode p) {
        // 一次旋转涉及到的结点包括祖父，父亲，右儿子
        AVLNode pParent = p.parent;
        AVLNode pLeftSon = p.left;
        AVLNode pRightGrandSon = pLeftSon.right;
        // 左子变父
        pLeftSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left) {
                pParent.left = pLeftSon;
            } else if (p == pParent.right) {
                pParent.right = pLeftSon;
            }
        }
        pLeftSon.right = p;
        p.parent = pLeftSon;
        // 右孙变左孙
        p.left = pRightGrandSon;
        if (pRightGrandSon != null) {
            pRightGrandSon.parent = p;
        }
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);
        pLeftSon.depth = calcDepth(pLeftSon);
        pLeftSon.balance = calcBalance(pLeftSon);
    }

    /**
     * 左旋
     */
    private void left_rotate(AVLNode p) {
        // 一次选择涉及到的结点包括祖父，父亲，左儿子
        AVLNode pParent = p.parent;
        AVLNode pRightSon = p.right;
        AVLNode pLeftGrandSon = pRightSon.left;
        // 右子变父
        pRightSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.right) {
                pParent.right = pRightSon;
            } else if (p == pParent.left) {
                pParent.left = pRightSon;
            }
        }
        pRightSon.left = p;
        p.parent = pRightSon;
        // 左孙变右孙
        p.right = pLeftGrandSon;
        if (pLeftGrandSon != null) {
            pLeftGrandSon.parent = p;
        }
        p.depth = calcDepth(p);
        p.balance = calcBalance(p);
        pRightSon.depth = calcDepth(pRightSon);
        pRightSon.balance = calcBalance(pRightSon);
    }

    /**
     * 计算平衡
     */
    public int calcBalance(AVLNode p) {
        int left_depth;
        int right_depth;
        // 左子树深度
        if (p.left != null) {
            left_depth = p.left.depth;
        } else {
            left_depth = 0;
        }
        // 右子树深度
        if (p.right != null) {
            right_depth = p.right.depth;
        } else {
            right_depth = 0;
        }
        return left_depth - right_depth;
    }

    /**
     * 计算深度
     */
    public int calcDepth(AVLNode p) {
        int depth = 0;
        if (p.left != null) {
            depth = p.left.depth;
        }
        if (p.right != null && depth < p.right.depth) {
            depth = p.right.depth;
        }
        depth++;
        return depth;
    }
}
