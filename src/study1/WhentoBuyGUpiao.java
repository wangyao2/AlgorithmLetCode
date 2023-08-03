package study1;

import javax.sound.midi.Soundbank;

public class WhentoBuyGUpiao {
    static int MaxPriceDay = 0;//记录最大值天数

    public static void main(String[] args) {
        int[] price = {1};
        System.out.println(maxProfit(price));

    }

    private static int fineTheMax(int[] array) {
        int max = 0;
        int i = 0;
        for (i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                MaxPriceDay = i;
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int Profit = 0;
        if (prices.length <= 1){
            return Profit;
        }
        int i = 0;
        int j = 1;
        int tmp = 0;
        int Currenti = prices[i];
        int Movej = prices[j];
        //System.out.println(prices.length);
        while (true) {
            if (Movej > Currenti) {
                Profit = Profit + (prices[j]- prices[i]);
                j++;i++;
                if (j == prices.length ) break;
                Movej = prices[j];
                Currenti = prices[i];
            }
            if (Movej <= Currenti){
                j++;i++;
                if (j == prices.length ) break;
                Movej = prices[j];
                Currenti = prices[i];
            }
        }
        return Profit;
    }

}

class Person {


}