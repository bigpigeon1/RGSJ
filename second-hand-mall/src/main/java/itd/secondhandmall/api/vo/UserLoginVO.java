package itd.secondhandmall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/22 0022
 */
@Data
public class UserLoginVO {
    @ApiModelProperty("token")
    private String token;
}
