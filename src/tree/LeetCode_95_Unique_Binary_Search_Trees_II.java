package tree;

import java.util.ArrayList;
import java.util.List;

/**
* 题目：Unique Binary Search Trees II
* Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
* 
* Example:
* Input: 3
* Output:
* [
*   [1,null,3,2],
*   [3,2,null,1],
*   [3,1,null,null,2],
*   [2,1,3],
*   [1,null,2,null,3]
* ]
* Explanation:
* The above output corresponds to the 5 unique BST's shown below:
* 
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
* 思路：1-n任意点作为root，将数组分为1，i - 1和i+1，n两部分，对左右子树递归处理。
*     左子树有n种组合，右子树有m种组合，则一共有n*m种组合
* 注意：左子树多种情况，右子树多种情况下如果返回后遍历组合所有情况加入结果集
*     左子树为空时，要返回一种情况，否则会造成乘机为0
* @author 倪路
*/
public class LeetCode_95_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
            return res;
        }
        
        for(int i = start ; i <= end ; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        
        return res;
    }
}
