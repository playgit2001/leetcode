package DP;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Leetcode 139单词拆分
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

public class word_split {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> res = new HashSet(wordDict);//将字典放入Hashset方便查询
        //dp[i]保存dp[0]到dp[i-1]是否能被拆分为字典中字符串
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //如果dp[j]==true表名j-1之前的可以被拆分。然后再判断j到i之间的字符串是否含于字段中
                if (dp[j] && res.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
