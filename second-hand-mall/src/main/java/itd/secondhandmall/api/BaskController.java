package itd.secondhandmall.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.api.vo.RecordsInfoVO;
import itd.secondhandmall.config.annotation.TokenToUser;
import itd.secondhandmall.pojo.Bask;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.BaskService;
import itd.secondhandmall.service.RecordsService;
import itd.secondhandmall.util.Result;
import itd.secondhandmall.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("bask")
@Api(tags = "购物车管理相关接口")
public class BaskController {
    @Resource
    private BaskService baskService;

    @Resource
    private RecordsService recordsService;

    @GetMapping("/showBask")
    @ApiOperation(value = "展示单个用户消费记录", notes = "需要token")
    public Result<List<ItemInfoVO>> showBask(@TokenToUser User user){
        List<ItemInfoVO> itemInfoVOList = baskService.getAllBaskById(user.getId());

        return ResultGenerator.genSuccessResult(itemInfoVOList);
    }

    @PostMapping("/addToBask")
    @ApiOperation(value = "商品加入购物车", notes = "需要token和商品id")
    public Result addToBask(long tid, @TokenToUser User user) {

        Result result = new Result<>();

        baskService.addToBask(user.getId(),tid);

        return result;
    }

    @PostMapping("/selectBask")
    @ApiOperation(value = "选择购物车中的商品", notes = "需要token和商品id")
    public Result selectBask(long tid,@TokenToUser User user) {
        Result result = new Result<>();

        baskService.Select(user.getId(),tid);

        return result;
    }

    @PostMapping("/settleBaskList")
    @ApiOperation(value = "结算购物车中已选择的商品", notes = "需要token")
    public Result settleBaskList(@TokenToUser User user) {

        Result result = new Result<>();
        List<Bask> basks = baskService.getBaskById(user.getId());
        for(Bask bask:basks){
            recordsService.addRecord(bask.getId(),bask.getTid());
        }
        baskService.deleteOrSettleBaskList(basks);
        return result;
    }

    @PostMapping("/deleteBaskList")
    @ApiOperation(value = "删除购物车中已选择的商品", notes = "需要token")
    public Result deleteBaskList(@TokenToUser User user) {

        Result result = new Result<>();

        List<Bask> basks = baskService.getBaskById(user.getId());

        baskService.deleteOrSettleBaskList(basks);

        return result;
    }
}
