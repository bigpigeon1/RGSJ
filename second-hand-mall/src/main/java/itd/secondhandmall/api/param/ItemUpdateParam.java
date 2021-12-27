package itd.secondhandmall.api.param;

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
public class ItemUpdateParam {
    @ApiModelProperty("名称")
    private String itemname;

    @ApiModelProperty("价格")
    private double price;

    @ApiModelProperty("简介")
    private String brief;

    @ApiModelProperty("类别")
    private String attributes;

    @ApiModelProperty("图片链接")
    private String image;
}
