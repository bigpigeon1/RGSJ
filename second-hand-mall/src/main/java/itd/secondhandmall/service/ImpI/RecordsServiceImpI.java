package itd.secondhandmall.service.ImpI;

import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.api.vo.RecordsInfoVO;
import itd.secondhandmall.dao.ItemMapper;
import itd.secondhandmall.dao.RecordsMapper;
import itd.secondhandmall.dao.UserMapper;
import itd.secondhandmall.pojo.Item;
import itd.secondhandmall.pojo.Records;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.RecordsService;
import itd.secondhandmall.util.AssertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */
@Service
public class RecordsServiceImpI implements RecordsService {
    @Resource
    RecordsMapper recordsMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    ItemMapper itemMapper;

    @Override
    public List<RecordsInfoVO> findAllRecords(long id) {
        /* 1. 调用数据访问层，通过用户名查询用户记录，返回用户对象 */
        User user = userMapper.selectById(id);
        /* 2. 判断该账户是否不存在 */
        AssertUtil.isTrue(user == null,"该账户不存在");

        List<RecordsInfoVO> recordsInfoVOS = new ArrayList<>();;
        List<Records> records = recordsMapper.selectAllByUserId(id);
        for(Records records1:records){
            Item item = itemMapper.selectById(records1.getTid());
            AssertUtil.isTrue(user == null,"该商品不存在");
            User user1 = userMapper.selectById(item.getId());
            AssertUtil.isTrue(user == null,"该商家不存在");
            RecordsInfoVO recordsInfoVO = new RecordsInfoVO();
            recordsInfoVO.setUsername(user1.getUsername());
            recordsInfoVO.setItemname(item.getItemname());
            recordsInfoVO.setStime(item.getStime());
            recordsInfoVO.setPrice(item.getPrice());
            recordsInfoVO.setAttributes(item.getItemname());
            recordsInfoVOS.add(recordsInfoVO);
        }
        return  recordsInfoVOS;
    }

    @Override
    public void addRecord(long id, long tid) {
        Item item = itemMapper.selectById(tid);
        item.setIsbuy(1);
        itemMapper.updateByPrimaryKeySelective(item);
        Records records = new Records();
        records.setId(id);
        records.setTid(tid);
        records.setStime(item.getStime());
        records.setPrice(item.getPrice());
        records.setAttributes(item.getAttributes());
        recordsMapper.insertRecord(records);
    }
}
