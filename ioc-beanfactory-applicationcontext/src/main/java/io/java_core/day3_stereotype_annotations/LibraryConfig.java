package io.java_core.day3_stereotype_annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.java_core.day3_stereotype_annotations")
public class LibraryConfig {
}
