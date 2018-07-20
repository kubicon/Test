package com.aspectworks.active24;


import ch.qos.logback.classic.util.ContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "${restapi.config.dir}/logback.xml");
       // Server server = Server.createTcpServer(args).start();
    }
}
