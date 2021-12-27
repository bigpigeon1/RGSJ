package itd.secondhandmall.service;

import itd.secondhandmall.api.param.UserUpdateParam;
import itd.secondhandmall.api.vo.UserInfoVO;
import itd.secondhandmall.api.vo.UserLoginVO;
import itd.secondhandmall.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */

public interface UserService {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    UserLoginVO login(String account, String password);

    /**
     * 注册
     * @param account
     * @param password
     * @param username
     * @param idcard
     */
    void register(String account, String password,String username,String idcard);

    /**
     * 更改用户信息
     * @param userUpdateParam
     */
    void updateMsg(UserUpdateParam userUpdateParam, long id);

    /**
     * 登出
     * @param id
     */
    void logout(long id);


    /**
     * 获取用户基本信息
     * @param user
     * @return
     */
    UserInfoVO getUserInfo(User user);
}
