/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

/**
 * 核心思路：最近出现的左括号，必须最先被匹配，符合“后进先出”的特点，所以用栈作为基本结构
 * 实现思路：新建左括号栈，遍历String，左括号则入栈，遇到右括号则pop栈进行匹配
 * 匹配情况：
 * 如果栈为空 → 说明没有可匹配的左括号，返回 false。
 * 如果栈顶左括号和当前右括号不是同一类型 → 返回 false
 * 如果匹配 → 弹出栈顶，继续处理。
 * 遍历结束：
 * 如果栈为空 → 所有括号都正确匹配，返回 true。
 * 如果栈不为空 → 说明还有未闭合的左括号，返回 false。
 * 
 * Solution
 */
class Solution {
  public boolean isValid(String s) {
    // 如果长度为奇数，直接返回 false
    if (s.length() % 2 == 1) {
      return false;
    }

    // 使用Deque作为栈
    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {
      // 若是左括号，入栈
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else {
        // 若是右括号，匹配栈顶元素
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if (ch == ')' && top != '(')
          return false;
        if (ch == ']' && top != '[')
          return false;
        if (ch == '}' && top != '{')
          return false;
      }
    }

    return stack.isEmpty();

  }
}
// @lc code=end
