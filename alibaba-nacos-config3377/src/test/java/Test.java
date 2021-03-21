/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-09
 */
public class Test {

    public static void main(String[] args) {

        String java = new String("java");

        System.out.println(java == java.intern());
    }
}
