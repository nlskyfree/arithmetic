package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Print Binary Tree
* Print a binary tree in an m*n 2D string array following these rules:
* 
* The row number m should be equal to the height of the given binary tree.
* The column number n should always be an odd number.
* The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the  * root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). 
* You should print the left subtree in the  left-bottom part and print the right subtree in the right-bottom part. 
* The left-bottom part and the right-bottom part should have the same size . 
* Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to 
* leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
* Each unused space should contain an empty string "".
* Print the subtrees following the same rules.
* Example 1:
* Input:
*      1
*     /
*    2
* Output:
* [["", "1", ""],
*  ["2", "", ""]]
* Example 2:
* Input:
*      1
*     / \
*    2   3
*     \
*      4
* Output:
* [["", "", "", "1", "", "", ""],
*  ["", "2", "", "", "", "3", ""],
*  ["", "", "4", "", "", "", ""]]
* Example 3:
* Input:
*       1
*      / \
*     2   5
*    / 
*   3 
*  / 
* 4 
* Output:
* 
* [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
*  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
*  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
*  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
* Note: The height of binary tree is in the range of [1, 10].
* 思路：首先计算树的高度，可知二维数组为height * (2^height - 1)
*     层序遍历树(空节点也遍历)，得到当前level，与当前点在当前层次排第i个
*     根据公司size / (int)Math.pow(2, level) + i * (size / (int)Math.pow(2, level - 1)) + i计算处于第几列
* @author 倪路
*/
public class LeetCode_655_Print_Binary_Tree {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int size = (int)Math.pow(2, height) - 1;
        List<List<String>> res = new ArrayList<>(height);
        for(int i = 0 ; i < height ; i++) {
            List<String> list = new ArrayList<>(size);
            res.add(list);
            for(int j = 0 ; j < size ; j++) {
                list.add("");
            }
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int level = 1;
        while(queue.size() != 0) {
            int len = queue.size();
            List<String> list = res.get(level - 1);
            for(int i = 0 ; i < len ; i++) {
                TreeNode temp = queue.removeLast();
                if(level != height) {
                    queue.addFirst(temp == null ? null : temp.left);
                    queue.addFirst(temp == null ? null : temp.right);
                }
                list.set(size / (int)Math.pow(2, level) + i * (size / (int)Math.pow(2, level - 1)) + i, temp == null ? "" : temp.val + "");
            }
            level++;
        }
        
        return res;
    }
    
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
