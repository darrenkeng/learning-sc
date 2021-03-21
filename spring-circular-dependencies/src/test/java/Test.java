import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-16
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        applicationContext.getBean("serviceA");

    }
}
