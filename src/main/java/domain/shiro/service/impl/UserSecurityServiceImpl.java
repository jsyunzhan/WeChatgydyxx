package domain.shiro.service.impl;

import domain.shiro.dao.AccountDao;
import domain.shiro.entity.AccountEntity;
import domain.shiro.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSecurityServiceImpl implements UserSecurityService{

    final private AccountDao accountDao;

    @Autowired
    public UserSecurityServiceImpl(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public AccountEntity accoutInfoByOpenId(String openid) {
        return accountDao.accoutInfoByOpenId(openid);
    }

    @Override
    public AccountEntity accoutInfoByLoginName(String loginName) {
        return accountDao.accoutInfoByLoginName(loginName);
    }
}
