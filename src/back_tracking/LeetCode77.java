package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr. Ye
 * @description: LeetCode77.组合(https://leetcode.cn/problems/combinations/description/)
 *               —— 中等
 *               1. 确定递归函数的参数和返回值；
 *               2. 确定递归函数的终止条件；
 *               3. 确定单层递归的逻辑；
 * @createDate: 2024/08/14
 */
public class LeetCode77 {

    private static List<List<Integer>> result = new ArrayList();
    private static List<Integer> path = new ArrayList();

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private static void backtracking(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            // 收集结果(注意：不能直接将path放进result中，path是引用类型)
            result.add(new ArrayList(path));
            return;
        }
        // 单层递归逻辑
        for (int i = startIndex; i <= n; i++) {
            // 处理节点
            path.add(i);
            // 递归
            backtracking(n, k, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
