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
@RequestMapping(value = "homepage/news")
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
        final NewsEntity newsEntityQuery = new NewsEntity();
        final List<NewsEntity> newsEntities = newsManagementService.newsList(newsEntityQuery);

        Long prevId = 0L;
        Long nextId = 0L;
        for (int i=0;i<newsEntities.size();i++){
            if (newsEntities.get(i).getId().equals(id)){
                if (i==0){
                    nextId = newsEntities.get(i+1).getId();
                }else if (i==newsEntities.size()-1){
                    prevId = newsEntities.get(i-1).getId();
                }else {
                    nextId = newsEntities.get(i+1).getId();
                    prevId = newsEntities.get(i-1).getId();
                }

            }
        }

        final Map<String, Object> map = new HashMap<>(6);
        map.put("title",newsEntity.getTitle());
        map.put("details",newsEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("picturePath",newsEntity.getPicturePath());
        map.put("createDate",newsEntity.getCreateDate());
        return new ModelAndView("details",map);
    }
}
