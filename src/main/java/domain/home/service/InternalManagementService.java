package domain.home.service;


import domain.home.entity.NoticeEntity;

import java.util.List;

public interface InternalManagementService {
    List<NoticeEntity> internalList(NoticeEntity noticeEntity);
}
