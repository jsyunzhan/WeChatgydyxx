package domain.home.service;

import domain.home.entity.NoticeEntity;

import java.util.List;

public interface NoticeManagementService {
    /**
     * 查询所有
     * @param noticeEntity 查询实体
     * @return List<NoticeEntity>
     */
    List<NoticeEntity> noticelist(NoticeEntity noticeEntity);
}
