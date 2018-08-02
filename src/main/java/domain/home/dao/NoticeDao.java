package domain.home.dao;

import domain.home.entity.NoticeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    /**
     * 查询所有数据
     * @param noticeEntity 查询数据
     * @return List<NoticeEntity>
     */
    List<NoticeEntity> noticelist(NoticeEntity noticeEntity);
}
