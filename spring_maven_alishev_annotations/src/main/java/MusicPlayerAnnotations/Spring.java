package MusicPlayerAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    public static void main(String[] args) {

        //start file applicationContext
        //but now applicationContext create beans for us with the stroke context:component-scan
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //define bean with getbean
        Computer computer = context.getBean("computer", Computer.class);

        System.out.println(computer);

        context.close();

    }
}
