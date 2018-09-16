package com.jvdkolk.wickettest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WicketTestApplication {

    public static void main(final String[] args) {
        new SpringApplicationBuilder()
                .sources(WicketTestApplication.class)
                .run(args);
    }
}
