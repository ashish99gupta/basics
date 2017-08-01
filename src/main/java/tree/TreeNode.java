package tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int data ){
        this.data = data;
    }
}
