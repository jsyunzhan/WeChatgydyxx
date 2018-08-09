package domain.home.service.impl;

import domain.home.dao.BannerDao;
import domain.home.entity.BannerEntity;
import domain.home.service.BannerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerManagementServiceImpl implements BannerManagementService{
    final private BannerDao bannerDao;

    @Autowired
    public BannerManagementServiceImpl(BannerDao bannerDao){
        this.bannerDao = bannerDao;
    }
    @Override
    public List<BannerEntity> bannerList(BannerEntity bannerEntity) {
        return bannerDao.bannerList(bannerEntity);
    }

    @Override
    public BannerEntity bannerDetails(Long id) {
        bannerDao.updateCount(id);
        return bannerDao.bannerDetails(id);
    }
}
