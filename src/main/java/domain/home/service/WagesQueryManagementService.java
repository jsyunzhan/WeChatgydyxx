package domain.home.service;

import domain.home.entity.WagesEntity;

import java.util.List;

public interface WagesQueryManagementService {
    List<WagesEntity> wagesList(Long loginId);

    WagesEntity wagesDetails(Long id);
}
