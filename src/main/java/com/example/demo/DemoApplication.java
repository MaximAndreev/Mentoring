package com.example.demo;

import org.springframework.boot.SpringApplication;
import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        if (args.length != 2) {
            throw new UnsupportedOperationException("Operation unsupported");
        }

        BigDecimal result = handleException(() -> addition(args[0], args[1]));

        System.out.println("Result: " + result);
    }

    private static BigDecimal addition(String arg1, String arg2) {
        return new BigDecimal(arg1).add(new BigDecimal(arg2));
    }

    private static BigDecimal handleException(Callable<BigDecimal> callable) {
        try {
            return callable.call();
        } catch (Exception any) {
            throw new RuntimeException("Error on operation", any);
        }
    }
}
