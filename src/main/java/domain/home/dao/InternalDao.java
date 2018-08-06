package domain.home.dao;

import domain.home.entity.NoticeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternalDao {
    List<NoticeEntity> internalList(NoticeEntity noticeEntity);
}
