/*
 * @lc app=leetcode.cn id=66 lang=java
 * 
 * [66] 加一
 */

/*
 * 题型：高精度计算（大数模拟）/ 数组线性遍历（进位状态）
 *
 * 实际应用：
 * - 金融系统超长订单号/流水号的自增运算（超出Long范围）
 * - BigInteger底层大整数加法的雏形
 * - 数字电路加法器的软件模拟
 *
 * 解题思路推导：
 * 1. 数组长度最大100，不能整体转数值计算，必须直接操作数组。
 * 2. 模拟手算竖式，从数组末尾（个位）开始逆序遍历处理进位。
 * 3. 关键优化：只有数字9加1才会进位。
 *    - 若当前位是9，加1后该位归0，继续处理前一位（循环）。
 *    - 若当前位不是9，直接加1并立即返回，因为高位不受影响。
 * 4. 若循环正常结束（未触发返回），说明数组全为9。
 *    此时创建新数组长度+1，最高位设为1，其余低位默认为0。
 *
 * 时间复杂度：O(n)    空间复杂度：O(1)（最坏扩容时为O(n)）
 */
// @lc code=start

/**
 * 个人思路：末位加1并判断是否为10，为10则进位，逐个向高位判断是否为10
 * 错误1
 */
// class Solution {
//   public int[] plusOne(int[] digits) {
//     // 获取数组长度以及最后一个元素的下标
//     int listLong = digits.length;
//     System.out.println("listLong = " + listLong);
//     int lastTarget = 0;
//     if (listLong > 0) {
//       lastTarget = listLong - 1;
//       System.out.println("lastTarget = " + lastTarget);
//     }

//     // 从最后一个元素加1并往前遍历判断
//     digits[lastTarget] += 1;
//     if (digits[lastTarget] == 10) {
//       digits[lastTarget] = 1; // 进位后当前位赋值错误，应赋值为0
//       do {
//         lastTarget -= 1; // 循环前 lastTarget 递减导致索引越界
//         digits[lastTarget] += 1;
//       } while (digits[lastTarget] == 10);
//     }
//     // 没有处理数组扩容，比如输入比如[9,9]
//     return digits;
//   }
// }

/**
 * 个人思路：末位加1并判断是否为10，为10则进位，逐个向高位判断是否为10
 * 通过
 */
// class Solution {
//   public int[] plusOne(int[] digits) {
//     int n = digits.length;
//     // 从最后一位开始向前遍历
//     for (int i = n - 1; i >= 0; i--) {
//       digits[i]++; // 当前位加 1
//       if (digits[i] < 10) { // 如果加 1 后小于 10，说明没有进位，直接返回原数组（因为更高位不变）。
//         return digits;
//       }
//       digits[i] = 0; // 出if说明有进位，当前位归零，继续处理前一位（for循环进位）
//     }
//     // 循环结束说明所有位都是 9，需要扩容
//     int[] result = new int[n + 1];
//     result[0] = 1;
//     return result;
//   }
// }

/**
 * 优化思路：向高位判断是否为9，为9则赋值为0并向前进位
 * 通过
 */
// class Solution {
//   public int[] plusOne(int[] digits) {
//     int n = digits.length;
//     for (int i = n - 1; i >= 0; i--) {
//       if (digits[i] == 9) {
//         digits[i] = 0;
//       } else {
//         digits[i] += 1;
//         return digits;
//       }
//     }
//     int[] ans = new int[n + 1];
//     ans[0] = 1;
//     return ans;
//   }
// }
// @lc code=end
