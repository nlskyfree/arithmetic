package tree;

/**
* 题目：Construct String from Binary Tree
* You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
* 
* The null node needs to be represented by empty parenthesis pair "()". 
* And you need to omit all the empty parenthesis pairs that don't affect the  
* one-to-one mapping relationship between the string and the original binary tree. * 
* 
* Example 1:
* Input: Binary tree: [1,2,3,4]
*        1
*      /   \
*     2     3
*    /    
*   4     
* Output: "1(2(4))(3)"
* Explanation: Originallay it needs to be "1(2(4)())(3()())", 
* but you need to omit all the unnecessary empty parenthesis pairs. 
* And it will be "1(2(4))(3)".
* Example 2:
* Input: Binary tree: [1,2,3,null,4]
*        1
*      /   \
*     2     3
*      \  
*       4 
* Output: "1(2()(4))(3)"
* Explanation: Almost the same as the first example, 
* except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
* 思路：本质是分治，关键是分析清楚是否有左子树，是否有右子树，4种组合情况下的打印方案
* @author 倪路
*/
public class LeetCode_606_Construct_String_from_Binary_Tree {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2str(t, sb);
        return sb.toString();
    }
    
    public void tree2str(TreeNode t, StringBuilder sb) {
        if(t == null) {
            return;
        }
        
        sb.append(t.val);
        if(t.right != null) {
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")(");
            tree2str(t.right, sb);
            sb.append(")");
        } else if(t.left != null) {
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
        }
    }
}
