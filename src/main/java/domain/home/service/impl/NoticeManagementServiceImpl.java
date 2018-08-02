package domain.home.service.impl;

import domain.home.dao.NoticeDao;
import domain.home.entity.NoticeEntity;
import domain.home.service.NoticeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeManagementServiceImpl implements NoticeManagementService{
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeManagementServiceImpl.class);

    final private NoticeDao noticeDao;

    @Autowired
    public NoticeManagementServiceImpl(NoticeDao noticeDao){
        this.noticeDao = noticeDao;
    }

    @Override
    public List<NoticeEntity> noticelist(NoticeEntity noticeEntity) {
        return noticeDao.noticelist(noticeEntity);
    }

    @Override
    public NoticeEntity noticeDetails(Long id) {
        return noticeDao.noticeDetails(id);
    }
}
