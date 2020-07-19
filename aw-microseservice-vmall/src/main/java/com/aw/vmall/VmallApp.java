package com.aw.vmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dengtongle
 * @create 2020-07-19 17:57
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.aw.vmall","com.aw.common"})
public class VmallApp {
    public static void main(String[] args){
        SpringApplication.run(VmallApp.class, args);
    }
}
