package domain.home.service.impl;

import domain.home.dao.NewsDao;
import domain.home.entity.NewsEntity;
import domain.home.service.NewsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsManagementServiceImpl implements NewsManagementService{

    final private NewsDao newsDao;

    @Autowired
    public NewsManagementServiceImpl(NewsDao newsDao){
        this.newsDao = newsDao;
    }

    @Override
    public List<NewsEntity> newsList(NewsEntity newsEntity) {
        return newsDao.newsList(newsEntity);
    }

    @Override
    public NewsEntity newsDetails(Long id) {
        return newsDao.newsDetails(id);
    }
}
