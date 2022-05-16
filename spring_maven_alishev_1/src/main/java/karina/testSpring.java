package karina;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        testBean mytestBean = context.getBean("testBean", testBean.class);

        System.out.println(mytestBean.getName());

        context.close();
    }
}
