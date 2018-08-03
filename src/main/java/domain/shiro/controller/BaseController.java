package domain.shiro.controller;

import com.alibaba.fastjson.JSONObject;
import domain.shiro.AuthUtil;
import domain.shiro.entity.JsonResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;



@Controller
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/home/homepage")
    public ModelAndView index(){
        return new ModelAndView("homepage");
    }

    /**
     * 账号密码登录
     * @return
     */
    @RequestMapping(value = "/home/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    /**
     * 登录成功提示
     * @return
     */
    @RequestMapping(value = "/home/alert")
    public ModelAndView alert(){
        return new ModelAndView("alert");
    }

    //微信认证开始
    @RequestMapping(value = "/security/movetologin")
    @ResponseBody
    public void doget(HttpServletRequest request, HttpServletResponse response) throws IOException {


        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("微信登录认证");
        }

        //开发
        String backUrl = "http://192.168.199.108:80"+request.getContextPath()+"/security/backUrl";

        //测试
//        String backUrl = "http://jy.gylzzx.cn:8888"+request.getContextPath()+"/security/backUrl";

        String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID
                + "&redirect_uri=" +URLEncoder.encode(backUrl)
                +"&response_type=code" +
                "&scope=snsapi_userinfo&state=STATE#wechat_redirect";

        response.sendRedirect(url);
    }

    //微信接口返回地址
    @RequestMapping(value = "/security/backUrl")
    public void doBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID +
                "&secret=" + AuthUtil.APPSECTE +
                "&code=" + code +
                "&grant_type=authorization_code";

        JSONObject jsonObject = AuthUtil.doGetJson(url);


        String openid = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token +
                "&openid=" + openid +
                "&lang=zh_CN";

        JSONObject userInfo = AuthUtil.doGetJson(infoUrl);

        final String imgUrl = userInfo.getString("headimgurl");

        userLogin(openid,"","",request,response);

    }

    //openid登录
    public JsonResponseVO userLogin(String openid,@RequestParam("loginName") String loginName,
                                    @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String path = request.getContextPath();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("登录认证,loginName:{}", loginName);
        }
        //登录信息验证
        final Subject securitySubject = SecurityUtils.getSubject();
        final JsonResponseVO result = new JsonResponseVO(Boolean.FALSE);

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(openid, "");



            securitySubject.login(token);
            result.setSuccess(Boolean.TRUE);
            // rememberme
            token.setRememberMe(true);
            response.sendRedirect( path+"/home/alert");
        }   catch (UnknownAccountException ex) {

            result.setReason("账号不存在");
        } catch (IncorrectCredentialsException ex) {

            result.setReason("密码错误");
        } catch (DisabledAccountException ex) {
            result.setReason("openid不存在");
            request.getSession().setAttribute("openid",openid);
            response.sendRedirect( path+"/home/login");
        } catch (ExcessiveAttemptsException ex) {

            result.setReason("登录失败多次，账户锁定");
        } catch (AuthenticationException ex) {

            result.setReason("其他错误");
        } catch (Exception ex) {
            System.out.println("2");
        }

        return result;
    }

    /**
     * 账号密码登录
     * @param loginName
     * @param password
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/nameAndUser/login")
    @ResponseBody
    public JsonResponseVO nameAndUserLogin(@RequestParam("loginName") String loginName,
                                    @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String path = request.getContextPath();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("登录认证,loginName:{}", loginName);
        }


        //登录信息验证
        final Subject securitySubject = SecurityUtils.getSubject();
        final JsonResponseVO result = new JsonResponseVO(Boolean.FALSE);

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);

            securitySubject.login(token);
            result.setSuccess(Boolean.TRUE);
            // rememberme
            token.setRememberMe(true);
        }   catch (UnknownAccountException ex) {

            result.setReason("账号不存在");
        } catch (IncorrectCredentialsException ex) {
            result.setReason("密码错误");
        } catch (DisabledAccountException ex) {
            result.setReason("openid不存在");
        } catch (ExcessiveAttemptsException ex) {
            result.setReason("登录失败多次，账户锁定");
        } catch (AuthenticationException ex) {

            result.setReason("其他错误");
        } catch (Exception ex) {
            System.out.println("2");
        }

        return result;
    }
}
