package domain.home.service.impl;

import domain.home.dao.WagesDao;
import domain.home.entity.WagesEntity;
import domain.home.service.WagesQueryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WagesQueryManagementServiceImpl implements WagesQueryManagementService{
    final private WagesDao wagesDao;

    @Autowired
    public WagesQueryManagementServiceImpl(WagesDao wagesDao){
        this.wagesDao = wagesDao;
    }
    @Override
    public List<WagesEntity> wagesList(Long loginId) {
        return wagesDao.wagesList(loginId);
    }

    @Override
    public WagesEntity wagesDetails(Long id) {
        return wagesDao.wagesDetails(id);
    }
}
