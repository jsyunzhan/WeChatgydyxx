package domain.home.controller;

import domain.home.entity.NewsEntity;
import domain.home.service.NewsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping(value = "/details")
    @ResponseBody
    public NewsEntity newsDetails(@PathVariable("id") Long id){
        return newsManagementService.newsDetails(id);
    }
}
