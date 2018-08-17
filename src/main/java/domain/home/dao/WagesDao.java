package domain.home.dao;

import domain.home.entity.WagesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WagesDao {
    List<WagesEntity> wagesList
            (Long loginId);

    WagesEntity wagesDetails(Long id);
}
