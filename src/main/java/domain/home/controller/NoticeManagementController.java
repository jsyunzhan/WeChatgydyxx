package domain.home.controller;

import domain.home.entity.NoticeEntity;
import domain.home.entity.SearchEntity;
import domain.home.service.NoticeManagementService;
import domain.home.service.SearchManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "homepage/notice")
public class NoticeManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeManagementController.class);

    final private NoticeManagementService noticeManagementService;
    final private SearchManagementService searchManagementService;

    @Autowired
    public NoticeManagementController(NoticeManagementService noticeManagementService,SearchManagementService searchManagementService){
        this.noticeManagementService = noticeManagementService;
        this.searchManagementService = searchManagementService;
    }

    /**
     * 去集合页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/listpage")
    public ModelAndView index(){
        final ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("url","notice");
        modelAndView.addObject("title","通知中心");
        return modelAndView;
    }

    /**
     * 查询所有
     * @param noticeEntity 查询实体
     * @return List<NoticeEntity>
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public List<NoticeEntity> noticelist(NoticeEntity noticeEntity){
        return noticeManagementService.noticelist(noticeEntity);
    }

    /**
     * 查看详情
     * @param id
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView noticeDetails(@PathVariable("id") Long id) throws ParseException {
        final NoticeEntity noticeEntity = noticeManagementService.noticeDetails(id);
        final NoticeEntity noticeEntityQuery = new NoticeEntity();
        final List<NoticeEntity> noticeEntities = noticeManagementService.noticelist(noticeEntityQuery);

        Long prevId = 0L;
        Long nextId = 0L;
        String prevTitile = "";
        String nextTitile = "";
        for (int i=0;i<noticeEntities.size();i++){
            if (noticeEntities.get(i).getId().equals(id)&&noticeEntities.size()!=1){
                if (i==0){
                    nextId = noticeEntities.get(i+1).getId();
                    nextTitile = noticeEntities.get(i+1).getTitle();
                }else if (i==noticeEntities.size()-1){
                    prevId = noticeEntities.get(i-1).getId();
                    prevTitile = noticeEntities.get(i-1).getTitle();
                }else {
                    nextId = noticeEntities.get(i+1).getId();
                    prevId = noticeEntities.get(i-1).getId();
                    nextTitile = noticeEntities.get(i+1).getTitle();
                    prevTitile = noticeEntities.get(i-1).getTitle();
                }

            }
        }


        final Map<String, Object> map = new HashMap<>(11);
        map.put("title",noticeEntity.getTitle());
        map.put("details",noticeEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitile",prevTitile);
        map.put("nextTitile",nextTitile);
        map.put("url","notice");
        map.put("queryTitle","");
        map.put("clickCount",noticeEntity.getClickCount());
        map.put("createDate", noticeEntity.getCreateDate().getTime());
        map.put("picturePath",noticeEntity.getPicturePath());
        return new ModelAndView("details",map);
    }


    @RequestMapping(value = "/details/search/{id}")
    @ResponseBody
    public ModelAndView noticeSearchDetails(@PathVariable("id") Long id,@RequestParam("queryTitle") String queryTitle) throws ParseException{
        final NoticeEntity noticeEntity = noticeManagementService.noticeDetails(id);
        final List<SearchEntity> searchEntities = searchManagementService.searchList(queryTitle);

        Long prevId = 0L;
        Long nextId = 0L;
        String prevTitile = "";
        String nextTitile = "";
        String prevUrl = "";
        String nextUrl = "";
        for (int i=0;i<searchEntities.size();i++){
            if (searchEntities.get(i).getTableId().equals(id)&&searchEntities.size()!=1&&"/homepage/notice/details/".equals(searchEntities.get(i).getUrl())){
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
        map.put("title",noticeEntity.getTitle());
        map.put("details",noticeEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitile",prevTitile);
        map.put("nextTitile",nextTitile);
        map.put("nextUrl",nextUrl);
        map.put("prevUrl",prevUrl);
        map.put("queryTitle",queryTitle);
        map.put("clickCount",noticeEntity.getClickCount());
        map.put("createDate", noticeEntity.getCreateDate().getTime());
        map.put("picturePath",noticeEntity.getPicturePath());
        return new ModelAndView("searchdetails",map);
    }
}
