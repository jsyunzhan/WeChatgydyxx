package domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "home/wages")
public class WagesManagementController {

    @RequestMapping(value = "/listpage")
    public ModelAndView index(){
        return new ModelAndView("wages");
    }
}
