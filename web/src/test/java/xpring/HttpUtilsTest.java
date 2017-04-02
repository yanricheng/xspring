package xpring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import net.yanrc.xpring.activity.common.utils.http.HttpRequestType;
import net.yanrc.xpring.activity.common.utils.http.SimpleHttpRequest;
import org.apache.commons.io.IOUtils;

import com.google.common.collect.Lists;

public class HttpUtilsTest {

    static AtomicLong x = new AtomicLong(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        final List<String> list = Lists.newArrayList();
        try {
            list.addAll(IOUtils.readLines(new FileInputStream(new File("/home/yanricheng/projects/xspring/src/test/java/1.txt"))));

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            java.util.Collections.shuffle(list);
            for (int i = 0; i < 200; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long j = System.currentTimeMillis();
                            long l = x.getAndIncrement();
                            String res = SimpleHttpRequest.newInstance().reqUrl("http://127.0.0.1:8080/api/v1/recommends")
                                    .reqType(HttpRequestType.GET)
                                    .addParameter("uid", list.get(new Random().nextInt(500)))
                                    .addParameter("pageNum", "-1")
                                    .execute().getResBody();
                            long k = System.currentTimeMillis();
                            System.out.println(l + ": " + (k - j) + "   " + res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5 * 1000);
                System.out.println("==========================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
