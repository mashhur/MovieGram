package org.learnteachcode.seoul.ui.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafExampleController {
    @RequestMapping("/thymeleaf")
    public String welcome(Model model,
                          @RequestParam(value = "name", required = false, defaultValue = "Thymeleaf") String name) {

        model.addAttribute("name", name);
        return "example_thymeleaf";
    }

    /*@RequestMapping(value = "message", method = RequestMethod.GET)
    public String message (Model model) {
        model.addAllAttributes("messages", messageRepository)
    }*/
}
