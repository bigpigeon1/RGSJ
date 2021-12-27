package itd.secondhandmall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/24 0024
 */
@Data
public class ItemGroundingVO {
    @ApiModelProperty("名称")
    private String itemname;

    @ApiModelProperty("上架时间")
    private String stime;

    @ApiModelProperty("价格")
    private double price;

    @ApiModelProperty("简介")
    private String brief;

    @ApiModelProperty("类别")
    private String attributes;

    @ApiModelProperty("图片链接")
    private String image;
}
