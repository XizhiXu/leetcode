package com.xizhi;

import com.xizhi.Reference.Interval;
import com.xizhi.Reference.ListNode;
import com.xizhi.Reference.Point;
import com.xizhi.Reference.TreeNode;
import com.xizhi.Solution.Logger;
import java.util.Arrays;

public class Test {

  public static void hammingDistance() {
    System.out.println(Solution.hammingDistance(1, 4));
  }

  public static void judgeCircle() {
    System.out.println(Solution.judgeCircle("UD"));
    System.out.println(Solution.judgeCircle("LL"));
  }

  public static void arrayPairSum() {
    System.out.println(Solution.arrayPairSum(new int[]{1, 4, 3, 2}));
  }

  public static void findComplement() {
    System.out.println(Solution.findComplement(5));
    System.out.println(Solution.findComplement(1));
  }

  public static void findWords() {
    for (String s : Solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})) {
      System.out.println(s);
    }
    for (String s : Solution.findWords(new String[]{"qwee"})) {
      System.out.println(s);
    }
  }

  public static void reverseWords() {
    System.out.println(Solution.reverseWords("Let'findDiagonalOrder take LeetCode contest"));
  }

  public static void matrixReshape() {
    System.out.println(Solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
  }

  public static void nextGreaterElement() {
    for (int i : Solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})) {
      System.out.println(i);
    }
  }

  public static void detectCapitalUse() {
    System.out.println(Solution.detectCapitalUse("FlaG"));
  }

  public static void getSum() {
    System.out.println(Solution.getSum(125, 312));
  }

  public static void imageSmoother() {
    System.out.println(Solution
        .imageSmoother(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}));
  }

  public static void titleToNumber() {
    System.out.println(Solution.titleToNumber("AA"));
  }


  public static void findRelativeRanks() {
    System.out.println(String.join(",", Solution.findRelativeRanks(new int[]{1, 3, 2})));
  }

  public static void romanToInt() {
    System.out.println(Solution.romanToInt("MDCCCLXXXIV"));
  }

  public static void longestPalindrome() {
    System.out.println(Solution.longestPalindrome("abccccdd"));
  }


  public static void maximumProduct() {
    System.out.println(Solution.maximumProduct(new int[]{-1, -2, 1}));
  }

  public static void numberOfBoomerangs() {
    System.out.println(Solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
  }

  public static void readBinaryWatch() {
    System.out.println(String.join(",", Solution.readBinaryWatch(1)));
  }

  public static void checkRecord() {
    System.out.println(Solution.checkRecord("PPALLP"));
  }

  public static void checkRecord2() {
    System.out.println(Solution.checkRecord(3));
  }

  public static void toHex() {
    System.out.println(Solution.toHex(-1));
  }

  public static void findLHS() {
    System.out.println(Solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
  }

  public static void isHappy() {
    System.out.println(Solution.isHappy(2));
  }

  public static void removeElement() {
    System.out.println(Solution.removeElement(new int[]{1}, 1));
  }

  public static void repeatedSubstringPattern() {
    System.out.println(Solution.repeatedSubstringPattern("aba"));
  }

  public static void countSegments() {
    System.out.println(Solution.countSegments("  as d dd ao!"));
  }

  public static void guessNumber() {
    System.out.println(Solution.guessNumber(2126753390));
  }

  public static void countAndSay() {
    System.out.println(Solution.countAndSay(4));
  }

  public static void isIsomorphic() {
    System.out.println(Solution.isIsomorphic("egg", "add"));
  }

  public static void isValid() {
    System.out.println(Solution.isValid("()[]{}"));
  }

  public static void judgeSquareSum() {
    System.out.println(Solution.judgeSquareSum(2));
  }

  public static void findNthDigit() {
    System.out.println(Solution.findNthDigit(187));
  }

  public static void canPlaceFlowers() {
    System.out.println(Solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
  }

  public static void findUnsortedSubarray() {
    System.out.println(Solution.findUnsortedSubarray(new int[]{1, 3, 5, 4, 2}));
  }

  public static void minStack() {
    Solution.MinStack m = new Solution.MinStack();
    m.push(-2);
    m.push(0);
    m.push(1);
    System.out.println(m.getMin());
    m.pop();
    System.out.println(m.top());
    System.out.println(m.getMin());
  }

  public static void strStr() {
    System.out.println(Solution.strStr("abababaababacb", "ababacb"));
    System.out.println(Solution.strStr("mississippi", "issipi"));
    System.out.println(Solution.strStr("mississippi", "issip"));
    System.out.println(Solution.strStr("a", "a"));
  }

  public static void findPairs() {
    System.out.println(Solution.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    System.out.println(Solution.findPairs(new int[]{1, 1, 1, 1}, 0));
  }

  public static void constructMaximumBinaryTree() {
    Solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
  }

  public static void reconstructQueue() {
    Solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
  }

  public static void optimalDivision() {
    System.out.println(Solution.optimalDivision(new int[]{1000, 100, 10, 5, 2}));
  }

  public static void findDuplicate() {
    System.out.println(Solution.findDuplicate(
        new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"}));
  }

  public static void findLongestChain() {
//        System.out.println(Solution.findLongestChain(new int[][]{{3,4}, {2,3}, {1,2}}));
    System.out.println(Solution.findLongestChain(
        new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}}));
  }

  public static void fourSum() {
//    System.out.println(Solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    System.out.println(Solution.fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9));
//    System.out.println(Solution.fourSum(new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12));
  }

  public static void findDiagonalOrder() {
    System.out.println(Arrays.toString(Solution.findDiagonalOrder(new int[][]{{2, 3, 5}})));
  }

  public static void permute() {
    System.out.println(Solution.permute(new int[]{1, 2, 3}));
  }

  public static void permuteUnique() {
    System.out.println(Solution.permuteUnique(new int[]{1, 2, 3, 3}));
  }

  public static void combinationSum() {
    System.out.println(new Solution().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

  public static void combinationSum2() {
    System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

  public static void subsetWithDup() {
    System.out.println(new Solution().subsetsWithDup(new int[]{2, 1, 2}));
  }

  public static void maxProfitCooldown() {
    System.out.println(Solution.maxProfitCooldown(new int[]{1, 2, 3, 0, 2}));
  }

  public static void decodeString() {
    System.out.println(Solution.decodeString("ad3[a2[c]]2[ef]d"));
  }

  public static void numTrees() {
    System.out.println(Solution.numTrees(19));
  }

  public static void subarraySum() {
    System.out.println(Solution.subarraySum(new int[]{1, 2, 3}, 3));
  }

  public static void findKthLargest() {
    System.out.println(Solution.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
  }

  public static void trap() {
//        System.out.println(Solution.trap(new int[]{2,0,2}));
    System.out.println(Solution.trap(new int[]{5, 2, 1, 2, 1, 5}));
//        System.out.println(Solution.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
  }

  public static void letterCombinations() {
    System.out.println(Solution.letterCombinations("22"));
  }

  public static void buildTree() {
    System.out.println(Solution.buildTree(new int[]{0, 1}, new int[]{1, 0}));
  }

  public static void search() {
    System.out.println(Solution.search(new int[]{1, 2}, 0));
  }

  public static void sortList() {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(4);
    System.out.println(Solution.sortList(head));
  }

  public static void trie() {
    Solution.Trie trie = new Solution.Trie();
    trie.insert("a");
    System.out.println(trie.search("a"));
    System.out.println(trie.startsWith("a"));
  }

  public static void getPermutation() {
    System.out.println(Solution.getPermutation(4, 1));
  }

  public static void addTwoNumbers() {
    ListNode l1 = new ListNode(5);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(7);
    ListNode l2 = new ListNode(4);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(5);
    Solution.addTwoNumbers(l1, l2);
  }

  public static void LRUCache() {
    Solution.LRUCache cache = new Solution.LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }

  public static void BinaryTreeCodec() {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    System.out.println(Solution.BinaryTreeCodec.serialize(node));
  }

  public static void removeInvalidParentheses() {
    System.out.println(Solution.removeInvalidParentheses("()())()").toString());
  }

  public static void minWindow() {
    System.out.println(Solution.minWindow("a", "a"));
  }

  public static void minSubArrayLen() {
    System.out.println(Solution.minSubArrayLen(4, new int[]{1, 4, 4}));
  }

  public static void findMedianSortedArrays() {
    System.out.println(Solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
  }

  public static void threeSumWithoutSort() {
    System.out.println(Solution.threeSumWithouSort(new int[]{1, 0, -1, 0}).toString());
  }

  public static void minMeetingRooms() {
    System.out.println(Solution.minMeetingRooms(
        new Interval[]{
            new Interval(1, 5),
            new Interval(8, 9),
            new Interval(8, 9)
        })
    );
  }

  public static void numDecodings() {
    System.out.println(Solution.numDecodings("*1"));
  }

  public static void maxPoints() {
    System.out.println(Solution.maxPoints(new Point[]{
        new Point(0, 0),
        new Point(1, 1),
        new Point(-2, -2)
    }));
    System.out.println(Solution.maxPoints(new Point[]{
        new Point(0, 0),
        new Point(1, 1),
        new Point(1, -1)
    }));
  }

  public static void multiply() {
    System.out.println(Solution.multiply("123", "999"));
  }

  public static void fibonacci() {
    System.out.println(Solution.fibonacci(3));
    System.out.println(Solution.fibonacci(4));
    System.out.println(Solution.fibonacci(5));
    System.out.println(Solution.fibonacci(6));
    System.out.println(Solution.fibonacci(7));
    System.out.println(Solution.fibonacci(17));
    System.out.println(Solution.fibonacci(1117));
  }

  public static void isRegexMatch() {
    System.out.println(Solution.isRegexMatch("aa", "aa"));
    System.out.println(Solution.isRegexMatch("abcd", "d*"));
  }

  public static void isWildMatch() {
    System.out.println(Solution.isWildMatch("zacabz", "*a?b*"));
  }

  public static void subBinary() {
    System.out.println("Straightforward:");
    System.out.println(Solution.subBinary("0", "111"));
    System.out.println(Solution.subBinary("101", "100"));
    System.out.println(Solution.subBinary("1", "110"));
    System.out.println(Solution.subBinary("1111", "110"));
    System.out.println("Complementary:");
    System.out.println(Solution.subBinaryComplementary("0", "111"));
    System.out.println(Solution.subBinaryComplementary("101", "100"));
    System.out.println(Solution.subBinaryComplementary("1", "110"));
    System.out.println(Solution.subBinaryComplementary("1111", "110"));
  }

  public static void lengthLongestPath() {
    System.out.println(Solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    System.out.println(Solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
  }

  public static void largestRectangleArea() {
    System.out.println(Solution.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
  }

  public static void largestNumber() {
    System.out.println(Solution.largestNumber(new int[]{121, 12}));
  }

  public static void isValidSudoku() {
    System.out.println(Solution.isValidSudoku(new char[][]{
        {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
        {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}}));
  }

  public static void isSolvableSudoku() {
    char[][] input = new char[][]{
        {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
        {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
    Solution.solveSudoku(input);
    System.out.println(Arrays.toString(input));
  }

  public static void coinChange() {
    System.out.println(Solution.coinChange(new int[]{1}, 1));
  }

  public static void kthSmallest() {
    TreeNode r = new TreeNode(1);
    r.right = new TreeNode(2);
    System.out.println(Solution.kthSmallest(r, 2));
  }

  public static void findContestMatch() {
    System.out.println(Solution.findContestMatch(11));
  }

  public static void customSortString() {
    System.out.println(Solution.customSortString("cba", "asdbcd"));
  }

  public static void logger() {
    String r = "";
    Logger logger = new Logger();
    r += " " + logger.shouldPrintMessage(1, "foo");
    r += " " + logger.shouldPrintMessage(2, "bar");
    r += " " + logger.shouldPrintMessage(3, "foo");
    r += " " + logger.shouldPrintMessage(8, "bar");
    r += " " + logger.shouldPrintMessage(10, "foo");
    r += " " + logger.shouldPrintMessage(11, "foo");
    System.out.println(r);
  }

  public static void calPoints() {
    System.out.println(Solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
  }

  public static void hasAlternatingBits() {
    System.out.println(Solution.hasAlternatingBits(4));
    System.out.println(Solution.hasAlternatingBits(5));
  }

  public static void findPermutation() {
    System.out.println(Arrays.toString(Solution.findPermutation("DDIIDI")));
  }

  public static void maxProfitMaxcount() {
    System.out.println(Solution.maxProfitMaxcount(new int[]{2, 1, 4, 3}));
    System.out.println(Solution.maxProfitMaxcount(new int[]{3, 2, 6, 5, 0, 3}));
  }

  public static void maxProfitFee() {
    System.out.println(Solution.maxProfitFee(new int[]{1,3,2,8,4,9} ,2));
    System.out.println(Solution.maxProfitFee(new int[]{2,1,4,4,2,3,2,5,1,2} ,1));
  }

  public static void ipToCIDR() {
    System.out.println(Solution.ipToCIDR("255.0.0.7", 10));
    System.out.println(Solution.ipToCIDR("117.145.102.62", 8));
  }

  public static void shortestCompletingWord() {
    System.out.println(Solution.shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
  }

  public static void maxAreaOfIsland() {
    System.out.println(Solution.maxAreaOfIsland(new int[][]{
        {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}
    }));
  }

  public static void employeeFreeTime() {
    System.out.println(Solution.employeeFreeTime(Arrays.asList(
        Arrays.asList(new Interval(1,2), new Interval(5,6)),
        Arrays.asList(new Interval(1,3)),
        Arrays.asList(new Interval(4,10))
    )).toString());
  }

  public static void parseTernary() {
    System.out.println(Solution.parseTernary("F?T:F?T?1:2:F?3:4"));
  }

  public static void pathSum() {
    System.out.println(Solution.pathSum(new int[]{113, 215, 221}));
  }

  public static void deBrujinSequence() {
    int len = 2;
    int n = (int) Math.pow(10, len);
    String str = Solution.deBrujinSequence(len);
    System.out.println(str);
    System.out.println(str.length());

    for (int k = 0; k < n; k++) {
      if (!str.contains(String.format("%0" + len + "d", k))) {
        System.out.println(String.format("%0" + len + "d", k) + " unfound");
        return;
      }
    }

    System.out.println("pass");
  }

  public static void addBoldTag() {
    System.out.println(Solution.addBoldTag("abcxyz123", new String[]{"abc", "123"}));
    System.out.println(Solution.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc", "aaabbcc"}));
  }

  public static void similarRGB() {
    System.out.println(Solution.similarRGB("#09f166"));
  }

  public static void maxChunksToSorted() {
    System.out.println(Solution.maxChunksToSorted(new int[]{4,3,2,0,1}));
    System.out.println(Solution.maxChunksToSorted(new int[]{1,0,2,3,4}));
  }

  public static void maxChunksToSorted2() {
    System.out.println(Solution.maxChunksToSorted2(new int[]{1,3,2,4,1}));
    System.out.println(Solution.maxChunksToSorted2(new int[]{2,1,4,3,4}));
  }

  public static void solve() {
    Solution.solve(new char[][]{
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
    });
  }

  public static void mostCommonWord() {
    System.out.println(
        Solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
            new String[]{"hit"})
    );
  }
}
