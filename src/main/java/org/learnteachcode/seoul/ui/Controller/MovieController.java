package org.learnteachcode.seoul.ui.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mashhur on 3/22/17.
 */

@RestController
@EnableAutoConfiguration
public class MovieController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to MovieGram!";
    }
}
