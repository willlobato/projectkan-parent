package projectkan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by willlobato on 31/07/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("template")
    public String list() {
        return "template";
    }

}
