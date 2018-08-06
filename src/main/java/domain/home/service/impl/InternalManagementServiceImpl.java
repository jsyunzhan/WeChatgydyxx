package domain.home.service.impl;

import domain.home.dao.InternalDao;
import domain.home.entity.NoticeEntity;
import domain.home.service.InternalManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InternalManagementServiceImpl implements InternalManagementService{

    final private InternalDao internalDao;

    @Autowired
    public InternalManagementServiceImpl(InternalDao internalDao){
        this.internalDao = internalDao;
    }

    @Override
    public List<NoticeEntity> internalList(NoticeEntity noticeEntity) {
        return internalDao.internalList(noticeEntity);
    }
}
