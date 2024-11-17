package org.study.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring.config.MyConfiguration;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Value("${study.spring.bat02}")
    private String studySpringBat02;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MyConfiguration myConfiguration;

    @Test
    void contextLoads() {
        log.info(studySpringBat02);

//        MyConfiguration myConfiguration = applicationContext.getBean("MyConfiguration", MyConfiguration.class);
        String bat01 = myConfiguration.getBat01();
        System.out.println("bat01 = " + bat01);
        String bat02 = myConfiguration.getBat02();
        System.out.println("bat02 = " + bat02);


    }

}
