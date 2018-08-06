package domain.home.controller;

import domain.home.entity.NoticeEntity;
import domain.home.service.NoticeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "homepage/notice")
public class NoticeManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeManagementController.class);

    final private NoticeManagementService noticeManagementService;

    @Autowired
    public NoticeManagementController(NoticeManagementService noticeManagementService){
        this.noticeManagementService = noticeManagementService;
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

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView noticeDetails(@PathVariable("id") Long id){
        final NoticeEntity noticeEntity = noticeManagementService.noticeDetails(id);
        final Map<String, Object> map = new HashMap<>(4);
        map.put("title",noticeEntity.getTitle());
        map.put("details",noticeEntity.getDetails());
        map.put("picturePath",noticeEntity.getPicturePath());
        map.put("createDate",noticeEntity.getCreateDate());
        return new ModelAndView("details",map);
    }


}
