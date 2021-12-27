package itd.secondhandmall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/23 0023
 */
@Data
public class UserInfoVO {
    @ApiModelProperty("手机号")
    private String account;

    @ApiModelProperty("昵称")
    private String username;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private long age;

    @ApiModelProperty("身份证号")
    private String idcard;

    @ApiModelProperty("常用地址")
    private String address;

    @ApiModelProperty("头像链接")
    private String image;
}
