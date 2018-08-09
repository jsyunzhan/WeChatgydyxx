package domain.home.controller;

import domain.home.entity.BannerEntity;
import domain.home.service.BannerManagementService;
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
@RequestMapping(value = "/homepage/banner")
public class BannerManagementController {

    final private BannerManagementService bannerManagementService;

    @Autowired
    public BannerManagementController(BannerManagementService bannerManagementService){
        this.bannerManagementService = bannerManagementService;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<BannerEntity> bannerList(BannerEntity bannerEntity){
        return bannerManagementService.bannerList(bannerEntity);
    }

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public ModelAndView bannerDetails(@PathVariable("id") Long id){
        final BannerEntity bannerEntity =bannerManagementService.bannerDetails(id);
        final BannerEntity bannerEntityQuery = new BannerEntity();
        final List<BannerEntity> bannerEntities = bannerManagementService.bannerList(bannerEntityQuery);

        Long prevId = 0L;
        Long nextId = 0L;
        String prevTitile = "";
        String nextTitile = "";
        for (int i=0;i<bannerEntities.size();i++){
            if (bannerEntities.get(i).getId().equals(id)&&bannerEntities.size()!=1){
                if (i==0){
                    nextId = bannerEntities.get(i+1).getId();
                    nextTitile = bannerEntities.get(i+1).getTitle();
                }else if (i==bannerEntities.size()-1){
                    prevId = bannerEntities.get(i-1).getId();
                    prevTitile = bannerEntities.get(i-1).getTitle();
                }else {
                    nextId = bannerEntities.get(i+1).getId();
                    prevId = bannerEntities.get(i-1).getId();
                    nextTitile = bannerEntities.get(i+1).getTitle();
                    prevTitile = bannerEntities.get(i-1).getTitle();
                }

            }
        }

        final Map<String, Object> map = new HashMap<>(10);
        map.put("title",bannerEntity.getTitle());
        map.put("details",bannerEntity.getDetails());
        map.put("prevId",prevId);
        map.put("nextId",nextId);
        map.put("prevTitle",prevTitile);
        map.put("nextTitle",nextTitile);
        map.put("url","banner");
        map.put("clickCount",bannerEntity.getClickCount());
        map.put("picturePath",bannerEntity.getPicturePath());
        map.put("createDate",bannerEntity.getCreateDate().getTime());
        return new ModelAndView("details");
    }
}
