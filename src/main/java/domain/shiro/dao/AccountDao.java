package domain.shiro.dao;

import domain.shiro.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    /**
     * 根据openid查询用户信息
     * @param openid
     * @return
     */
    AccountEntity accoutInfoByOpenId(String openid);

    /**
     * 根据登录名查询用户信息
     * @param loginName
     * @return
     */
    AccountEntity accoutInfoByLoginName(String loginName);
}
