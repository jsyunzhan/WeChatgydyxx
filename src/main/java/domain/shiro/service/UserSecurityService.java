package domain.shiro.service;

import domain.shiro.entity.AccountEntity;

public interface UserSecurityService {
    AccountEntity accoutInfoByOpenId(String openid);

    AccountEntity accoutInfoByLoginName(String loginName);
}
