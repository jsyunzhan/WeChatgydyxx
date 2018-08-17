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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        final ModelAndView modelAndView = new ModelAndView("wagesList");
        modelAndView.addObject("title","工资查询");
        return modelAndView;
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
    public ModelAndView wagesDetails(@PathVariable("id") Long id){
        WagesEntity wagesEntity = wagesQueryManagementService.wagesDetails(id);

        final List<WagesEntity> wagesEntities = wagesQueryManagementService.wagesList(getLoginId());

        Long prevId = 0L;
        Long nextId = 0L;
        String prevTitile = "";
        String nextTitile = "";
        for (int i=0;i<wagesEntities.size();i++){
            if (wagesEntities.get(i).getId().equals(id)&&wagesEntities.size()!=1){
                if (i==0&&i!=wagesEntities.size()-1){
                    nextId = wagesEntities.get(i+1).getId();
                    nextTitile = wagesEntities.get(i+1).getWagesName();
                }else if (i==wagesEntities.size()-1){
                    prevId = wagesEntities.get(i-1).getId();
                    prevTitile = wagesEntities.get(i-1).getWagesName();
                }else {
                    nextId = wagesEntities.get(i+1).getId();
                    prevId = wagesEntities.get(i-1).getId();
                    nextTitile = wagesEntities.get(i+1).getWagesName();
                    prevTitile = wagesEntities.get(i-1).getWagesName();
                }

            }
        }


        final Map<String, Object> map = new HashMap<>(8);

        map.put("name",wagesEntity.getAccountName());
        map.put("title",wagesEntity.getWagesName());
        map.put("details",wagesEntity.getWagesdetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitle",prevTitile);
        map.put("nextTitle",nextTitile);

        map.put("wagesDate",wagesEntity.getWagesData().getTime());
        return new ModelAndView("wagesDetails");
    }
}
