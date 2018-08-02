package domain.home.service;

import domain.home.entity.NewsEntity;

import java.util.List;

public interface NewsManagementService {
    List<NewsEntity> newsList(NewsEntity newsEntity);

    NewsEntity newsDetails(Long id);
}
