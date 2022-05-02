package com.tukjax.cargo.spring.bean;


import java.util.HashSet;
import java.util.Set;

public class Cat {


    String catName;

    String catAge;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatAge() {
        return catAge;
    }

    public void setCatAge(String catAge) {
        this.catAge = catAge;
    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }


    public static int lengthOfLongestSubstring(String s) {
        int end = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        int n = s.length();
        for (int begin = 0; begin < n; begin++) {

            if (begin != 0) {
                System.out.println("remove " + s.charAt(begin - 1));
                set.remove(s.charAt(begin - 1));

            }

            Character cha1r = s.charAt(end);
            System.out.println("retChar " + cha1r);
            while (end < n && !set.contains(s.charAt(end))) {
                System.out.println("retChar1 "+s.charAt(end));
                set.add(s.charAt(end));
                System.out.println("add " +s.charAt(end));
                end++;
            }


            max = Math.max(max, end - begin);
        }
        return max;
    }

}
