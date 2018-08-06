package domain.home.controller;

import domain.home.entity.NoticeEntity;
import domain.home.service.InternalManagementService;
import domain.home.service.NoticeManagementService;
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
@RequestMapping(value = "home/internal")
public class InternalManagementController extends AbstractActionController{

    final private InternalManagementService internalManagementService;
    final private NoticeManagementService noticeManagementService;

    @Autowired
    public InternalManagementController(InternalManagementService internalManagementService,NoticeManagementService noticeManagementService){
        this.internalManagementService = internalManagementService;
        this.noticeManagementService = noticeManagementService;
    }


    @RequestMapping(value = "/listpage")
    public ModelAndView index(){
        final ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("url","internal");
        modelAndView.addObject("title","内部公示");
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public List<NoticeEntity> internalList(NoticeEntity noticeEntity){
        return internalManagementService.internalList(noticeEntity);
    }

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView internalDetails(@PathVariable("id") Long id){
        final NoticeEntity noticeEntity = noticeManagementService.noticeDetails(id);
        final Map<String, Object> map = new HashMap<>(4);
        map.put("title",noticeEntity.getTitle());
        map.put("details",noticeEntity.getDetails());
        map.put("picturePath",noticeEntity.getPicturePath());
        map.put("createDate",noticeEntity.getCreateDate());
        return new ModelAndView("details",map);
    }
}
