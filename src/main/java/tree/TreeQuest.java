package tree;

public class TreeQuest {

    public static void main(String[] args) {
        TreeNode tree = buildTree1();
        TreeNode cloneTree  = cloneTree(tree);
        System.out.println(cloneTree);
      /*  int maxLen = longestConsLength(tree, 1, 1);
        System.out.println(maxLen);
        int immaxLen = immediateLongestConsLength(tree, 1, 1);
        System.out.println(immaxLen);*/

    }

    private static Boolean checkPreOrder(TreeNode root, int[] arr,int i, int len){
        for (int j = i; j < len; j++) {
            if (arr[j] > root.getData()){
                return checkPreOrder(new TreeNode(arr[j]), arr,j,len) ||
                        checkPreOrder(new TreeNode(arr[i]),arr,i,j-1);
            }
        }
        return null;
    }

    private static TreeNode cloneTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode treeNode = new TreeNode(root.data);
        treeNode.left = cloneTree(root.left);
        treeNode.right = cloneTree(root.right);
        return treeNode;
    }

    /*private static int longestConsLength(TreeNode root, int length, int max) {
        if (root == null)
            return 0;
        int curr_length = length;
        if (root.left != null && root.left.getData() > root.getData())
            curr_length++;
        if (root.right != null && root.right.getData() > root.getData()){
            if (curr_length == length)
                curr_length++;
        }

        if (max < curr_length)
            max = curr_length;

        int left = longestConsLength(root.left, curr_length ,max);
        int right = longestConsLength(root.right, curr_length ,max);
        curr_length = left > right ? left : right;
        if (max < curr_length)
            max = curr_length;

        return max;
    }

    private static int immediateLongestConsLength(TreeNode root, int length, int max) {
        if (root == null)
            return 0;
        int curr_length = length;
        int left_length = length;
        int right_length = length;
        if (root.left != null && root.left.getData() == root.getData()+1)
            left_length++;
        if (root.right != null && root.right.getData() == root.getData()+1){
            right_length++;
        }

        curr_length = left_length > right_length ? left_length : right_length;
        if (max < curr_length)
            max = curr_length;

        int left = immediateLongestConsLength(root.left, left_length ,max);
        int right = immediateLongestConsLength(root.right, right_length ,max);
        curr_length = left > right ? left : right;
        if (max < curr_length)
            max = curr_length;

        return max;
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(6);
        TreeNode right1 = new TreeNode(9);
        TreeNode right2 = new TreeNode(10);
        TreeNode left1 = new TreeNode(7);
        TreeNode right3 = new TreeNode(11);
        root.right = right1;
        right1.right = right2;
        right2.left = left1;
        right2.right = right3;
        return root;
    }
*/
    private static TreeNode buildTree1() {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        TreeNode left3 = new TreeNode(5);
        TreeNode right2 = new TreeNode(6);
        TreeNode right3 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        left1.left =left2;
        left2.left = new TreeNode(8);
        right1.left = left3;
        right1.right = right2;
        right2.right = right3;
        return root;
    }
}
