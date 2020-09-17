package com.ranjun1999.personalutils.算法.nowcoder;

import java.util.*;

/**
 * @Author: ranjun
 * @Date: 2020/3/24 11:18
 */
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            urls.add(scanner.next());
        }

        HashMap<String,HashSet<String>> maps = modifyStrs(urls);
        Iterator<String> iterator = maps.keySet().iterator();
        List<String> domains = new ArrayList<>();
        while (iterator.hasNext()){
            String domain = iterator.next();
            domains.add(domain);
        }

        for (int i = 0; i < domains.size(); i++) {

        }

        String str = "google.com/test/app.a";
        String s = str.substring(7);
        System.out.println(s);
        String[] strs = str.split("/");
        System.out.println(strs.length);
    }

    public static HashMap<String,HashSet<String>> modifyStrs(List<String> strs){
        HashMap<String, HashSet<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.size(); i++) {
            String url = strs.get(i);
            String realUrl = url.substring(7);
            String[] spl = realUrl.split("/");
            //域名
            String domain = spl[0];
            if (spl.length == 1){
                HashSet<String> set = maps.getOrDefault(domain,new HashSet<>());
                if(realUrl.endsWith("/")){
                    set.add("/");
                }else {
                    set.add("");
                }
                maps.put(domain,set);
            }else {
                StringBuilder sb = new StringBuilder();
                for (int i1 = 1; i1 < spl.length; i1++) {
                    sb.append(spl[i]);
                }
                HashSet<String> set = maps.getOrDefault(domain,new HashSet<>());
                set.add(sb.toString());
                maps.put(domain,set);
            }
        }
        return maps;
    }

    public static boolean setEquals(HashSet<String> s1, HashSet<String> s2){
        if (s1.size() != s2.size()){
            return false;
        }

        return true;
    }

}

