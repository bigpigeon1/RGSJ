package itd.secondhandmall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/24 0024
 */
@Data
public class UserLoginParam implements Serializable {
    @ApiModelProperty("登录名")
    @NotNull(message = "登录名不能为空")
    private String account;

    @ApiModelProperty("用户密码")
    @NotNull(message = "密码不能为空")
    private String password;
}
