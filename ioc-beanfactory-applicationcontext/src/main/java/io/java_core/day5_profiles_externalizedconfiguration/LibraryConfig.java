package io.java_core.day5_profiles_externalizedconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
@ComponentScan(basePackages = "io.java_core.day5_profiles_externalizedconfiguration")
public class LibraryConfig {
}
