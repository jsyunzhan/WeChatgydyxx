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

import java.util.List;

@Controller
@RequestMapping(value = "home/notice")
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
    public NoticeEntity noticeDetails(@PathVariable("id") Long id){
        return noticeManagementService.noticeDetails(id);
    }
}
