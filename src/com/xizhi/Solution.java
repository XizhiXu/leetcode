package com.xizhi;

import java.util.*;

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

    public static int findComplement(int num) {
        int tmp = num;
        int com = 0;
        int digit = 1;
        for (; tmp > 0; tmp >>= 1) {
            com += (tmp & 1) > 0 ? 0 : digit;
            digit <<= 1;
        }

        return com;
    }

    public static String[] findWords(String[] words) {
        final String[] row = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        final List<String> r = new ArrayList<>();

        for (String s : words) {
            int flag = -1;
            for (char c : s.toCharArray()) {
                int match = -1;
                for (int i = 0; i < 3; i++) {
                    if (row[i].indexOf(Character.toLowerCase(c)) >= 0) {
                        match = i;
                        break;
                    }
                }

                if (match >= 0) {
                    if (flag >= 0) {
                        if (match != flag) {
                            flag = -1;
                            break;
                        }
                    } else {
                        flag = match;
                    }
                } else {
                    flag = -1;
                    break;
                }
            }

            if (flag >= 0) {
                r.add(s);
            }
        }

        return r.toArray(new String[r.size()]);
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuilder(split[i]).reverse().toString();
        }
        return String.join(" ", split);
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : candies) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        return Math.min(candies.length / 2, map.size());
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int size = 0;
        for (int[] arr : nums) {
            size += arr.length;
        }

        if (r * c != size) {
            return nums;
        } else {
            int[][] ans = new int[r][c];
            int x = 0;
            int y = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = nums[x][y];
                    y++;
                    if (y >= nums[x].length) {
                        x++;
                        y = 0;
                    }
                }
            }
            return ans;
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                l.add("FizzBuzz");
            } else if (i % 3 == 0) {
                l.add("Fizz");
            } else if (i % 5 == 0) {
                l.add("Buzz");
            } else {
                l.add(String.valueOf(i));
            }
        }
        return l;
    }

    public static int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        ans++;
                    }
                    if (i + 1 == grid.length || grid[i + 1][j] == 0) {
                        ans++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        ans++;
                    }
                    if (j + 1 == grid[i].length || grid[i][j + 1] == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            boolean flag = false;
            for (int j = 0; j < nums2.length; j++) {
                if (flag) {
                    if (nums2[j] > nums1[i]) {
                        ans[i] = nums2[j];
                        break;
                    }
                } else {
                    flag = nums1[i] == nums2[j];
                }
            }
        }
        return ans;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<TreeNode> tmp;
        List<TreeNode> layer = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        layer.add(root);
        while (layer.size() > 0) {
            int size = layer.size();
            double sum = 0;
            for (TreeNode node : layer) {
                sum += node.val;
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            ans.add(sum / size);
            layer.clear();
            tmp = next;
            next = layer;
            layer = tmp;
        }
        return ans;
    }

    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int prev = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, i - prev - 1);
                prev = i;
            }
        }

        return Math.max(ans, nums.length - prev - 1);
    }

    public int maxDepth(TreeNode root) {
        int ans = 0;
        List<TreeNode> tmp;
        List<TreeNode> layer = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        if (root != null) {
            layer.add(root);
        }
        while (layer.size() > 0) {
            ans++;
            for (TreeNode node : layer) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            layer.clear();
            tmp = next;
            next = layer;
            layer = tmp;
        }
        return ans;
    }

    public static boolean detectCapitalUse(String word) {
        boolean first = false;
        boolean always = false;
        for (int i = 0; i < word.length(); i++) {
            boolean capital = Character.isUpperCase(word.charAt(i));
            if (i == 0) {
                first = capital;
            } else if (i == 1) {
                if (!first && capital) {
                    return false;
                } else {
                    always = capital;
                }
            } else {
                if (always ^ capital) {
                    return false;
                }
            }
        }
        return true;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(tmp);
        }
        return root;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) nums[(nums[i] - 1) % nums.length] += nums.length;
        for (int i = 0; i < nums.length; i++) if (nums[i] <= nums.length) ans.add(i + 1);
        return ans;
    }

    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }

    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> a = new ArrayList<>();
        traverse(a, root);
        for (int i = 0; i < a.size(); i++) {
            int remain = k - a.get(i);
            for (int j = 0; j < a.size(); j++) {
                if (j != i && a.get(j) == remain) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void traverse(List<Integer> a, TreeNode node) {
        if (node == null) return;
        traverse(a, node.left);
        a.add(node.val);
        traverse(a, node.right);
    }

    public static char findTheDifference(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        for (char c : t.toCharArray()) {
            int index = sb.toString().indexOf(c);
            if (index >= 0) {
                sb.deleteCharAt(index);
            } else {
                return c;
            }
        }

        return sb.charAt(0);
    }

    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.isEmpty() && right.isEmpty()) {
            return String.valueOf(t.val);
        } else if (right.isEmpty()) {
            return String.valueOf(t.val) + "(" + left + ")";
        } else {
            return String.valueOf(t.val) + "(" + left + ")(" + right + ")";
        }
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        postOrder(a, root);
        for (int i = 1; i < a.size(); i++) {
            a.get(i).val += a.get(i - 1).val;
        }
        return root;
    }

    public static void postOrder(List<TreeNode> a, TreeNode node) {
        if (node == null) return;
        postOrder(a, node.right);
        a.add(node);
        postOrder(a, node.left);
    }

    public static int[] constructRectangle(int area) {
        int r = (int) Math.sqrt(area);
        for (int w = r; w > 0; w--) {
            int l = area / w;
            if (w * l == area) {
                return new int[]{l, w};
            }
        }

        return new int[]{area, 1};
    }

    public static int maxCount(int m, int n, int[][] ops) {
        int a = m;
        int b = n;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }

        return a * b;
    }

    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }

        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }

        return sum;
    }

    public static int[][] imageSmoother(int[][] M) {
        int[] offset = {-1, 0, 1};
        int[][] ans = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                double sum = 0;
                int count = 0;
                for (int v = 0; v < 3; v++) {
                    for (int h = 0; h < 3; h++) {
                        int x = i + offset[v];
                        int y = j + offset[h];
                        if (x >= 0 && x < M.length && y >= 0 && y < M[i].length) {
                            sum += M[x][y];
                            count++;
                        }
                    }
                }

                ans[i][j] = (int) Math.floor(sum / count);
            }
        }

        return ans;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int x = 0;
        int y = 0;
        while (x < nums1.length && y < nums2.length) {
            while (x < nums1.length && nums1[x] < nums2[y]) {
                x++;
            }

            if (x >= nums1.length) {
                break;
            }
            while (y < nums2.length && nums1[x] > nums2[y]) {
                y++;
            }

            if (y >= nums2.length) {
                break;
            }
            if (nums1[x] == nums2[y]) {
                ans.add(nums1[x]);
                x++;
                y++;
                while (x < nums1.length && nums1[x - 1] == nums1[x]) x++;
                while (y < nums2.length && nums2[y - 1] == nums2[y]) y++;
            }
        }

        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }

        return a;
    }

    public static int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) node = node.left;
            min = Math.min(min, Math.abs(node.val - root.val));
            min = Math.min(getMinimumDifference(root.right), min);
        }

        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) node = node.right;
            min = Math.min(min, Math.abs(node.val - root.val));
            min = Math.min(getMinimumDifference(root.left), min);
        }

        return min;
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum *= 26;
            sum += s.charAt(i) - 64;
        }

        return sum;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];

        for (char c : ransomNote.toCharArray()) {
            r[c - 97]++;
        }

        for (char c : magazine.toCharArray()) {
            m[c - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (m[i] < r[i]) return false;
        }

        return true;
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            for (; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    j++;
                    break;
                }
            }
        }

        return count;
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length && numbers[j] + numbers[i] <= target; j++) {
                if (numbers[j] + numbers[i] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] >= prices[i]) ans += prices[i + 1] - prices[i];
        }
        return ans;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root.left;
        return node != null && node.left == null && node.right == null ? node.val + sumOfLeftLeaves(root.right) : sumOfLeftLeaves(node) + sumOfLeftLeaves(root.right);
    }

    public static int findTilt(TreeNode root) {
        if (root == null) return 0;
        int ans = findTilt(root.left) + findTilt(root.right);
        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        root.val += left + right;
        return ans + Math.abs(left - right);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < min) {
                        min = i + j;
                        ans.clear();
                    }
                    if (i + j == min) {
                        ans.add(list1[i]);
                    }
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!flag[i]) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (!flag[j] && s.charAt(i) == s.charAt(j)) {
                        flag[i] = true;
                        flag[j] = true;
                    }
                }
                if (!flag[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean pnull = p == null;
        boolean qnull = q == null;
        return pnull == qnull && (pnull || p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static String[] findRelativeRanks(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        qsort(0, nums.length - 1, index, nums);

        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < 3) {
                ans[index[i]] = medals[i];
            } else {
                ans[index[i]] = String.valueOf(i + 1);
            }
        }

        return ans;
    }

    public static void qsort(int l, int r, int[] index, int[] nums) {
        if (l >= r) return;

        int x = l;
        int y = r;
        int pivot = index[l];

        while (x < y) {
            while (x < y && nums[index[y]] <= nums[pivot]) y--;
            index[x] = index[y];
            while (x < y && nums[index[x]] > nums[pivot]) x++;
            index[y] = index[x];
        }

        index[x] = pivot;
        qsort(l, y - 1, index, nums);
        qsort(x + 1, r, index, nums);
    }

    public static boolean isAnagram(String s, String t) {
        int[] a = new int[26];

        for (char c : s.toCharArray()) a[c - 'a']++;
        for (char c : t.toCharArray()) a[c - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    sum += 4;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    sum += 9;
                    i++;
                } else {
                    sum++;
                }
            }
            if (c == 'V') sum += 5;
            if (c == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    sum += 40;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    sum += 90;
                    i++;
                } else {
                    sum += 10;
                }
            }
            if (c == 'L') sum += 50;
            if (c == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    sum += 400;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    sum += 900;
                    i++;
                } else {
                    sum += 100;
                }
            }
            if (c == 'D') sum += 500;
            if (c == 'M') sum += 1000;
        }

        return sum;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = ans;
            ans = head;
            head = tmp;
        }

        return ans;
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[52];
        for (char c : s.toCharArray()) count[Character.isUpperCase(c) ? c - 'A' : c - 'a' + 26]++;

        int ans = 0;
        boolean odd = false;
        for (int i = 0; i < 52; i++) {
            if ((count[i] & 1) == 0) {
                ans += count[i];
            } else {
                ans += count[i] - (odd ? 1 : 0);
                odd = true;
            }
        }

        return ans;
    }

    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static int numberOfBoomerangs(int[][] points) {
        long[][] m = new long[points.length][points.length];
        Map<Long, Long> d = new HashMap<>();
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    m[i][j] = m[j][i];
                } else {
                    int dx1 = points[i][0] - points[j][0];
                    int dy1 = points[i][1] - points[j][1];
                    m[i][j] = dx1 * dx1 + dy1 * dy1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d.containsKey(m[i][j])) {
                    long c = d.get(m[i][j]);
                    d.put(m[i][j], c + 1);
                } else {
                    d.put(m[i][j], 1L);
                }
            }

            for (long l : d.values()) {
                ans += l * (l - 1);
            }
            d.clear();
        }

        return ans;
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    ans.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return ans;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) i++;
            if (!(i < nums1.length && j < nums2.length)) break;
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            while (i < nums1.length && j < nums2.length && nums2[j] < nums1[i]) j++;
            if (!(i < nums1.length && j < nums2.length)) break;
            if (nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] a = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) a[i] = ans.get(i);
        return a;
    }

    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean n = num < 0;

        num = Math.abs(num);
        if (num != 0) {
            while (num > 0) {
                sb.append(String.valueOf(num % 7));
                num /= 7;
            }
        } else {
            sb.append("0");
        }

        if (n) sb.append('-');
        return sb.reverse().toString();
    }

    public static int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int n : nums) sum -= n;
        return sum;
    }

    public static boolean checkRecord(String s) {
        int firstA = s.indexOf("A");
        int secondA = s.lastIndexOf("A");
        return !((firstA >= 0 && secondA >= 0 && firstA != secondA) || (s.contains("LLL")));
    }

    // TODO
    public static int checkRecord(int n) {
        final int MOD = 1000000007;
        final int L = 0;
        final int P = 1;

        if (n == 1) return 3;
        if (n == 2) return 8;
        int[][] f = new int[2][2];
        for (int i = 0; i < 4; i++) f[i >> 1][i & 1] = 1;

        int[][] f1 = new int[2][2];
        for (int i = 0; i < n - 2; i++) {
            f1 = f;
            f = new int[2][2];
            f[L][L] = f1[P][L] % MOD;
            f[L][P] = (f1[P][L] + f1[L][L]) % MOD;
            f[P][L] = (f1[L][P] + f1[P][P]) % MOD;
            f[P][P] = (f1[L][P] + f1[P][P]) % MOD;
        }

        int ans = 0;
        int ans1 = 0;
        for (int i = 0; i < 4; i++) {
            ans1 = (ans1 + f1[i >> 1][i & 1]) % MOD;
            ans = (ans + f[i >> 1][i & 1]) % MOD;
        }
        return ((ans1 * n) % MOD + ans) % MOD;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (preOrder(root) >> 16) - 1;
    }

    public static int preOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = preOrder(root.left);
        int r = preOrder(root.right);
        int lm = l >> 16;
        int lx = l & 0xffff;
        int rm = r >> 16;
        int rx = r & 0xffff;
        int x = Math.max(lx, rx) + 1;
        int m = Math.max(Math.max(lm, rm), lx + rx + 1);
        return (x & 0xffff) | (m << 16);
    }

    public static String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((i / k & 1) == 0) {
                buf.append(s.charAt(i));
            } else {
                if (buf.length() > 0) {
                    ans.append(buf.reverse());
                    buf.setLength(0);
                }
                ans.append(s.charAt(i));
            }
        }

        if (buf.length() > 0) {
            ans.append(buf.reverse());
        }

        return ans.toString();
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(0 < mid ? Arrays.copyOfRange(nums, 0, mid) : null);
        root.right = sortedArrayToBST(mid < nums.length - 1 ? Arrays.copyOfRange(nums, mid + 1, nums.length) : null);
        return root;
    }

    public static int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int min = Integer.MAX_VALUE;

        while (q.size() > 0) {
            TreeNode n = q.remove();
            if (n.val > root.val && n.val < min) {
                min = n.val;
            }
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }

        StringBuilder ans = new StringBuilder();
        int l1 = num1.length();
        int l2 = num2.length();
        int l = 0;
        int carry = 0;
        while (l < l1) {
            int a = num1.charAt(l1 - l - 1) - '0';
            int b = l2 <= l ? 0 : num2.charAt(l2 - l - 1) - '0';
            int s = a + b + carry;
            carry = s / 10;
            ans.append((char) (s % 10 + '0'));
            l++;
        }

        if (carry > 0 || ans.length() == 0) {
            ans.append((char) (carry + '0'));
        }

        return ans.reverse().toString();
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(prices[i] - min, ans);
        }

        return ans;
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 && num != 0; i++) {
            int digit = num & 0xf;
            num >>= 4;
            sb.append(digit < 10 ? (char) (digit + '0') : (char) (digit - 10 + 'a'));
        }

        return sb.reverse().toString();
    }

    public static int findLHS(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int ans = 0;
        int prev = nums[0];
        int prevCount = 0;
        for (int i = 0; i < nums.length; ) {
            int a = nums[i];
            int c = 0;
            while (i < nums.length && nums[i] == a) {
                i++;
                c++;
            }
            ans = Math.max(ans, a - prev == 1 ? prevCount + c : 0);
            prev = a;
            prevCount = c;
        }

        return ans;
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = doHappy(slow);
            fast = doHappy(doHappy(fast));
        } while (slow != fast);

        return fast == 1;
    }

    public static int doHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null || s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static int[] findErrorNums(int[] nums) {
        int dup = 0;
        int mis = 0;
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) dup = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) mis = i + 1;
        }
        return new int[]{dup, mis};
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> s = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root == null) return s;
        q.add(root);

        do {
            List<Integer> layer = new ArrayList<>();
            while (q.size() > 0) {
                TreeNode node = q.remove();
                layer.add(node.val);
                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }
            s.add(layer);
            q.addAll(q2);
            q2.clear();
        } while (q.size() > 0);

        Collections.reverse(s);
        return s;
    }

    public static boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
        // return n>0 && (n&(n-1))==0;
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathExtend(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int pathExtend(TreeNode root, int sum) {
        if (root == null) return 0;
        return (sum == root.val ? 1 : 0) + pathExtend(root.left, sum - root.val) + pathExtend(root.right, sum - root.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            while (tmp != null && tmp.val == p.val) tmp = tmp.next;
            p.next = tmp;
            p = tmp;
        }
        return head;
    }

    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }

    public static int maxSubArray(int[] nums) {
        int f = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(nums[i] + f, nums[i]);
            ans = Math.max(ans, f);
        }

        return ans;
    }

    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        while ((num & 1) == 0) num >>= 1;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static int removeElement(int[] nums, int val) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                offset++;
            } else if (offset > 0) {
                nums[i - offset] = nums[i];
            }
        }

        return nums.length - offset;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            p.next = l1;
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                p = p.next;
                l1 = l1.next;
            }
            p.next = l2;
            while (l1 != null && l2 != null && l2.val <= l1.val) {
                p = p.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = p.val > q.val ? p : q;
        TreeNode b = p.val < q.val ? p : q;
        if (root == null) return null;
        if ((root.val == a.val && root.val > b.val) || (root.val == b.val && root.val < a.val) || (root.val < a.val && root.val > b.val)) {
            return root;
        } else {
            TreeNode r = lowestCommonAncestor(root.left, p, q);
            if (r != null) return r;
            r = lowestCommonAncestor(root.right, p, q);
            if (r != null) return r;
            return null;
        }
    }

    public static int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(b + nums[i], a);
            }
        }

        return Math.max(a, b);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode a, TreeNode b) {
        boolean anull = a == null;
        boolean bnull = b == null;
        if (anull ^ bnull) return false;
        if (anull && bnull) return true;

        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    public static int[] plusOne(int[] digits) {
        boolean carry = true;
        int i;
        for (i = digits.length - 1; i >= 0 && carry; i--) {
            int sum = (carry ? 1 : 0) + digits[i];
            digits[i] = sum % 10;
            carry = sum >= 10;
        }

        if (i < 0 && carry) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        } else {
            return digits;
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) row.set(j, row.get(j) + row.get(j + 1));
            all.add(new ArrayList<>(row));
        }
        return all;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> l = binaryTreePaths(root.left);
        List<String> r = binaryTreePaths(root.right);

        if (l.size() == 0 && r.size() == 0) return Arrays.asList(String.valueOf(root.val));

        List<String> m = new ArrayList<>();
        String node = String.valueOf(root.val) + "->";

        for (String s : l) {
            m.add(node + s);
        }

        for (String s : r) {
            m.add(node + s);
        }

        return m;
    }

    public String reverseVowels(String s) {
        List<Integer> index = new ArrayList<>();
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            char c = Character.toLowerCase(a[i]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                index.add(i);
            }
        }

        for (int i = 0; i < index.size() / 2; i++) {
            int x = index.get(i);
            int y = index.get(index.size() - 1 - i);
            char tmp = a[x];
            a[x] = a[y];
            a[y] = tmp;
        }

        return new String(a);
    }

    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static boolean isPerfectSquare(int num) {
        int i = 0;
        long sum = 0;
        while (sum < num) {
            sum += 2 * i + 1;
            i++;
        }
        return sum == num;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }

        return (max + 0.0d) / k;
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }

        StringBuilder r = new StringBuilder(s);
        StringBuilder p = new StringBuilder();

        while (r.length() > s.length() / 2) {
            p.append(r.charAt(0));
            r.deleteCharAt(0);
            if (s.equals(r.toString() + p.toString())) {
                return true;
            }
        }
        return false;
    }

    public static int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Map<Integer, Integer> m = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode n = q.remove();
            if (m.containsKey(n.val)) {
                m.put(n.val, m.get(n.val) + 1);
            } else {
                m.put(n.val, 0);
            }
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }

        int max = 0;
        List<Integer> r = new ArrayList<>();
        for (Map.Entry<Integer, Integer> c : m.entrySet()) {
            if (c.getValue() > max) {
                max = c.getValue();
                r.clear();
                r.add(c.getKey());
            } else if (c.getValue() == max) {
                r.add(c.getKey());
            }
        }

        return r.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<>();
        r.add(1);

        for (int i = 0; i < rowIndex; i++) {
            r.add(0, 1);
            for (int j = 1; j <= i; j++) {
                r.set(j, r.get(j) + r.get(j + 1));
            }
        }

        return r;
    }

    public static class MyQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return out.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (out.isEmpty())
                while (!in.isEmpty()) out.push(in.pop());
            return out.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    class MyStack {
        Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new LinkedList<Integer>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int size = q.size();
            q.add(x);
            for (int i = 0; i < size; i++) {
                q.offer(q.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    public static int countSegments(String s) {
        int sum = 0;
        for (String str : s.split("\\s+")) {
            sum += str.length() > 0 ? 1 : 0;
        }
        return sum;
    }

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(8.0d * n + 1) - 1) / 2);
    }

    public int trailingZeroes(int n) {
        int r = 0;
        int p = n;
        while (p > 0) {
            r += p / 5;
            p /= 5;
        }

        return r;
    }

    public static int guessNumber(int n) {
        long l = 1;
        long r = n;
        do {
            int mid = (int) ((l + r) / 2);
            int g = guess(mid);
            if (g == 0) {
                l = r = mid;
            } else if (g < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } while (l < r);
        return (int) l;
    }

    public static int guess(int n) {
        return Integer.compare(1702766719, n);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[sum++] = nums[i];
            }
        }

        return sum;
    }

    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        return x == r || x == r / 10;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode runner = head.next;
        while (head != null && runner != null && head != runner) {
            head = head.next;
            if (runner.next == null) {
                return false;
            } else {
                runner = runner.next.next;
            }
        }

        return head != null && runner != null;
    }

    public static String countAndSay(int n) {
        String s = String.valueOf(1);
        StringBuilder b = new StringBuilder();
        int num;
        int count;

        for (int i = 1; i < n; i++) {
            b.setLength(0);
            num = s.charAt(0) - '0';
            count = 1;
            for (int k = 1; k < s.length(); k++) {
                if ((s.charAt(k) - '0') != num) {
                    b.append(count);
                    b.append(num);
                    num = s.charAt(k) - '0';
                    count = 1;
                } else {
                    count++;
                }
            }
            b.append(count);
            b.append(num);
            s = b.toString();
        }

        return s;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null &&
                ((root.val == sum && root.left == null && root.right == null) ||
                        (root.left != null && hasPathSum(root.left, sum - root.val)) ||
                        (root.right != null && hasPathSum(root.right, sum - root.val)));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1; // can't be 0, 0 is the initial value
        }
        return true;
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            sum += num % i == 0 ? i + num / i : 0;
        }

        return sum == num;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] m = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            m[p.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += m[i] > 0 ? 1 : 0;
        }

        int index;
        for (int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                index = s.charAt(i - p.length()) - 'a';
                if (m[index] == 0) count++;
                m[index]++;
                if (m[index] == 0) count--;
            }
            index = s.charAt(i) - 'a';
            if (m[index] == 0) count++;
            m[index]--;
            if (m[index] == 0) count--;

            if (count == 0) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        Character p;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            p = stack.empty() ? null : stack.peek();
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (p != null && ((c == ')' && p == '(') || (c == ']' && p == '[') || (c == '}' && p == '{'))) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.min(root.left == null ? Integer.MAX_VALUE : minDepth(root.left), root.right == null ? Integer.MAX_VALUE : minDepth(root.right));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode rev = null;
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        for (int i = 0; i < len; i++)
            if (i < len / 2) {
                tmp = head.next;
                head.next = rev;
                rev = head;
                head = tmp;
            } else if (i == len / 2 && len % 2 == 1) {
                head = head.next;
            } else {
                if (rev.val != head.val) return false;
                rev = rev.next;
                head = head.next;
            }

        return true;
    }

    public static String addBinary(String a, String b) {
        StringBuilder ra = new StringBuilder(a).reverse();
        StringBuilder rb = new StringBuilder(b).reverse();

        StringBuilder r = new StringBuilder();
        int carry = 0;
        int ia, ib, sum;
        while (ra.length() > 0 || rb.length() > 0) {
            if (ra.length() > 0) {
                ia = ra.charAt(0) - '0';
                ra.deleteCharAt(0);
            } else {
                ia = 0;
            }
            if (rb.length() > 0) {
                ib = rb.charAt(0) - '0';
                rb.deleteCharAt(0);
            } else {
                ib = 0;
            }
            sum = carry + ia + ib;
            carry = (carry + ia + ib) >> 1;
            r.append((char) ((sum & 1) + '0'));
        }

        if (carry > 0) r.append("1");
        return r.reverse().toString();
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode h = null;
        ListNode t = null;
        while (head != null) {
            if (head.val != val) {
                if (h == null) {
                    h = t = head;
                } else {
                    t.next = head;
                    t = head;
                }
            }
            head = head.next;
        }

        if (t != null) {
            t.next = null;
        }
        return h;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) s.remove(nums[i - k - 1]);
            if (!s.add(nums[i])) return true;
        }

        return false;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) nums1[n + i] = nums1[i];

        int i = 0;
        int j = 0;
        int c = 0;
        while (i < m || j < n) {
            while (i < m && (j >= n || nums1[i + n] <= nums2[j])) nums1[c++] = nums1[i++ + n];
            while (j < n && (i >= m || nums2[j] <= nums1[i + n])) nums1[c++] = nums2[j++];
        }
    }

    public int lengthOfLastWord(String s) {
        String r = s.trim();
        int index = r.lastIndexOf(' ');
        return r.length() - (index >= 0 ? index + 1 : 0);
    }

    public static boolean judgeSquareSum(int c) {
        int k = 0;
        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
            k = (int) Math.sqrt(c - i * i);
            if (i * i + k * k == c) {
                return true;
            }
        }

        return false;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int k = 0;

        while (true) {
            for (int i = 0; i < strs.length; i++) if (k >= strs[i].length()) return sb.toString();
            char c = strs[0].charAt(k);
            for (int i = 0; i < strs.length; i++) if (strs[i].charAt(k) != c) return sb.toString();
            sb.append(c);
            k++;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = calLen(headA);
        int lenB = calLen(headB);

        for (int i = 0; i < Math.abs(lenA - lenB); i++)
            if (lenA > lenB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static int calLen(ListNode head) {
        int k = 0;
        while (head != null) {
            k++;
            head = head.next;
        }

        return k;
    }

    public static int findNthDigit(int n) {
        int d = 0;
        long k = 9;
        int l = 1;
        int s = 0;
        while (d + k * l < n) {
            d += k * l;
            s += k;
            k = k * 10;
            l++;
        }

        k = (int) Math.floor((n - d - 1) / l);
        s += 1 + k;

        return Integer.toString(s).charAt((n - d - 1) % l) - '0';
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k = 0;
        int sum = 0;
        for (int i = 0; i <= flowerbed.length; i++) {
            if (i >= flowerbed.length || flowerbed[i] == 1) {
                sum += (k + 1) / 2;
                k = 0;
            } else if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                k++;
            }
        }
        return sum >= n;
    }

    class NumArray {
        int[] a;

        public NumArray(int[] nums) {
            a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) a[i] += nums[i] + (i == 0 ? 0 : a[i - 1]);
        }

        public int sumRange(int i, int j) {
            return a[j] - (i == 0 ? 0 : a[i - 1]);
        }
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0;
        int j = 0;
        int max = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1 && (heaters[j + 1] < houses[i] || (heaters[j] < houses[i] && houses[i] - heaters[j] >= heaters[j + 1] - houses[i])))
                j++;
            max = (int) Math.max(Math.abs(houses[i] - heaters[j]), max);
            i++;
        }

        return max;
    }

    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static int findUnsortedSubarray(int[] nums) {
        int l = -1;
        int r = -2;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - 1 - i] > min) {
                l = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }

        return r - l + 1;
    }

    static class MinStack {
        Stack<Integer> s;
        List<Integer> h;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            s = new Stack<>();
            h = new ArrayList<>();
        }

        public void push(int x) {
            s.push(x);
            add(x);
        }

        public void pop() {
            remove(s.pop());
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return h.get(0);
        }

        public void add(int x) {
            h.add(x);
            int k = h.size() - 1;
            while (k > 0 && h.get((k - 1) / 2) > x) {
                h.set(k, h.get((k - 1) / 2));
                k = (k - 1) / 2;
            }
            h.set(k, x);
        }

        public void remove(int x) {
            int k;
            int next;
            for (next = 0; next < h.size(); next++)
                if (h.get(next) == x) {
                    break;
                }

            int v = h.get(h.size() - 1);
            h.set(next, v);
            h.remove(h.size() - 1);
            if (next < h.size()) {
                do {
                    k = next;
                    if (k * 2 + 1 < h.size() && h.get(k * 2 + 1) < h.get(next)) next = k * 2 + 1;
                    if (k * 2 + 2 < h.size() && h.get(k * 2 + 2) < h.get(next)) next = k * 2 + 2;
                    h.set(k, h.get(next));
                } while (next > k);
                h.set(k, v);
            }
        }
    }

    public static int strStr(String haystack, String needle) {
        boolean hn = haystack == null || haystack.length() == 0;
        boolean nn = needle == null || needle.length() == 0;

        if (nn) return 0;
        if (hn && !nn) return -1;

        int f[] = matchFunction(needle);
        int m = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (m>0 && haystack.charAt(i) != needle.charAt(m)) m = f[m-1];
            if (needle.charAt(m) == haystack.charAt(i)) m++;
            if (m == needle.length()) return i - m + 1;
        }

        return -1;
    }

    public static int[] matchFunction(String needle) {
        int f[] = new int[needle.length()];
        f[0] = 0;
        int m = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (m > 0 && needle.charAt(i) != needle.charAt(m)) m = f[m];
            if (needle.charAt(m) == needle.charAt(i)) m++;
            f[i] = m;
        }

        return f;
    }
}
