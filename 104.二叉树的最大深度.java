/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.ArrayList;

/**
 * 思路：找最大深度，因此使用深度优先中的后序遍历整棵树，从子树开始由下到上加一（返回左右树中较深那个）
 * Solution
 */
class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0; // 步骤1：基准情况

    int leftDepth = maxDepth(root.left); // 步骤2：问左孩子要答案
    int rightDepth = maxDepth(root.right); // 步骤3：问右孩子要答案

    return Math.max(leftDepth, rightDepth) + 1; // 步骤4：判断左右最大并加上自己这一层
  }
}
// @lc code=end
