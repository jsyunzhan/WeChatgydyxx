package domain.home.dao;

import domain.home.entity.BannerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao {
    /**
     * 全部数据
     * @param bannerEntity
     * @return
     */
    List<BannerEntity> bannerList(BannerEntity bannerEntity);

    BannerEntity bannerDetails(Long id);

    Integer updateCount(Long id);
}
