package itd.secondhandmall.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import itd.secondhandmall.api.param.UserLoginParam;
import itd.secondhandmall.api.param.UserRegisterParam;
import itd.secondhandmall.api.param.UserUpdateParam;
import itd.secondhandmall.api.vo.UserInfoVO;
import itd.secondhandmall.api.vo.UserLoginVO;
import itd.secondhandmall.config.annotation.TokenToUser;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.ImpI.UserServiceImpI;
import itd.secondhandmall.service.UserService;
import itd.secondhandmall.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/22 0022
 */
@RestController
@CrossOrigin
@RequestMapping("user")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Resource
    private UserService userServiceImpl;

    // 登录请求
    @PostMapping("/login")
    @ApiOperation(value = "登录接口", notes = "返回token")
    public Result userLogin(@Valid UserLoginParam user){

        // 实例化统一响应结果
        Result result = new Result<>();

        // 调用service层的登录方法
        UserLoginVO userLoginVO = userServiceImpl.login(user.getAccount(),user.getPassword());

        // 设置响应结果的result的值 （将数据返回用户对象）
        result.setData(userLoginVO);

        return result;
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "")
    public Result register(@Valid UserRegisterParam userRegisterParam) {

        Result result = new Result<>();

        userServiceImpl.register(userRegisterParam.getAccount(),userRegisterParam.getPassword(),userRegisterParam.getUsername(),userRegisterParam.getIdcard());

        result.setMsg("注册成功");

        return result;
    }

    // 修改用户信息
    @PutMapping("/info")
    @ApiOperation(value = "修改用户信息（不能改id）", notes = "需要token和修改表单")
    public Result updateInfo(@ApiParam("用户更新信息") @Valid UserUpdateParam userUpdateParam, @TokenToUser User user) {

        Result result = new Result();

        userServiceImpl.updateMsg(userUpdateParam,user.getId());

        return result;
    }

    // 获取用户信息
    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息", notes = "需要token")
    public Result getUserDetail(@TokenToUser User user) {
        //已登录则直接返回
        Result result = new Result();
        UserInfoVO userInfoVO = userServiceImpl.getUserInfo(user);
        result.setData(userInfoVO);
        return result;
    }

    // 用户退出
    @PostMapping("/logout")
    @ApiOperation(value = "登出接口", notes = "清除token")
    public Result<String> logout(@TokenToUser User user) {
        Result result = new Result();
        userServiceImpl.logout(user.getId());
        return result;
    }
}
