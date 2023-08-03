package LetCode;

/**
 * ClassName:Jewels
 * Description: 我的想法，应该是一个字符串检索和匹配问题，从jewels当中逐个的拿出一个元素，然后跟stones当中的每一个都对比一边。
 * 优化的过程是stones对比出一个宝石之后就不再参与下一次的对比了。
 *
 * @Create:2023/6/12 -17:37
 */

/*
给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。stones中每个字符代表了一种你拥有的石头的类型，
你想知道你拥有的石头中有多少是宝石。字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
输入：jewels = "aA", stones = "aAAbbbb"
输出：3
 */
public class JewelsandStone711 {
    public static void main(String[] args) {
        JewelsandStone711 jewelsandStone711 = new JewelsandStone711();
        String jewels = "";
        String stones = "ZZ";
        int i = jewelsandStone711.numJewelsInStones(jewels, stones);
        System.out.println(i);
    }
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        char[] jewchars = jewels.toCharArray();
        char[] stonechars = stones.toCharArray();
        int jewlength = jewchars.length;
        int stonlenttg = stonechars.length;
        for (int i = 0; i < jewlength; i++) {
            for (int ii = 0; ii < stonechars.length; ii++) {
                if (stonechars[ii] == jewchars[i]){
                    count++;
                }
            }
        }
        return count;
    }

}
