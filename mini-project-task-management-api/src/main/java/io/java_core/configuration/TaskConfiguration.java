package io.java_core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "io.java_core")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class TaskConfiguration {
}
