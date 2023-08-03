package DataStructer;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ClassName:SimpleBitMap
 * Description:
 *
 * @Create:2023/6/2 -15:20
 */
public class SimpleBitMap {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 7, 14, 3};
//        ArrayList<BitMap> simpleBitMaps = new ArrayList<>();
//        Stream<BitMap> simpleBitMapStream = simpleBitMaps.stream();
//        Object[] toArray = simpleBitMapStream.toArray();
//        Optional<BitMap> any1 = simpleBitMapStream.findAny();
//        BitMap simpleBitMap = any1.get();
//        IntStream intStream = Arrays.stream(arr).map(e -> e + 3);
//        int[] ints = intStream.toArray();
//        System.out.println(Arrays.toString(ints));

        int maxArr = Arrays.stream(arr).max().getAsInt();
        // 指定BitMap长度
        BitMap bitMap = new BitMap(maxArr + 1);
        // 数组的整数放进BitMap
        for (int i = 0; i < arr.length; i++) {
            bitMap.set(arr[i]);
        }
        // 判断哪些值存在
        for (int i = 0; i < maxArr + 1; i++) {
            System.out.println(i + "  Whether data is exsit " + bitMap.get(i));
        }

    }

}

class BitMap {
    private char[] bytes; // 用字符数组存储元素
    private int nBits; // 指定BitMap长度

    public BitMap(int nBits) {
        this.nBits = nBits;
        this.bytes = new char[nBits / 16 + 1]; // 一个字符占2个字节，也就是2*8=16bit
    }

    /**
     * 设置int整数对应的位，修改为1
     */
    public void set(int k) {
        if (k > nBits)
            return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    /**
     * 获取int整数对应的位是否存在，true存在，false不存在
     */
    public boolean get(int k) {
        if (k > nBits)
            return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}
// 1000 0001 1001 100   ，6, 2, 7, 14, 3
