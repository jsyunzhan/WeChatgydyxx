package domain.shiro;

import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.WebSessionObject;
import domain.shiro.service.UserSecurityService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static domain.shiro.entity.SystemConfig.LOGIN_SESSION;
import static org.apache.shiro.SecurityUtils.getSubject;


public class UserAuthorizingRealm extends AuthorizingRealm{

    final private UserSecurityService userSecurityService;



    @Autowired
    public UserAuthorizingRealm(UserSecurityService userSecurityService){
        this.userSecurityService = userSecurityService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        final UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        final String loginNameOrOpenid = usernamePasswordToken.getUsername();
        final String password = String.valueOf(usernamePasswordToken.getPassword());
        AccountEntity accountEntity;
        if (password.isEmpty()){
            accountEntity = userSecurityService.accoutInfoByOpenId(loginNameOrOpenid);
            if (null != accountEntity){
                accountEntity.setPassword("");
            }else {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                request.getSession().setAttribute("openid",loginNameOrOpenid);
                throw new DisabledAccountException("openid不存在.");
            }

        }else {
            accountEntity = userSecurityService.accoutInfoByLoginName(loginNameOrOpenid);
        }

        //账户是否存在
        if (null == accountEntity) {
            throw new UnknownAccountException("该账号不存在.");
        }

        final WebSessionObject webSessionObject = new WebSessionObject();
        //设置当前登录ID
        webSessionObject.setId(accountEntity.getId());
        //设置用户名称
        webSessionObject.setUserName(accountEntity.getUserName());
        //设置角色ID
        webSessionObject.setRoleId(accountEntity.getRoleId());
        //设置角色名称
        webSessionObject.setRoleName(accountEntity.getRoleName());

        //登录信息放入session中
        getSubject().getSession().setAttribute(LOGIN_SESSION,webSessionObject);

        return new SimpleAuthenticationInfo(loginNameOrOpenid, accountEntity.getPassword(),getName());
    }


}
