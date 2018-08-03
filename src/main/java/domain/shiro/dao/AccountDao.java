package domain.shiro.dao;

import domain.shiro.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据名称给openid赋值
     * @param loginName
     * @param openid
     * @return
     */
    Integer updateOpenId(@Param("loginName") String loginName,@Param("openid") String openid);
}
