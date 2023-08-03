package DataStructer;

/**
 * ClassName:SeasonTest1
 * Description:
 *
 * @Create:2023/6/14 -22:04
 */
public class SeasonTest1 {
    public static void main(String[] args) {
            System.out.println(Season1.summer);
    }
}

interface info{
    void show();
}
enum Season1{

    //在类的内部创建出来，那几个固定的对象，这几个固定的对象呢，只能在外面使用，不可以修改
    //枚举类的对象数量是确定的，必须用public static final 声明
    //枚举类的原型：public static final Season1 summer = new Season1("夏天","夏日炎炎");
    spring ("春天","春暖花开"),//必须用逗号隔开，不能用别的
    summer ("夏天","夏日炎炎"),
    autumn ("秋天","秋高气爽"),
    winter ("冬天","白雪皑皑");

    //枚举类的对象个数是一样的，一定要限制构造器，这样才能保证在外面不会被创建出来更多的对象
    //声明当前对象的实例变量
    private final String seasonName;//不要加static，不然这些属性就成了所有对象公用的了
    private final String SeasonDesc;

    //因为枚举类的对象个数是确定的，不会多更多的对象出来
    private Season1(String seasonName, String seasonDesc){
        this.SeasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return SeasonDesc;
    }


    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }
}
