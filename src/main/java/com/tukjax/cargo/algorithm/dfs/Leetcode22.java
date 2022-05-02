package com.tukjax.cargo.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    static class Solution {

        public static void main(String[] args) {
            generateParenthesis(3);
        }

        public static List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            pinSquare(n,n,n,res,"");

            return res;

        }

        public static void  pinSquare(int max, int leftRemains, int rightRemains, List<String> currentResult, String currentStr){
            System.out.println("current result = " + currentStr );
            //final
            if(rightRemains == 0 && leftRemains == 0) currentResult.add(currentStr);

            if(leftRemains > 0){
                pinSquare(max, --leftRemains, rightRemains,currentResult, currentStr + "(");
            }

            if(leftRemains < rightRemains){

                pinSquare(max, leftRemains, --rightRemains,currentResult, currentStr + ")");
            }

        }
    }
}
