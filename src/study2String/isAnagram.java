package study2String;

import java.util.HashMap;

public class isAnagram {


    public static void main(String[] args) {
        String s = "anag", t = "naga";
        System.out.println(IsTheSameWord(s, t));


    }


    public static boolean IsTheSameWord(String s , String t){
        boolean flag = true;
        int slength = s.length();
        int tlength = t.length();
        if (slength ==0 && tlength==0) return true; //都是空的话，我们也认为是一样的
        if (slength != tlength) return false; //长度都不一样的话，那就直接肯定不是
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (char c : chars){
            hashMap1.put(c,hashMap1.getOrDefault(c,0) + 1);
        }
        for (char c : chart){
            hashMap2.put(c,hashMap2.getOrDefault(c,0) + 1);
        }

        int numIn1 = 0;
        int numIn2 = 0;
        try {
            for (char k : hashMap1.keySet()){
                numIn1 = hashMap1.get(k);
                numIn2 = hashMap2.get(k);
                if (numIn1 != numIn2) return false;
            }
        }catch (Exception e ){//发生异常就是说明，第一个表中的健不再第2个表中
            System.out.println(e);
            return false;
        }
        return true;

    }
}
