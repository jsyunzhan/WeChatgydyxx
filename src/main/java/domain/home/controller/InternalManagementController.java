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
@RequestMapping(value = "homepage/internal")
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
    @ResponseBody
    public List<NoticeEntity> internalList(NoticeEntity noticeEntity){
        return internalManagementService.internalList(noticeEntity);
    }


    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView internalDetails(@PathVariable("id") Long id){
        final NoticeEntity noticeEntity = noticeManagementService.noticeDetails(id);
        final NoticeEntity noticeEntityQuery = new NoticeEntity();
        List<NoticeEntity> noticeEntities = internalManagementService.internalList(noticeEntityQuery);

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

        final Map<String, Object> map = new HashMap<>(10);
        map.put("title",noticeEntity.getTitle());
        map.put("details",noticeEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitle",prevTitile);
        map.put("nextTitle",nextTitile);
        map.put("url","internal");
        map.put("clickCount",noticeEntity.getClickCount());
        map.put("picturePath",noticeEntity.getPicturePath());
        map.put("createDate",noticeEntity.getCreateDate().getTime());
        return new ModelAndView("details",map);
    }
}
