package domain.home.controller;

import domain.home.entity.WagesEntity;
import domain.home.service.WagesQueryManagementService;
import domain.shiro.controller.AbstractActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "homepage/wages")
public class WagesQueryManagementController extends AbstractActionController{

    final private WagesQueryManagementService wagesQueryManagementService;

    @Autowired
    public WagesQueryManagementController(WagesQueryManagementService wagesQueryManagementService){
        this.wagesQueryManagementService = wagesQueryManagementService;
    }

    @RequestMapping(value = "/listpage")
    public ModelAndView index(){
        return new ModelAndView("wages");
    }

    /**
     * 查询自己的工资
     * @return List<WagesEntity>
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public List<WagesEntity> wagesList(){
        return wagesQueryManagementService.wagesList(getLoginId());
    }

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public WagesEntity wagesDetails(@PathVariable("id") Long id){
        return wagesQueryManagementService.wagesDetails(id);
    }
}
