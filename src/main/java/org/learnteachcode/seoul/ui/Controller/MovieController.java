package org.learnteachcode.seoul.ui.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mashhur on 3/22/17.
 */

@Controller
public class MovieController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/discover", method = RequestMethod.GET)
    public ModelAndView method() {
        return new ModelAndView("redirect:/moviedb/api/discover");
    }
}