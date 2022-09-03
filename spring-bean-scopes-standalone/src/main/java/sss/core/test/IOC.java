package sss.core.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sss.core.beans.SingleTonBeans;

public class IOC {
    public static void main(String[] args) {
        /**
         * scopes check [singleton, prototype]
         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
         SingleTonBeans singleTonBeans1 = applicationContext.getBean("stBeans", SingleTonBeans.class);
         SingleTonBeans singleTonBeans2 = applicationContext.getBean("stBeans", SingleTonBeans.class);
         System.out.println(singleTonBeans1.hashCode());
         System.out.println(singleTonBeans2.hashCode());
         System.out.println(singleTonBeans1.getPrototypeBean());
         System.out.println(singleTonBeans1.getPrototypeBean());
         */

        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("application-context2.xml");
        SingleTonBeans singleTonBeans10 = applicationContext1.getBean("stBeans1", SingleTonBeans.class);
        SingleTonBeans singleTonBeans11 = applicationContext1.getBean("stBeans1", SingleTonBeans.class);
        SingleTonBeans singleTonBeans20 = applicationContext2.getBean("stBeans2", SingleTonBeans.class);
        SingleTonBeans singleTonBeans21 = applicationContext2.getBean("stBeans2", SingleTonBeans.class);

        System.out.println(singleTonBeans10 +" "+singleTonBeans11);
        System.out.println(singleTonBeans20 +" "+singleTonBeans21);
    }
}
