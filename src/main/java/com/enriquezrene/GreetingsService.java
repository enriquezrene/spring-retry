package com.enriquezrene;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by rene on 14/11/16.
 */
@Service
public class GreetingsService {

    @Retryable(RuntimeException.class)
    public String work(String message) {
        if ("bye".equals(message)) {
            System.out.println("working on...");
            throw new RuntimeException("No farewells allowed");
        } else {
            System.out.println("message has been processed: " + message);
        }
        return "done";
    }

    @Recover
    public String recoverWork(RuntimeException e, String message) {
        System.out.println("Recovering from " + message);
        System.out.println(e.getMessage());
        return "WTF";
    }
}
