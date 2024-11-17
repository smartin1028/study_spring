package org.study.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "study.spring")
@Data
public class MyConfiguration {
    private String bat01;
    private String bat02;

}