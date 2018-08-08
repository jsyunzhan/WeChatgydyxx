package domain.home.dao;

import domain.home.entity.NewsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {
    List<NewsEntity> newsList(NewsEntity newsEntity);

    NewsEntity newsDetails(Long id);

    Integer updateCount(Long id);
}
