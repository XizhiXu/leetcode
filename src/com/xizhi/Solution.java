package com.xizhi;

import java.util.Arrays;

public class Solution {
    public static int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int digit = 0;
        for (; tmp > 0; tmp >>= 1) {
            digit += (tmp & 1) > 0 ? 1 : 0;
        }
        return digit;
    }

    public static boolean judgeCircle(String moves) {
        int v = 0;
        int h = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
            }
        }
        return v == 0 && h == 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        } else {
            return t1 == null ? t2 : t1;
        }
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i * 2];
        }
        return sum;
    }
}
