package com.wukp.boot;

import com.wukp.boot.config.MessageConfiguration;
import com.wukp.boot.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=StartApplication.class)//base.java位于本分支下
public class DemoApplicationTests {




//    @Autowired
//    private RedisUtils redisUtils;
//
//    @Test
//    public void test() {
//        redisUtils.set("123", "hello world");
//        System.out.println("进入了方法");
//        String string = redisUtils.get("123").toString();
//
//        System.out.println("string==>" + string);
//        try {
//            Thread.sleep(11 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        string = StringUtils.isEmpty(redisUtils.get("123"))?"":redisUtils.get("123").toString();
//        System.out.println("string=" + string);
//    }



    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);

        if (ctx.getBean("message") instanceof String){
            System.out.println((String)ctx.getBean("message") );
            System.out.println((String)ctx.getBean("message4gou") );

        }

        System.out.println("wukp");
        assertEquals("message configuration",ctx.getBean("message") );
    }


//    @Test
//    public void testSayHello() {
//        assertEquals("Hello,World!",new HelloWorldController().sayHello());
//    }

//    @Test
//    public void testScanPackages() throws Exception {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.scan("com.wukp.boot");
//        ctx.refresh();
//        System.err.println(""+ctx.getBean("message").toString());
//        assertEquals("message configuration", ctx.getBean("message"));
//    }
}
