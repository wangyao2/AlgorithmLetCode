package DataStructer;

/**
 * ClassName:enumStudy1
 * Description:
 *
 * @Create:2023/6/14 -21:27
 */
public class enumStudy1 {
    public static void main(String[] args) {
        System.out.println(Season.summer);

    }

}

//现在先手动实现一个枚举类
class Season{
    //枚举类的对象个数是一样的，一定要限制构造器，这样才能保证在外面不会被创建出来更多的对象
    //声明当前对象的实例变量
    private final String seasonName;//不要加static，不然这些属性就成了所有对象公用的了
    private final String SeasonDesc;

    //因为枚举类的对象个数是确定的，不会多更多的对象出来
    private Season(String seasonName, String seasonDesc){
        this.SeasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return SeasonDesc;
    }

    //在类的内部创建出来，那几个固定的对象，这几个固定的对象呢，只能在外面使用，不可以修改
    public static final Season spring = new Season("春天","春暖花开");
    public static final Season summer = new Season("夏天","夏日炎炎");
    public static final Season autumn = new Season("秋天","秋高气爽");
    public static final Season winter = new Season("冬天","白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }
}

