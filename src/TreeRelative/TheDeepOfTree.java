package TreeRelative;

public class TheDeepOfTree {


    public static void main(String[] args) {
    }
    public int maxDepthDeep(TreeNode root, int CurrentDeep) {//传入根节点

        //int currDeep =1;

        if (root.left== null && root.right ==null) return CurrentDeep;//首先如果树是空的，那就直接返回

        if (root.left != null){
            CurrentDeep++;
            maxDepthDeep(root.left,CurrentDeep);
        }

        if (root.right != null){
            CurrentDeep++;
            maxDepthDeep(root.right,CurrentDeep);
        }

        return CurrentDeep;
    }
    public int maxDepthDeep2(TreeNode root, int CurrentDeep) {//传入根节点

        int rightCurrentdeep = 1 ;
        int leftCurrentDeep = 1 ;
        int currDeep =1;
        if (root.left== null && root.right ==null) return 1;//首先如果树是空的，那就直接返回

//        int leftDept = leftDept(root, leftCurrentDeep);
//        int righttDept = righttDept(root, rightCurrentdeep);

        if (root.left != null){
            leftCurrentDeep++;
            maxDepthDeep(root.left,leftCurrentDeep);
        }

        if (root.right != null){
            rightCurrentdeep++;
            maxDepthDeep(root.right,leftCurrentDeep);
        }

        if (leftCurrentDeep > rightCurrentdeep ){//最后一波判断，遍历左边也遍历右边
            return leftCurrentDeep;
        }else {
            return rightCurrentdeep;
        }
    }
    public int maxDepthDeep3(TreeNode root, int CurrentDeep) {//传入根节点

        int LeftcurrDeep =1;
        int RightcurrDeep =1;

        if (root.left== null && root.right ==null) return CurrentDeep;//首先如果树是空的，那就直接返回

        leftDept(root.left,LeftcurrDeep);
        righttDept(root.right,RightcurrDeep);
        //maxDepthDeep3(root);
        return CurrentDeep;
    }


    public int maxDepth(TreeNode root) {//传入根节点

        int leftCurrentDeep = 1 ;
        int rightCurrentdeep = 1 ;
        //忘了考虑空的树
        if (root ==null) return 0;
        if (root.left== null && root.right ==null) return 1;//首先如果树是空的，那就直接返回

        if (root.left != null){
            leftCurrentDeep = leftCurrentDeep +  maxDepth(root.left);
        }

        if (root.right != null){
            rightCurrentdeep = rightCurrentdeep + maxDepth(root.right);
        }

        if (leftCurrentDeep > rightCurrentdeep ){//最后一波判断，遍历左边也遍历右边
            return leftCurrentDeep;
        }else {
            return rightCurrentdeep;
        }

    }



    public static int leftDept(TreeNode node , int leftCurrentDeep){
        if (node.left != null){
            leftCurrentDeep++;
            leftDept(node.left,leftCurrentDeep);
        }
        return leftCurrentDeep;
    }

    public static int righttDept(TreeNode node , int rightCurrentDeep){
        if (node.right != null){
            rightCurrentDeep++;
            leftDept(node.right,rightCurrentDeep);
        }
        return rightCurrentDeep;
    }


}