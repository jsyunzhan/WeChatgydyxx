package domain.home.service;

import domain.home.entity.BannerEntity;

import java.util.List;

public interface BannerManagementService {
    /**
     * 获取所有数据
     * @param bannerEntity
     * @return
     */
    List<BannerEntity> bannerList(BannerEntity bannerEntity);

    BannerEntity bannerDetails(Long id);
}
