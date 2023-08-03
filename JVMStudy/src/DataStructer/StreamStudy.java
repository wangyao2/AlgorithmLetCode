package DataStructer;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * ClassName:StreamStudy
 * Description:
 *
 * @Create:2023/6/3 -18:27
 */
public class StreamStudy {
    public static void main(String[] args) {

        List<Userr> userlist = Arrays.asList(
                new Userr("wang1",1,1),
                new Userr("wang2",2,2),
                new Userr("wang3",3,3),
                new Userr("wang4",4,4)
        );
        Stream<Userr> userrStream = userlist.stream();
        //Stream<Integer> integerStream = userrStream.map(x -> x.getAge());
        Object[] objects = userrStream.map(Userr::getName).toArray();
        List<String> objects1 = Arrays.asList(Arrays.toString(objects));
        System.out.println(objects1);

        int in = -40;
        int i = in >> 3;
        System.out.println(i);
        int k = in << 3;
        System.out.println(k);
    }
}

class Userr {
    String name;
    int age;
    int size;

    public Userr(String name, int age, int size) {
        this.name = name;
        this.age = age;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
