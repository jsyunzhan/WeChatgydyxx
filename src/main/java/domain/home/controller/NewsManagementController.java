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
        String prevTitile = "";
        String nextTitile = "";
        for (int i=0;i<newsEntities.size();i++){
            if (newsEntities.get(i).getId().equals(id)&&newsEntities.size()!=1){
                if (i==0&&i!=newsEntities.size()-1){
                    nextId = newsEntities.get(i+1).getId();
                    nextTitile = newsEntities.get(i+1).getTitle();
                }else if (i==newsEntities.size()-1){
                    prevId = newsEntities.get(i-1).getId();
                    prevTitile = newsEntities.get(i-1).getTitle();
                }else {
                    nextId = newsEntities.get(i+1).getId();
                    prevId = newsEntities.get(i-1).getId();
                    nextTitile = newsEntities.get(i+1).getTitle();
                    prevTitile = newsEntities.get(i-1).getTitle();
                }

            }
        }



        final Map<String, Object> map = new HashMap<>(10);
        map.put("title",newsEntity.getTitle());
        map.put("details",newsEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitile",prevTitile);
        map.put("nextTitile",nextTitile);
        map.put("url","news");
        map.put("clickCount",newsEntity.getClickCount());
        map.put("picturePath",newsEntity.getPicturePath());
        map.put("createDate",newsEntity.getCreateDate().getTime());
        return new ModelAndView("details",map);
    }
}
