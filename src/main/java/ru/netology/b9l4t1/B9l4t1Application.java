package ru.netology.b9l4t1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class B9l4t1Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(B9l4t1Application.class, args);
        BaseInit baseInit = applicationContext.getBean(BaseInit.class);
        baseInit.run();
    }

}
