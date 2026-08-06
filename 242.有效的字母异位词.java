/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

/**
 * 思路：长小写字母字符串间进行异位词匹配，即同一个字母出现相同次数
 * 把字母映射到26个桶的hash中，f(x)=x % 26
 * 然后比较两个hash表中桶的元素数量
 * 
 * Solution
 */
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false; // 提前剪枝

    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++; // 使用char的ASCII码减'a'的ASCII码得到index，用于加
    }
    for (char c : t.toCharArray()) {
      count[c - 'a']--; // 减
    }
    for (int num : count) { // 若数组每位都为0，则两个字符串的字母异位
      if (num != 0)
        return false;
    }
    return true;
  }
}
// @lc code=end
