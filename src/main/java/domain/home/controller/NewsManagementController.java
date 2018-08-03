package domain.home.controller;

import domain.home.entity.NewsEntity;
import domain.home.service.NewsManagementService;
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
@RequestMapping(value = "home/news")
public class NewsManagementController {

    final private NewsManagementService newsManagementService;

    @Autowired
    public NewsManagementController(NewsManagementService newsManagementService){
        this.newsManagementService = newsManagementService;
    }

    /**
     * 去集合页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/listpage")
    public ModelAndView index(){
        final ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("url","news");
        modelAndView.addObject("title","新闻中心");
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<NewsEntity> newsList(NewsEntity newsEntity){
        return newsManagementService.newsList(newsEntity);
    }

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView newsDetails(@PathVariable("id") Long id){
        final NewsEntity newsEntity = newsManagementService.newsDetails(id);
        final Map<String, Object> map = new HashMap<>(4);
        map.put("title",newsEntity.getTitle());
        map.put("details",newsEntity.getDetails());
        map.put("picturePath",newsEntity.getPicturePath());
        map.put("createDate",newsEntity.getCreateDate());
        return new ModelAndView("details",map);
    }
}
