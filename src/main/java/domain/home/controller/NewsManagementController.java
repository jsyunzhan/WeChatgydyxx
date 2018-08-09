package domain.home.controller;

import domain.home.entity.NewsEntity;
import domain.home.entity.SearchEntity;
import domain.home.service.NewsManagementService;
import domain.home.service.SearchManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "homepage/news")
public class NewsManagementController {

    final private NewsManagementService newsManagementService;
    final private SearchManagementService searchManagementService;

    @Autowired
    public NewsManagementController(NewsManagementService newsManagementService,SearchManagementService searchManagementService){
        this.newsManagementService = newsManagementService;
        this.searchManagementService = searchManagementService;
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



        final Map<String, Object> map = new HashMap<>(11);
        map.put("title",newsEntity.getTitle());
        map.put("details",newsEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitile",prevTitile);
        map.put("nextTitile",nextTitile);
        map.put("url","news");
        map.put("queryTitle","");
        map.put("clickCount",newsEntity.getClickCount());
        map.put("picturePath",newsEntity.getPicturePath());
        map.put("createDate",newsEntity.getCreateDate().getTime());
        return new ModelAndView("details",map);
    }

    @RequestMapping(value = "/details/search/{id}")
    @ResponseBody
    public ModelAndView newsSearchDetails(@PathVariable("id") Long id,@RequestParam("queryTitle") String queryTitle) throws ParseException {
        final NewsEntity newsEntity = newsManagementService.newsDetails(id);
        final List<SearchEntity> searchEntities = searchManagementService.searchList(queryTitle);

        Long prevId = 0L;
        Long nextId = 0L;
        String prevTitile = "";
        String nextTitile = "";
        String prevUrl = "";
        String nextUrl = "";
        for (int i=0;i<searchEntities.size();i++){
            if (searchEntities.get(i).getTableId().equals(id)&&searchEntities.size()!=1&&"/homepage/news/details/".equals(searchEntities.get(i).getUrl())){
                if (i==0){
                    nextId = searchEntities.get(i+1).getTableId();
                    nextTitile = searchEntities.get(i+1).getTitle();
                    nextUrl = searchEntities.get(i+1).getUrl() + "search/";
                }else if (i==searchEntities.size()-1){
                    prevId = searchEntities.get(i-1).getTableId();
                    prevTitile = searchEntities.get(i-1).getTitle();
                    prevUrl = searchEntities.get(i-1).getUrl() + "search/";
                }else {
                    nextId = searchEntities.get(i+1).getTableId();
                    prevId = searchEntities.get(i-1).getTableId();
                    nextTitile = searchEntities.get(i+1).getTitle();
                    prevTitile = searchEntities.get(i-1).getTitle();
                    nextUrl = searchEntities.get(i+1).getUrl() + "search/";
                    prevUrl = searchEntities.get(i-1).getUrl() + "search/";
                }

            }
        }
        final Map<String, Object> map = new HashMap<>(12);
        map.put("title",newsEntity.getTitle());
        map.put("details",newsEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitle",prevTitile);
        map.put("nextTitle",nextTitile);
        map.put("nextUrl",nextUrl);
        map.put("prevUrl",prevUrl);
        map.put("queryTitle",queryTitle);
        map.put("clickCount",newsEntity.getClickCount());
        map.put("createDate", newsEntity.getCreateDate().getTime());
        map.put("picturePath",newsEntity.getPicturePath());
        return new ModelAndView("searchdetails",map);
    }
}
