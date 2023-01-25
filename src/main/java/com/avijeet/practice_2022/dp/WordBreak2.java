package com.avijeet.practice_2022.dp;

import java.util.*;

public class WordBreak2 {
    static Set<String> dict=new HashSet<>();
    static List<String>[] dp;
    static public List<String> wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        int n=s.length();
        dp = new ArrayList[n];
        for(int i=0;i<n;i++){
            dp[i] =new ArrayList();
        }
        for(int i=-1;i<n;i++){
            if(i>=0&&dp[i].size()==0){
                continue;
            }
            for(int k=i+1;k<n;k++){
                String word=s.substring(i+1,k+1);
                if(dict.contains(word)){
                    if(i==-1){
                        dp[k].add(word);
                    }else{
                        for(String prefix:dp[i]){
                            dp[k].add(prefix+" "+word);
                        }
                    }
                }
            }
        }
//        for(List<String> list:dp){
//            System.out.println(list);
//        }
        return dp[n-1];
//        return wordBreak(s, 0, n);
    }

//    static public List<String> wordBreak(String s, int i, int j) {
//        if(i==j){
//            return new ArrayList<>();
//        }
//        if(memo[i]!=null){
//            return memo[i];
//        }
//        List<String> res=new ArrayList<>();
//        for(int k=i;k<j;k++){
//            String word=s.substring(i,k+1);
//            if(dict.contains(word)){
//                List<String> childSentences=wordBreak(s, k+1, j);
//                if(childSentences.size()==0){
//                    res.add(word);
//                }
////                System.out.println(childSentences);
//                for(String childSentence:childSentences){
//                    if(childSentence.replace(" ","").length()==j-1-k){
//                        res.add(word+" "+childSentence);
//                    }
//                }
//            }
//        }
//        return memo[i]=res;
//    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }
}
