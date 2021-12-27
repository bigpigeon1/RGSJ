package itd.secondhandmall.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.api.vo.RecordsInfoVO;
import itd.secondhandmall.config.annotation.TokenToUser;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.RecordsService;
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
@RequestMapping("records")
@Api(tags = "消费记录管理相关接口")
public class RecordsController {
    @Resource
    private RecordsService recordsService;

    @GetMapping("/showRecords")
    @ApiOperation(value = "展示单个用户消费记录", notes = "需要token")
    public Result<List<RecordsInfoVO>> showRecords(@TokenToUser User user){
        List<RecordsInfoVO> recordsInfoVOList = recordsService.findAllRecords(user.getId());

        return ResultGenerator.genSuccessResult(recordsInfoVOList);
    }

    @PostMapping("/addRecord")
    @ApiOperation(value = "购买商品", notes = "需要token,商品id")
    public Result addRecord(long tid, @TokenToUser User user) {

        Result result = new Result<>();

        recordsService.addRecord(user.getId(),tid);

        return result;
    }


}
