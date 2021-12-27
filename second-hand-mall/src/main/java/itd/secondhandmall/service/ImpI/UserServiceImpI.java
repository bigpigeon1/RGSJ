package itd.secondhandmall.service.ImpI;

import itd.secondhandmall.api.param.UserUpdateParam;
import itd.secondhandmall.api.vo.UserInfoVO;
import itd.secondhandmall.api.vo.UserLoginVO;
import itd.secondhandmall.dao.UserMapper;
import itd.secondhandmall.dao.UserTokenMapper;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.pojo.UserToken;
import itd.secondhandmall.service.UserService;
import itd.secondhandmall.util.AssertUtil;
import itd.secondhandmall.util.MD5Util;
import itd.secondhandmall.util.NumberUtil;
import itd.secondhandmall.util.SystemUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */
@Service
public class UserServiceImpI implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    UserTokenMapper userTokenMapper;

    @Override
    public UserLoginVO login(String account, String password) {
        /* 1. 调用数据访问层，通过用户名查询用户记录，返回用户对象 */
        User user = userMapper.selectUserByAccount(account);

        /* 2. 判断该账户是否不存在 */
        AssertUtil.isTrue(user == null,"该账户不存在");

        /* 3. 判断密码是否正确 */
        password = MD5Util.MD5Encode(password, "UTF-8");                  // 密码加密
        AssertUtil.isTrue(!password.equals(user.getPassword()),"用户密码不正确");

        /* 4. 返回构建用户对象 */
        UserLoginVO userLoginVO = new UserLoginVO();
        // 获取token
        String token = getToken(user);
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);
        /* 3. 查看是否有该用户的userToken，有则更新信息，无则新建信息*/
        UserToken userToken = userTokenMapper.selectById(user.getId());
        if(userToken==null){
            userToken = new UserToken();
            userToken.setId(user.getId());
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            userTokenMapper.insert(userToken);
        }else{
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            userTokenMapper.updateById(userToken);
        }
        userLoginVO.setToken(token);
        return userLoginVO;
    }

    private String getToken(User user) {
        String src = (System.currentTimeMillis()+"")  + user.getId() + NumberUtil.genRandomNum(6);
        return SystemUtil.genToken(src);
    }

    @Override
    public void register(String account, String password, String username, String idcard) {
        AssertUtil.isTrue(userMapper.selectUserByAccount(account) != null,"该用户名已存在！");
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.MD5Encode(password,"UTF-8"));
        user.setAccount(account);
        user.setIdcard(idcard);
        user.setImage("");
        user.setEmail("无");
        user.setAddress("无");
        user.setSex("男");
        user.setAge(0);
        userMapper.insert(user);
    }

    @Override
    public void updateMsg(UserUpdateParam userUpdateParam, long id) {
        User user = userMapper.selectById(id);
        user.setAccount(userUpdateParam.getAccount());
        user.setUsername(userUpdateParam.getUsername());
        user.setSex(userUpdateParam.getSex());
        user.setAge(userUpdateParam.getAge());
        user.setAddress(userUpdateParam.getAddress());
        user.setImage(userUpdateParam.getImage());

        // 需要修改密码
        if (userUpdateParam.getPassword() != null){
            String password = MD5Util.MD5Encode(userUpdateParam.getPassword(),"UTF-8");
            user.setPassword(password);
        }
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) != 1 ,"更改失败");
    }

    @Override
    public void logout(long id) {
        userTokenMapper.deleteById(id);
    }

    @Override
    public UserInfoVO getUserInfo(User user) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setAccount(user.getAccount());
        userInfoVO.setUsername(user.getUsername());
        userInfoVO.setSex(user.getSex());
        userInfoVO.setAge(user.getAge());
        userInfoVO.setIdcard(user.getIdcard());
        userInfoVO.setAddress(user.getAddress());
        userInfoVO.setImage(user.getImage());
        return userInfoVO;
    }
}
