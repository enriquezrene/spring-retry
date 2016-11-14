package com.enriquezrene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rene on 14/11/16.
 */
@RestController
@RequestMapping("/retry")
public class ControllerWithRetry {

    @Autowired
    GreetingsService greetingsService;


    @RequestMapping(value = "/{message}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("message") String message) {
        String response = greetingsService.work(message);
        return response;
    }
}
