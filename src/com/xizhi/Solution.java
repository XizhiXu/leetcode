package com.xizhi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        Arrays.stream(nums2).forEach(num -> {
            while (!s.isEmpty() && s.peek() < num) {
                m.put(s.pop(), num);
            }
            s.push(num);
        });

        return Arrays.stream(nums1).map(num -> m.getOrDefault(num, -1)).toArray();
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

    public int maxSubArray(int[] nums) {
        int f = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
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

    public static boolean isPalindrome(int x) {
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
        if (hn) return -1;

        int f[] = matchFunction(needle);
        int m = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (m >= 0 && needle.charAt(m + 1) != haystack.charAt(i)) m = f[m];
            if (needle.charAt(m + 1) == haystack.charAt(i)) {
                m++;
                if (m == needle.length() - 1) {
                    return i - m;
                }
            }
        }

        return -1;
    }

    public static int[] matchFunction(String needle) {
        int f[] = new int[needle.length()];
        f[0] = -1;
        int m = -1;
        for (int i = 1; i < needle.length(); i++) {
            while (m >= 0 && needle.charAt(m + 1) != needle.charAt(i)) m = f[m];
            if (needle.charAt(m + 1) == needle.charAt(i)) m++;
            f[i] = m;
        }

        return f;
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (l < r && nums[r] - nums[l] > k) {
                l++;
            }
            if (l < r && nums[r] - nums[l] == k && set.add(nums[r] + nums[l])) {
                sum++;
            }
        }

        return sum;
    }

    public int mySqrt(int x) {
        double EPS = 1e-5;
        double m = 1, mp = 0;
        do {
            mp = m;
            m = (mp + x / mp) / 2;
        } while (Math.abs(m - mp) > EPS);

        return (int) m;
    }

    public int thirdMax(int[] nums) {
        long f = Long.MIN_VALUE, s = Long.MIN_VALUE, t = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= f) {
                if (nums[i] > f) {
                    t = s;
                    s = f;
                    f = nums[i];
                }
            } else if (nums[i] >= s) {
                if (nums[i] > s) {
                    t = s;
                    s = nums[i];
                }
            } else if (nums[i] > t) {
                t = nums[i];
            }
        }

        return (int) (t > Long.MIN_VALUE ? t : f);
    }

    public int countPrimes(int n) {
        boolean[] b = new boolean[n];
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (!b[i]) {
                p.add(i);
            }

            for (int j = 0; j < p.size() && i * p.get(j) < n; j++) {
                b[i * p.get(j)] = true;
                if (i % p.get(j) == 0) break;
            }
        }

        return p.size();
    }

    public static boolean isPalindrome(String s) {
        String p = s.replaceAll("[^\\w]", "").toLowerCase();
        for (int i = 0; i < p.length() / 2; i++) {
            if (p.charAt(i) != p.charAt(p.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        do {
            n--;
            s.append((char) (n % 26 + 'A'));
            n /= 26;
        } while (n > 0);

        return s.reverse().toString();
    }

    public int firstBadVersion(int n) {
        long l = 1, r = n;
        while (l < r) {
            long m = (l + r) / 2;
            if (isBadVersion((int) m)) r = m;
            else l = m + 1;
        }

        return (int) l;
    }

    public boolean isBadVersion(int x) {
        return false;
    }

    public void rotate(int[] nums, int k) {
        int x = gcd(k, nums.length);
        int c, n;
        for (int i = 0; i < x; i++) {
            n = i;
            c = nums[n];
            for (int j = 0; j < nums.length / x; j++) {
                n = (n + k) % nums.length;
                int tmp = nums[n];
                nums[n] = c;
                c = tmp;
            }
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int m = r * 10 + x % 10;
            x /= 10;
            if (m / 10 != r) {
                return 0;
            }
            r = m;
        }
        return r;
    }

    public boolean checkPossibility(int[] nums) {
        boolean f = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1 || i == nums.length - 1 || nums[i] >= nums[i - 2] || nums[i + 1] >= nums[i - 1]) {
                    if (f) {
                        return false;
                    }
                    f = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Your Codec object will be instantiated and called as such:
     * Codec codec = new Codec();
     * codec.decode(codec.encode(url));
     **/
    public class Codec {
        Map<Integer, String> urls = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            urls.put(longUrl.hashCode(), longUrl);
            return "http://tinyurl.com/" + longUrl.hashCode();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return urls.get(Integer.valueOf(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return doConstructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public static TreeNode doConstructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) return null;

        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        TreeNode n = new TreeNode(nums[index]);
        n.left = doConstructMaximumBinaryTree(nums, l, index - 1);
        n.right = doConstructMaximumBinaryTree(nums, index + 1, r);
        return n;
    }

    public String complexNumberMultiply(String a, String b) {
        String[] pa = a.split("\\+");
        String[] pb = b.split("\\+");

        int ra = Integer.valueOf(pa[0]), ia = Integer.valueOf(pa[1].substring(0, pa[1].length() - 1));
        int rb = Integer.valueOf(pb[0]), ib = Integer.valueOf(pb[1].substring(0, pb[1].length() - 1));

        int rc = ra * rb - (ia * ib);
        int ic = ra * ib + rb * ia;
        return rc + "+" + ic + "i";
    }

    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' &&
                        (i == 0 || board[i - 1][j] != 'X') &&
                        (j == 0 || board[i][j - 1] != 'X')) {
                    cnt++;
                }
            }
        return cnt;
    }

    public int[] countBits(int num) {
        int[] c = new int[num + 1];
        c[0] = 0;
        for (int i = 1; i <= num; i++) c[i] = c[i >> 1] + ((i & 1) > 0 ? 1 : 0);
        return c;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int r = root.val;
        while (!q.isEmpty()) {
            r = q.peek().val;
            List<TreeNode> k = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                if (n.left != null) k.add(n.left);
                if (n.right != null) k.add(n.right);
            }
            q.addAll(k);
        }

        return r;
    }

    /**
     * {@linkplain #findDisappearedNumbers}
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) nums[(nums[i] - 1) % nums.length] += nums.length;
        for (int i = 0; i < nums.length; i++) if (nums[i] > 2 * nums.length) ans.add(i + 1);
        return ans;
    }

    public static int[][] reconstructQueue(int[][] people) {
        qsort(0, people.length - 1, people);

        int tmpH = 0, tmpK = 0;
        for (int i = 0; i < people.length; i++) {
            tmpH = people[i][0];
            tmpK = people[i][1];
            for (int j = i; j > tmpK; j--) {
                people[j][0] = people[j - 1][0];
                people[j][1] = people[j - 1][1];
            }
            people[tmpK][0] = tmpH;
            people[tmpK][1] = tmpK;
        }
        return people;
    }

    public static void qsort(int l, int r, int[][] people) {
        if (l >= r) return;
        int x = l;
        int y = r;
        int pivotH = people[l][0], pivotK = people[l][1];

        while (x < y) {
            while (x < y && (people[y][0] < pivotH || (people[y][0] == pivotH && people[y][1] > pivotK))) y--;
            people[x][0] = people[y][0];
            people[x][1] = people[y][1];
            while (x < y && (people[x][0] > pivotH || (people[x][0] == pivotH && people[x][1] < pivotK))) x++;
            people[y][0] = people[x][0];
            people[y][1] = people[x][1];
        }

        people[x][0] = pivotH;
        people[x][1] = pivotK;

        qsort(l, y - 1, people);
        qsort(x + 1, r, people);
    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length / 2;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[2 * m] == nums[2 * m + 1]) l = m + 1;
            else r = m;
        }

        return nums[l * 2];
    }

    public int countSubstrings(String s) {
        int cnt = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            l = r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }

        return cnt;
    }

    public static String optimalDivision(int[] nums) {
        StringBuilder s = new StringBuilder(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining("/")));
        if (nums.length > 2) {
            s.append(")");
            s.insert(s.indexOf("/") + 1, "(");
        }

        return s.toString();
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);

        while (!q.isEmpty()) {
            int m = q.peek().val;
            List<TreeNode> next = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                m = Math.max(m, n.val);
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            q.addAll(next);
            max.add(m);
        }

        return max;
    }

    public int countArrangement(int N) {
        boolean[] b = new boolean[N + 1];
        Arrays.fill(b, false);
        return N <= 0 ? 0 : rCountArrangement(N, b);
    }

    public int rCountArrangement(int l, boolean[] b) {
        if (l == 0) return 1;
        int sum = 0;
        for (int i = 1; i < b.length; i++) {
            if (!b[i] && (l % i == 0 || i % l == 0)) {
                b[i] = true;
                sum += rCountArrangement(l - 1, b);
                b[i] = false;
            }
        }

        return sum;
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) return 0;

        int sum = 0;
        int cnt = 0, diff = A[1] - A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] != diff) {
                if (cnt >= 2) {
                    sum += cnt * (cnt - 1) / 2;
                }
                cnt = 1;
                diff = A[i] - A[i - 1];
            } else {
                cnt++;
            }
        }

        if (cnt >= 2) {
            sum += cnt * (cnt - 1) / 2;
        }

        return sum;
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    class MapSum {
        Map<String, Integer> m;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            m = new HashMap<>();
        }

        public void insert(String key, int val) {
            m.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String s : m.keySet()) {
                if (s.startsWith(prefix)) sum += m.get(s);
            }

            return sum;
        }
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s : paths) {
            String[] segments = s.split("\\s+");
            for (int i = 1; i < segments.length; i++) {
                String[] parts = segments[i].split("\\(");
                String file = segments[0] + "/" + parts[0];
                String content = parts[1].substring(0, parts[1].length() - 1);
                m.putIfAbsent(content, new ArrayList<>());
                m.get(content).add(file);
            }
        }

        return m.values().stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    Map<Integer, Integer> m = new HashMap<>();
    int f = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        subtreeSum(root);
        return m.entrySet().stream().filter(e -> e.getValue() == f).map(Map.Entry::getKey).mapToInt(i -> i).toArray();
    }

    public int subtreeSum(TreeNode node) {
        if (node == null) return 0;
        else {
            int val = node.val + subtreeSum(node.left) + subtreeSum(node.right);
            m.put(val, m.getOrDefault(val, 0) + 1);
            f = Math.max(f, m.get(val));
            return val;
        }
    }

    /**
     * related to {@linkplain #singleNumber(int[])}
     */
    public int[] singleNumber3(int[] nums) {
        Arrays.sort(nums);
        List<Integer> a = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i * 2] != nums[i * 2 + (found ? -1 : 1)]) {
                a.add(nums[i * 2 + (found ? -1 : 0)]);
                if (found) {
                    break;
                } else {
                    found = true;
                }
            }
        }

        if (a.size() != 2) a.add(nums[nums.length - 1]);

        return a.stream().mapToInt(i -> i).toArray();
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[nums.length - 1 - i] - nums[i];
        }

        return sum;
    }

    public int[] constructArray(int n, int k) {
        int[] a = new int[n];
        int sign = 1;
        for (int i = 0; i < n; i++) {
            if (i >= n - k) {
                a[i] = a[i - 1] + (n - i) * sign;
                sign = -sign;
            } else {
                a[i] = i + 1;
            }
        }

        return a;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int cnt = timeSeries.length > 0 ? duration : 0;
        for (int i = 1; i < timeSeries.length; i++) {
            cnt += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }

        return cnt;
    }

    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        return m.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(e -> String.join("", Collections.nCopies(e.getValue(), e.getKey().toString())))
                .collect(Collectors.joining());
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        int c = (int) Math.pow(2, h) - 1;

        List<List<String>> m = new ArrayList<>();
        for (int i = 0; i < h; i++) m.add(new ArrayList<>(Collections.nCopies(c, "")));
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        if (root != null) {
            q.add(root);
            index.add(0);
        }


        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            int in = index.remove();
            int d = 2;
            while (in >= d - 1) {
                d *= 2;
            }
            int row = (int) (Math.log(d) / Math.log(2)) - 1;
            int col = (int) (c / d + Math.pow(2, h - row) * (in - d / 2 + 1));
            m.get(row).set(col, String.valueOf(n.val));
            if (n.left != null) {
                q.add(n.left);
                index.add(in * 2 + 1);
            }
            if (n.right != null) {
                q.add(n.right);
                index.add(in * 2 + 2);
            }
        }
        return m;
    }

    public static int getHeight(TreeNode node) {
        if (node == null) return 0;
        else return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
    public static class MagicDictionary {
        public static class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                    node = node.children[c - 'a'];
                }
                node.isWord = true;
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            StringBuilder b = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char org = word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != org) {
                        b.setCharAt(i, c);
                        if (contains(b.toString())) return true;
                        b.setCharAt(i, org);
                    }
                }
            }

            return false;
        }

        public boolean contains(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }

            return node.isWord;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        Arrays.fill(a, 1);
        int l = 1, r = 1;
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                a[i] *= l;
                l = l * nums[i];
            }
            if (i > 0) {
                a[n - i] *= r;
                r = r * nums[n - i];
            }
        }
        return a;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        reveal(board, x, y);
        return board;
    }

    public static void reveal(char[][] board, int x, int y) {
        if (board[x][y] != 'E') return;
        int mine = mineAdjacent(board, x, y);
        if (mine > 0) board[x][y] = (char) ('0' + mine);
        else {
            board[x][y] = 'B';
            if (x > 0 && y > 0) reveal(board, x - 1, y - 1);
            if (x > 0) reveal(board, x - 1, y);
            if (x > 0 && y < board[0].length - 1) reveal(board, x - 1, y + 1);
            if (y > 0) reveal(board, x, y - 1);
            if (y < board[0].length - 1) reveal(board, x, y + 1);
            if (x < board.length - 1 && y > 0) reveal(board, x + 1, y - 1);
            if (x < board.length - 1) reveal(board, x + 1, y);
            if (x < board.length - 1 && y < board[0].length - 1) reveal(board, x + 1, y + 1);
        }
    }

    public static int mineAdjacent(char[][] board, int x, int y) {
        int tl = (x > 0 && y > 0 && board[x - 1][y - 1] == 'M') ? 1 : 0;
        int t = (x > 0 && board[x - 1][y] == 'M') ? 1 : 0;
        int tr = (x > 0 && y < board[0].length - 1 && board[x - 1][y + 1] == 'M') ? 1 : 0;
        int l = (y > 0 && board[x][y - 1] == 'M') ? 1 : 0;
        int r = (y < board[0].length - 1 && board[x][y + 1] == 'M') ? 1 : 0;
        int bl = (x < board.length - 1 && y > 0 && board[x + 1][y - 1] == 'M') ? 1 : 0;
        int b = (x < board.length - 1 && board[x + 1][y] == 'M') ? 1 : 0;
        int br = (x < board.length - 1 && y < board[0].length - 1 && board[x + 1][y + 1] == 'M') ? 1 : 0;
        return tl + t + tr + l + r + bl + b + br;
    }

    public int findCircleNum(int[][] M) {
        int[] union = new int[M.length];
        for (int i = 0; i < M.length; i++) union[i] = i;

        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M.length; j++)
                if (M[i][j] > 0) {
                    int pi = union[i];
                    while (union[pi] != pi) pi = union[pi];
                    int pj = union[j];
                    while (union[pj] != pj) pj = union[pj];
                    union[pi] = pj;
                }

        return (int) IntStream.range(0, M.length).filter(i -> union[i] == i).count();
    }

    /**
     * count first then sort
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public int flipLights(int n, int m) {
        if (n == 0) return 0;
        if (m == 0) return 1;

        if (n == 1) return 2;
        if (n == 2) return (m == 1) ? 3 : 4;

        if (m == 1) return 4;
        if (m == 2) return 7;
        if (m >= 3) return 8;
        return 8;
    }


    /**
     * optimize using trie
     */
    public String replaceWords(List<String> dict, String sentence) {
        dict.sort(String::compareTo);
        return Arrays.stream(sentence.split("\\s+"))
                .map(s -> dict.stream().filter(s::startsWith).findFirst().orElse(s))
                .collect(Collectors.joining(" "));
    }

    public static int findLongestChain(int[][] pairs) {
        qsort(pairs, 0, pairs.length - 1);
        int[] f = new int[pairs.length];
        Arrays.fill(f, 1);

        int max = 1;
        for (int i = 0; i < pairs.length; i++)
            for (int j = i - 1; j >= 0; j--)
                if (pairs[i][0] > pairs[j][1]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }

        return Arrays.stream(f).max().orElse(0);
    }

    public static void qsort(int[][] pairs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r, pvtx = pairs[l][0], pvty = pairs[l][1];

        while (i < j) {
            while (i < j && pairs[j][1] >= pvty) j--;
            pairs[i][0] = pairs[j][0];
            pairs[i][1] = pairs[j][1];
            while (i < j && pairs[i][1] < pvty) i++;
            pairs[j][0] = pairs[i][0];
            pairs[j][1] = pairs[i][1];
        }

        pairs[i][0] = pvtx;
        pairs[i][1] = pvty;
        qsort(pairs, l, j - 1);
        qsort(pairs, i + 1, r);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> l = inorderTraversal(root.left);
        List<Integer> r = inorderTraversal(root.right);
        a.addAll(l);
        a.add(root.val);
        a.addAll(r);
        return a;
    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            for (int j = 0; j < nums.length; j++) c += (nums[j] >> i & 1) > 0 ? 1 : 0;
            sum += (nums.length - c) * c;
        }

        return sum;
    }

    public int[] nextGreaterElements(int[] nums) {
        final int[] next = new int[nums.length];
        final Stack<Integer> s = new Stack<>();
        final int len = nums.length;
        Arrays.fill(next, -1);
        IntStream.range(0, nums.length * 2).forEach(n -> {
            int num = nums[n % len];
            while (!s.isEmpty() && nums[s.peek()] < num)
                next[s.pop()] = num;
            if (n < len) s.push(n);
        });

        return next;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
    public static class SolutionRandom { // Reservoir sampling
        ListNode list;
        Random r;


        /**
         * @param head The linked list'findDiagonalOrder head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public SolutionRandom(ListNode head) {
            list = head;
            r = new Random(System.currentTimeMillis());
        }

        /**
         * Returns a random node'findDiagonalOrder value.
         */
        public int getRandom() {
            ListNode node = list;
            int pool = 0;
            for (int i = 1; node != null; node = node.next, i++) {
                if (r.nextInt(i) == 0) pool = node.val;
            }
            return pool;
        }
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int c = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                c += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return c;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> r = new HashSet<>();
        Map<Integer, List<List<Integer>>> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                m.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                List<List<Integer>> v = m.get(nums[i] + nums[j]);
                v.add(Arrays.asList(i, j));
            }

        m.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .filter(e -> e.getKey() <= target / 2 && m.containsKey(target - e.getKey()))
                .forEach(e -> {
                    for (List<Integer> t1 : e.getValue())
                        for (List<Integer> t2 : m.get(target - e.getKey())) {
                            int a = t1.get(0), b = t1.get(1), c = t2.get(0), d = t2.get(1);
                            if (b < c) {
                                r.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                            }
                        }
                });
        return new ArrayList<>(r);
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public static class SolutionShuffle {
        int[] a;
        Random r;

        public SolutionShuffle(int[] nums) {
            a = nums;
            r = new Random(System.currentTimeMillis());
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return a;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            List<Integer> tmp = Arrays.stream(a).boxed().collect(Collectors.toList());
            return IntStream.range(0, a.length).map(i -> tmp.remove(r.nextInt(a.length - i))).toArray();
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else if (d == 2) {
            TreeNode tmp = null;
            tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
            return root;
        } else {
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
            return root;
        }
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n & mask);
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public String fractionAddition(String expression) {
        int d = 1;
        int n = 0;
        for (String s : expression.split("(?=[-+])")) { // look ahead positive
            String[] parts = s.split("/");
            int tn = Integer.parseInt(parts[0]);
            int td = Integer.parseInt(parts[1]);
            int gcd = gcd(d, td);
            n = n * td / gcd + tn * d / gcd;
            d = n == 0 ? 1 : d * td / gcd;
            gcd = Math.abs(gcd(n, d));
            n /= gcd;
            d /= gcd;
        }

        return String.valueOf(n) + "/" + String.valueOf(d);
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int p = 1;
        while (n > 4) {
            p *= 3;
            n -= 3;
        }
        return p * n;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n > 10) return countNumbersWithUniqueDigits(10);
        else {
            int x = 9;
            for (int i = 9; i > 9 - n + 1; i--) x *= i;
            return countNumbersWithUniqueDigits(n - 1) + x;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            sum += n1 + n2;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = head;
            head = tmp;
            sum /= 10;
        }

        if (sum > 0) {
            ListNode tmp = new ListNode(sum);
            tmp.next = head;
            head = tmp;
        }

        return head;
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] b = new boolean[24 * 60];
        for (String s : timePoints) {
            String[] p = s.split(":");
            int t = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
            if (b[t]) return 0;
            b[t] = true;
        }

        int d = 0, min = Integer.MAX_VALUE;
        boolean f = false;
        for (int i = 0; i < 48 * 60; i++, d++) {
            if (b[i % (24 * 60)]) {
                if (f) {
                    min = Math.min(min, d);
                    if (i >= 24 * 60) break;
                    d = 0;
                } else {
                    d = 0;
                }
                f = true;
            }
        }

        return min;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;
        int[] a = new int[n * m];
        int d = -1, p = 0;

        for (int i = 0; i < n + m - 1; i++) {
            int min = i < n ? 0 : i - n + 1;
            int max = i < m ? i + 1 : m;
            for (int j = 0; j < max - min; j++) {
                int x = d < 0 ? min + j : max - j - 1;
                a[p] = matrix[i - x][x];
                p++;
            }
            d = -d;
        }
        return a;
    }

    List<String> a = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis("", n);
        return a;
    }

    public void generateParenthesis(String s, int max) {
        List<Character> chars = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        int open = Collections.frequency(chars, '(');
        int close = Collections.frequency(chars, ')');

        if (open == close && close == max) {
            a.add(s);
            return;
        } else {
            if (open < max) generateParenthesis(s + "(", max);
            if (close < open) generateParenthesis(s + ")", max);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permute(Arrays.stream(nums).sorted().boxed().collect(Collectors.toList()));
    }

    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> a = new ArrayList<>();
        if (nums.size() == 1) {
            a.add(new ArrayList<>(nums));
        } else {
            List<Integer> tmp = new ArrayList<>(nums);
            for (int i = 0; i < nums.size(); i++) {
                int k = nums.get(i);
                tmp.remove(i);
                for (List<Integer> p : permute(tmp)) {
                    p.add(k);
                    a.add(p);
                }
                tmp.add(i, k);
            }
        }

        return a;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(Arrays.stream(nums).sorted().boxed().collect(Collectors.toList()));
    }

    public static List<List<Integer>> permuteUnique(List<Integer> nums) {
        List<List<Integer>> a = new ArrayList<>();
        if (nums.size() == 1) {
            a.add(new ArrayList<>(nums));
        } else {
            List<Integer> tmp = new ArrayList<>(nums);
            int k = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++) {
                if (k == nums.get(i)) continue;
                else k = nums.get(i);
                tmp.remove(i);
                for (List<Integer> p : permuteUnique(tmp)) {
                    p.add(k);
                    a.add(p);
                }
                tmp.add(i, k);
            }
        }

        return a;
    }

    List<List<Integer>> comb = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(new ArrayList<>(), candidates, target, 0);
        return comb;
    }

    public void combinationSum(List<Integer> c, int[] candidates, int target, int start) {
        if (target == 0) {
            comb.add(new ArrayList<>(c));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int k = candidates[i];
            if (k > target) break;
            c.add(k);
            combinationSum(c, candidates, target - k, i);
            c.remove(c.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(new ArrayList<>(), candidates, target, 0);
        return comb;
    }

    public void combinationSum2(List<Integer> c, int[] candidates, int target, int start) {
        if (target == 0) {
            comb.add(new ArrayList<>(c));
            return;
        }
        int k = -1;
        for (int i = start; i < candidates.length; i++) {
            if (k == candidates[i]) continue; // skip duplicate
            else k = candidates[i];
            if (k > target) break;
            c.add(k);
            combinationSum2(c, candidates, target - k, i + 1);
            c.remove(c.size() - 1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, 0);
        f[0] = 1;

        for (int i = 0; i < target; i++)
            for (int num : nums)
                if (i + num <= target) f[i + num] += f[i];
        return f[target];
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> m = new ArrayList<>();
            for (int i = 0; i < a.size(); i++) {
                List<Integer> p = new ArrayList<>(a.get(i));
                p.add(num);
                m.add(p);
            }
            a.addAll(m);
        }

        return a;
    }

    List<List<Integer>> subs = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(new ArrayList<>(), nums, 0);
        return subs;
    }

    public void subsetsWithDup(List<Integer> set, int[] nums, int start) {
        subs.add(new ArrayList<>(set));
        int k = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == k) continue;
            else k = nums[i];
            set.add(k);
            subsetsWithDup(set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> a = new ArrayList<>();
        if (isPalindrome(s)) {
            a.add(new ArrayList<>(Collections.singletonList(s)));
        }

        for (int i = 1; i < s.length(); i++) {
            String fir = s.substring(0, i), sec = s.substring(i);
            if (isPalindrome(fir)) {
                for (List<String> p : partition(sec)) {
                    p.add(0, fir);
                    a.add(p);
                }
            }
        }

        return a;
    }

    /**
     * edit distance or LCS
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int[][] f = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++)
                f[i][j] = word1.charAt(i) == word2.charAt(j) ?
                        (i == 0 || j == 0) ? 1 : f[i - 1][j - 1] + 1 :
                        Math.max(i == 0 ? 0 : f[i - 1][j], j == 0 ? 0 : f[i][j - 1]);

        return word1.length() + word2.length() - 2 * f[word1.length() - 1][word2.length() - 1];
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int select = root.val +
                (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) +
                (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);
        int deselect = rob(root.left) + rob(root.right);

        return Math.max(select, deselect);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode tmp = head;
        ListNode runner = head;
        do {
            if (head == null) return null;
            else head = head.next;
            if (runner == null || runner.next == null) return null;
            else runner = runner.next.next;
        } while (head != runner);

        while (tmp != runner) {
            tmp = tmp.next;
            runner = runner.next;
        }

        return tmp;
    }

    public int findDuplicate(int[] nums) {
        int h = nums[0], r = nums[0];
        do {
            h = nums[h];
            r = nums[nums[r]];
        } while (h != r);

        h = nums[0];
        while (h != r) {
            h = nums[h];
            r = nums[r];
        }

        return h;
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) > 0) return false;
        else sum /= 2;
        boolean[] f = new boolean[sum + 1];
        Arrays.fill(f, false);
        f[0] = true;


        for (int i = 0; i < nums.length; i++)
            for (int j = sum; j >= nums[i]; j--) f[j] = f[j] || f[j - nums[i]];

        return f[sum];
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();

        if (sum < S) return 0;
        else sum += S;

        if ((sum & 1) > 0) return 0;
        else sum /= 2;

        int[] f = new int[sum + 1];
        f[0] = 1;
        for (int num : nums)
            for (int j = sum; j >= num; j--) f[j] += f[j - num];

        return f[sum];
    }

    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        Arrays.fill(c, 0);
        for (char ch : tasks) c[ch - 'A']++;
        Arrays.sort(c);

        int s = (c[25] - 1) * (n + 1);
        for (int i = 25; i >= 0 && c[i] == c[25]; i--) s++;
        return Math.max(s, tasks.length);
    }

    /**
     * C(m-1, m+n-2)
     */
    public int uniquePaths(int m, int n) {
        int x = Math.min(m - 1, n - 1);

        double r = 1;
        for (int i = 1; i <= x; i++) {
            r = r * (m + n - 1 - i) / i;
        }

        return (int) r;
    }

    public static int maxProfitCooldown(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] f = new int[n][3];
        f[0][0] = 0;
        f[0][1] = 0;
        f[0][2] = 0;

        for (int i = 1; i < n; i++) {
            int p = prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
            f[i][0] = Math.max(f[i - 1][1], f[i - 2][2]);
        }

        return f[n - 1][0];
    }

    public static String decodeString(String s) {
        Stack<String> strs = new Stack<>();
        Stack<Integer> cnts = new Stack<>();
        String str = "";
        int cnt = 0;
        int i = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                strs.push(str);
                str = "";
                int k = i;
                while (k < s.length() && Character.isDigit(s.charAt(k))) k++;
                cnt = Integer.parseInt(s.substring(i, k));
                i = k;
            } else if (Character.isLetter(s.charAt(i))) {
                int k = i;
                while (k < s.length() && Character.isLetter(s.charAt(k))) k++;
                str += s.substring(i, k);
                i = k;
            } else if (s.charAt(i) == '[') {
                cnts.push(cnt);
                i++;
            } else if (s.charAt(i) == ']') {
                str = strs.pop() + String.join("", Collections.nCopies(cnts.pop(), str));
                i++;
            }
        }

        return str;
    }

    /**
     * Catalan number or C(2n, n)/(n+1)
     */
    public static int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) sum += f[j] * f[i - j - 1];
            f[i] = sum;
        }
        return f[n];
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                row.add(n.val);
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            r.add(row);
            q.addAll(next);
        }

        return r;
    }

    public static int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) cnt++;
            for (int j = 0; j < i; j++) if (nums[i] - nums[j] == k) cnt++;
        }
        return cnt;
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public static int quickSelect(int[] a, int l, int r, int k) {
        if (l == r) return a[l];
        int i = l, j = r;
        int ran = new Random(System.currentTimeMillis()).nextInt(r - l + 1);
        int pvt = a[l + ran];
        a[l + ran] = a[l];
        a[l] = pvt;

        while (i < j) {
            while (i < j && a[j] < pvt) j--;
            a[i] = a[j];
            while (i < j && a[i] >= pvt) i++;
            a[j] = a[i];
        }

        a[i] = pvt;
        if (i == k) return pvt;
        else if (i > k) return quickSelect(a, l, i - 1, k);
        else return quickSelect(a, i + 1, r, k);
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static class RandomizedSet {
        Map<Integer, Integer> m;
        List<Integer> l;
        Random r;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            m = new HashMap<>();
            l = new ArrayList<>();
            r = new Random(System.currentTimeMillis());
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (m.containsKey(val)) {
                return false;
            } else {
                m.put(val, l.size());
                l.add(val);
                return true;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (m.containsKey(val)) {
                int index = m.get(val);
                if (index < l.size() - 1) {
                    int swap = l.get(l.size() - 1);
                    l.set(index, swap);
                    m.put(swap, index);
                }
                l.remove(l.size() - 1);
                m.remove(val);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return l.get(r.nextInt(l.size()));
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int i = 0, j = matrix[0].length - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }

        return false;
    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length]; // f[i] for min last number of LIS of length i
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(f, 0, len, x);
            if (i < 0) i = -(i + 1);
            f[i] = x;
            if (i == len) len++;
        }

        return len;
    }

    /**
     * 0 to left, 2 to right, redo when switch 2.
     */
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length && i <= end; i++) {
            if (nums[i] == 0) {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
                start++;
            } else if (nums[i] == 2) {
                int tmp = nums[end];
                nums[end] = nums[i];
                nums[i] = tmp;
                end--;
                i--;
            }
        }
    }


    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> h = new HashMap<>();
        Map<Integer, Integer> t = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int max = 0;
        for (int n : nums)
            if (set.add(n)) {
                int l = t.getOrDefault(n - 1, 0);
                int r = h.getOrDefault(n + 1, 0);
                t.remove(n - 1);
                h.remove(n + 1);
                int sum = l + r + 1;
                max = Math.max(max, sum);
                h.put(n - l, Math.max(h.getOrDefault(n - l, 0), sum));
                t.put(n + r, Math.max(t.getOrDefault(n + l, 0), sum));
            }

        return max;
    }

    // TODO do it with Lagrange's Four Square theorem
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) min = Math.min(min, 1 + f[i - j * j]);
            f[i] = min;
        }

        return f[n];
    }

    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int p = -1;
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if ((i == 0 && height[0] > height[1]) ||
                    (i == height.length - 1 && height[height.length - 2] < height[height.length - 1]) ||
                    (i > 0 && i < height.length - 1 && height[i - 1] <= height[i] && height[i] >= height[i + 1])) {
                if (p >= 0) {
                    int bar = Math.min(height[p], height[i]);
                    for (int j = p + 1; j < i; j++) sum += bar > height[j] ? bar - height[j] : 0;
                }
                p = i;
            }
        }

        return sum;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tmp = root;
            while (tmp.right != null) tmp = tmp.right;
            tmp.right = node;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] cnt = new int[26];
        for (String s : strs) {
            Arrays.fill(cnt, 0);
            s.chars().forEach(c -> cnt[c - 'a']++);
            String ps = IntStream.range(0, 26).filter(i -> cnt[i] > 0).mapToObj(i -> "" + (char) ('a' + i) + cnt[i]).collect(Collectors.joining());
            map.putIfAbsent(ps, new ArrayList<>());
            map.get(ps).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public int numIslands(char[][] grid) {
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {
                    sum++;
                    markIslands(grid, i, j);
                }

        return sum;
    }

    public static void markIslands(char[][] m, int x, int y) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[x].length || m[x][y] == '0') return;

        m[x][y] = '0';
        markIslands(m, x - 1, y);
        markIslands(m, x + 1, y);
        markIslands(m, x, y - 1);
        markIslands(m, x, y + 1);
    }

    public static List<String> letterCombinations(String digits) {
        List<List<Character>> map = Arrays.asList(
                Arrays.asList('0'),
                Arrays.asList('1'),
                Arrays.asList('a', 'b', 'c'),
                Arrays.asList('d', 'e', 'f'),
                Arrays.asList('g', 'h', 'i'),
                Arrays.asList('j', 'k', 'l'),
                Arrays.asList('m', 'n', 'o'),
                Arrays.asList('p', 'q', 'r', 's'),
                Arrays.asList('t', 'u', 'v'),
                Arrays.asList('w', 'x', 'y', 'z')
        );

        List<String> r = new ArrayList<>();
        if (digits.length() > 0) r.add("");
        for (char d : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String s : r)
                for (char ch : map.get(d - '0')) tmp.add(s + ch);
            r = tmp;
        }

        return r;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head;
        ListNode cur = head;
        for (int i = 0; i < n; i++) runner = runner.next;

        if (runner == null) return head.next;
        runner = runner.next;
        while (runner != null) {
            runner = runner.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        int offset = 0;
        while (offset <= inR - inL && in[inL + offset] != pre[preL]) offset++;
        TreeNode root = new TreeNode(pre[preL]);
        root.left = buildTree(pre, in, preL + 1, preL + offset, inL, inL + offset - 1);
        root.right = buildTree(pre, in, preL + offset + 1, preR, inL + offset + 1, inR);
        return root;
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int pvt = 1;
        for (; pvt < nums.length; pvt++) if (nums[pvt] < nums[pvt - 1]) break;

        int l = pvt, r = pvt + nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid % nums.length] == target) return mid % nums.length;
            else if (nums[mid % nums.length] > target) r = mid;
            else l = mid + 1;
        }

        return nums[l % nums.length] == target ? l % nums.length : -1;
    }

    /**
     * find loop in directed graph, top sort
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] cnt = new int[numCourses];
        Arrays.fill(cnt, 0);
        ListNode[] at = new ListNode[numCourses];
        Arrays.fill(at, null);

        for (int[] pair : prerequisites) {
            int x = pair[0];
            int y = pair[1];
            ListNode tmp = new ListNode(y);
            tmp.next = at[x];
            at[x] = tmp;
            cnt[y]++;
        }

        int sum = numCourses;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (cnt[i] == 0) {
                q.add(i);
                sum--;
            }
        while (!q.isEmpty()) {
            ListNode tmp = at[q.remove()];
            while (tmp != null) {
                if (--cnt[tmp.val] == 0) {
                    q.add(tmp.val);
                    sum--;
                }
                tmp = tmp.next;
            }
        }

        return sum == 0;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[]{-1, -1};
        if (nums.length == 0) return a;
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2; // biased to middle left
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] == target) a[0] = l;
        else return a;

        r = nums.length - 1;
        while (l < r) {
            mid = (l + r + 1) / 2; // biased to middle right
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        a[1] = l;

        return a;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> r = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (prev < interval.start) {
                r.add(interval);
                prev = interval.end;
            } else {
                Interval last = r.get(r.size() - 1);
                prev = Math.max(prev, interval.end);
                last.end = prev;
            }
        }

        return r;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 0; i < s.length(); i++)
            if (f[i])
                for (String word : wordDict)
                    if (s.substring(i).startsWith(word)) f[i + word.length()] = true;

        return f[s.length()];
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    public boolean canJump(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (p < i) return false;
            else {
                p = Math.max(p, i + nums[i]);
                if (p >= nums.length - 1) return true;
            }
        }

        return true;
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] f = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '1') {
                    f[i][j] = Math.min(i > 0 && j > 0 ? f[i - 1][j - 1] : 0, Math.min(i > 0 ? f[i - 1][j] : 0, j > 0 ? f[i][j - 1] : 0)) + 1;
                    max = Math.max(f[i][j], max);
                } else {
                    f[i][j] = 0;
                }

        return max * max;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode cur = head;
        ListNode runner = head.next;

        while (runner.next != null) {
            cur = cur.next;
            runner = runner.next;
            if (runner.next == null) break;
            else runner = runner.next;
        }

        runner = cur.next;
        cur.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(runner);
        if (l.val <= r.val) {
            cur = l;
            l = l.next;
        } else {
            cur = r;
            r = r.next;
        }
        runner = cur;
        while (l != null || r != null) {
            if (r == null) {
                runner.next = l;
                break;
            }

            while (l != null && l.val <= r.val) {
                runner.next = l;
                l = l.next;
                runner = runner.next;
            }

            if (l == null) {
                runner.next = r;
                break;
            }

            while (r != null && r.val < l.val) {
                runner.next = r;
                r = r.next;
                runner = runner.next;
            }
        }

        return cur;
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static class Trie {
        public static class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private TrieNode find(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] != null) node = node.children[ch - 'a'];
                else return null;
            }

            return node;
        }

    }

    public static String getPermutation(int n, int k) {
        List<Character> set = IntStream.range(0, n).mapToObj(i -> (char) (i + '1')).collect(Collectors.toList());
        int f = 1;
        for (int i = 1; i < n; i++) f *= i;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            sb.append(set.remove(k / f));
            k %= f;
            f /= i;
        }

        sb.append(set.get(0));
        return sb.toString();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (head == null) {
                head = new ListNode(sum % 10);
                tail = head;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            sum /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (sum > 0) {
            tail.next = new ListNode(sum % 10);
        }

        return head;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() > board.length * board[0].length) return false;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (doExist(board, word, 0, i, j)) return true;

        return false;
    }

    public static boolean doExist(char[][] board, String word, int depth, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != word.charAt(depth))
            return false;

        if (depth + 1 == word.length()) return true;
        else {
            char buf = board[x][y];
            board[x][y] = '0';
            if (doExist(board, word, depth + 1, x - 1, y) ||
                    doExist(board, word, depth + 1, x + 1, y) ||
                    doExist(board, word, depth + 1, x, y - 1) ||
                    doExist(board, word, depth + 1, x, y + 1)) {
                return true;
            } else {
                board[x][y] = buf;
                return false;
            }

        }

    }

    public int maxProduct(int[] nums) {
        int lastMin = 1, lastMax = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = lastMax;
                lastMax = lastMin;
                lastMin = tmp;
            }
            lastMax = Math.max(nums[i], nums[i] * lastMax);
            lastMin = Math.min(nums[i], nums[i] * lastMin);
            max = Math.max(lastMax, max);
        }

        return max;
    }

    public String longestPalindromeSubString(String s) {
        int n = s.length();
        int k = 0;
        int i = 0;
        String r = "";
        while (i < n - k / 2) {
            int x = 0;
            while (i - x >= 0 && i + x < n && s.charAt(i - x) == s.charAt(i + x)) x++;
            if (x * 2 - 1 > k) {
                k = x * 2 - 1;
                r = s.substring(i - x + 1, i + x);
            }
            x = 0;
            while (i - x >= 0 && i + x + 1 < n && s.charAt(i - x) == s.charAt(i + x + 1)) x++;
            if (x * 2 > k) {
                k = x * 2;
                r = s.substring(i - x + 1, i + x + 1);
            }
            i++;
        }

        return r;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];

        for (int i = 0; i < n; i++) { // last index traverse from left to right
            f[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) { // first index traverse from right to left
                if (s.charAt(j) == s.charAt(i)) {
                    f[j][i] = f[j + 1][i - 1] + 2;
                } else {
                    f[j][i] = Math.max(f[j + 1][i], f[j][i - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int last = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = 1;
            while (j <= last && s.charAt(i) != s.charAt(i - j)) j++;
            last = j;
            max = Math.max(max, last);
        }

        return max;
    }

    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return checkValidBST(root.left, min, root.val) && checkValidBST(root.right, root.val, max);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++)
            if (i == 0 || nums[i - 1] != nums[i]) { // only deal with the first of consecutive numbers, -1 -1 2
                int sum = -nums[i];
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        a.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[++l] == nums[l - 1]) ;
                        while (l < r && nums[--r] == nums[r + 1]) ;
                    } else if (nums[l] + nums[r] > sum) r--;
                    else l++;
                }
            }

        return a;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, n + 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n, int last) {
        List<List<Integer>> a = new ArrayList<>();
        if (k == 1) {
            if (n < last) a.add(new ArrayList<>(Collections.singletonList(n)));
        } else
            for (int i = Math.min(9, Math.min(last - 1, n - k * (k - 1) / 2)); i >= k; i--) {
                List<List<Integer>> list = combinationSum3(k - 1, n - i, i);
                if (list.size() > 0)
                    for (List<Integer> l : list) l.add(i);
                a.addAll(list);
            }

        return a;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static class LRUCache {
        Map<Integer, DoubleLinkedList.Node> map;
        DoubleLinkedList list;

        public static class DoubleLinkedList {
            public static class Node {
                public int key;
                public int val;
                public Node prev;
                public Node next;

                public Node(int key, int val) {
                    this.key = key;
                    this.val = val;
                    prev = null;
                    next = null;
                }
            }

            private Node head, tail;
            public int size, capacity;

            public DoubleLinkedList(int capacity) {
                this.capacity = capacity;
                size = 0;
                head = null;
                tail = null;
            }

            public Node add(Node node) {
                if (tail == null) {
                    tail = node;
                } else {
                    head.prev = node;
                }
                node.prev = null;
                node.next = head;
                head = node;
                if (size == capacity) {
                    Node tmp = tail;
                    tail = tail.prev;
                    tail.next = null;
                    return tmp.key == node.key ? null : tmp;
                } else {
                    size++;
                    return null;
                }
            }

            public void remove(Node node) {
                Node next = node.next;
                Node prev = node.prev;
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = node.next;
                    node.prev = null;
                }
                if (next == null) {
                    tail = tail.prev;
                } else {
                    next.prev = prev;
                    node.next = null;
                }
                size--;
            }
        }

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new DoubleLinkedList(capacity);
        }

        public int get(int key) {
            DoubleLinkedList.Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                list.remove(node);
                list.add(node);
                return node.val;
            }
        }

        public void put(int key, int value) {
            DoubleLinkedList.Node node = map.get(key);
            if (node == null) {
                node = new DoubleLinkedList.Node(key, value);
                DoubleLinkedList.Node replace = list.add(node);
                if (replace != null) map.remove(replace.key);
                map.put(key, node);
            } else {
                list.remove(node);
                list.add(node);
                node.val = value;
            }
        }
    }

    /**
     * Your Codec object will be instantiated and called as such:
     * Codec codec = new Codec();
     * codec.deserialize(codec.serialize(root));
     */
    public static class BinaryTreeCodec {
        public static final String delimiter = ",";
        public static final String placeholder = "*";

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            if (root == null) return placeholder;
            else return root.val + delimiter + serialize(root.left) + delimiter + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            return deserialize(new LinkedList<>(Arrays.asList(data.split(delimiter))));
        }

        public static TreeNode deserialize(Queue<String> nodes) {
            String str = nodes.remove();
            if (str.equals(placeholder)) return null;
            else {
                TreeNode root = new TreeNode(Integer.parseInt(str));
                root.left = deserialize(nodes);
                root.right = deserialize(nodes);
                return root;
            }
        }
    }

    int pathMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return pathMax;
    }

    public int doMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, doMaxPathSum(root.left));
        int right = Math.max(0, doMaxPathSum(root.right));
        pathMax = Math.max(pathMax, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) if (list != null) heap.add(list);

        ListNode head = new ListNode(0), tail = head;

        while (!heap.isEmpty()) {
            ListNode node = heap.remove();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) heap.add(node.next);
        }

        return head.next;
    }
}
