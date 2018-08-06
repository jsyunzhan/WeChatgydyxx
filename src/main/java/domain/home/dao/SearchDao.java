package domain.home.dao;

import domain.home.entity.SearchEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao {


    List<SearchEntity> searchList(String title);

}
