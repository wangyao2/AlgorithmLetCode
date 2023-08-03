package TreeRelative;

public class IsASearchTree {

    public static void main(String[] args) {


        //if (root.left ==null && root.right.val > root.val) return true;//只有一个节点那肯定就是符合条件的
        //if (root.right ==null && root.left.val < root.val) return true;//只有一个节点那肯定就是符合条件的

    }


    public static boolean isValidBST(TreeNode root){
        boolean leftflag = false;
        boolean rightflag = false;
        if (root.left ==null && root.right ==null) return true;//只有一个节点那肯定就是符合条件的
        if (root.left ==null && root.right.val > root.val && root.right.left==null && root.right.right ==null) return true;//处理只有两个节点的情况
        if (root.right ==null && root.left.val < root.val && root.left.left==null && root.left.right ==null) return true;//处理只有两个节点的情况


        if (root.left !=null  && root.left.val < root.val){
            leftflag = isValidBST(root.left);
        }

        if (root.right !=null  && root.right.val > root.val){
            rightflag = isValidBST(root.right);
        }

        return leftflag && rightflag;
    }
}
