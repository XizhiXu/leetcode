package com.xizhi;

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
        System.out.println(Solution.reverseWords("Let's take LeetCode contest"));
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
        System.out.println(Solution.imageSmoother(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}));
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
//        System.out.println(Solution.strStr("abababaababacb", "ababacb"));
//        System.out.println(Solution.strStr("mississippi", "issipi"));
        System.out.println(Solution.strStr("mississippi", "issip"));
    }
}
