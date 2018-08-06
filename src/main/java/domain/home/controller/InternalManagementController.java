package domain.home.controller;

import domain.home.entity.NoticeEntity;
import domain.home.service.InternalManagementService;
import domain.shiro.controller.AbstractActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "home/internal")
public class InternalManagementController extends AbstractActionController{

    final private InternalManagementService internalManagementService;

    @Autowired
    public InternalManagementController(InternalManagementService internalManagementService){
        this.internalManagementService = internalManagementService;
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


}
