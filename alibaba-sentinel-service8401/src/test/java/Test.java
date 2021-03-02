import cn.hutool.http.HttpUtil;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: darren
 * @company: wonhigh
 * @create: 2021-03-01
 */
public class Test {

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(k -> {
            IntStream.range(1, 10).parallel().forEach(i -> {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName());
                    HttpUtil.get("http://localhost:8401/testF");
                }, "Test.main()-" + k + "-" + i).start();
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
