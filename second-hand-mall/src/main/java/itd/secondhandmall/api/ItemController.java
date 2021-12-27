package itd.secondhandmall.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import itd.secondhandmall.api.param.ItemUpdateParam;
import itd.secondhandmall.api.param.UserRegisterParam;
import itd.secondhandmall.api.vo.ItemGroundingVO;
import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.config.annotation.TokenToUser;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.ImpI.ItemServiceImpI;
import itd.secondhandmall.service.ItemService;
import itd.secondhandmall.util.Result;
import itd.secondhandmall.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/24 0024
 */
@RestController
@CrossOrigin
@RequestMapping("item")
@Api(tags = "商品管理相关接口")
public class ItemController {
    @Resource
    private ItemService itemServiceImpI;

    @GetMapping("/showItem")
    @ApiOperation(value = "按类别展示商品", notes = "需要类别")
    public Result<List<ItemInfoVO>> showItemByAttributes(String attributes){
        List<ItemInfoVO> itemInfoVOList = itemServiceImpI.getAllItemByAttributes(attributes);

        return ResultGenerator.genSuccessResult(itemInfoVOList);
    }

    @PostMapping("/searchItem")
    @ApiOperation(value = "在指定类别搜索商品", notes = "需要类别和搜索内容")
    public Result<List<ItemInfoVO>> searchItemByName(String name,String attributes){
        List<ItemInfoVO> itemInfoVOList = itemServiceImpI.searchItems(name, attributes);

        return ResultGenerator.genSuccessResult(itemInfoVOList);
    }

    @PutMapping("/grounding")
    @ApiOperation(value = "商品上架", notes = "需要token和上架商品表单")
    public Result Grounding(@ApiParam("商品上架信息") @Valid ItemGroundingVO itemGroundingVO, @TokenToUser User user) {

        Result result = new Result<>();

        itemServiceImpI.Grounding(itemGroundingVO, user.getId());

        result.setMsg("上架成功");

        return result;
    }

    @PostMapping("/down")
    @ApiOperation(value = "商品下架", notes = "需要token和下架商品id")
    public Result downItem(long tid,@TokenToUser User user) {

        Result result = new Result<>();

        itemServiceImpI.Down(tid);

        result.setMsg("下架成功");

        return result;
    }

    @PostMapping("/updateItem")
    @ApiOperation(value = "商品信息更新", notes = "需要token、修改商品表单和商品id")
    public Result updateItem(long tid,@ApiParam("商品上架信息") @Valid ItemUpdateParam itemUpdateParam, @TokenToUser User user) {

        Result result = new Result<>();

        itemServiceImpI.update(itemUpdateParam,tid);

        return result;
    }


}
