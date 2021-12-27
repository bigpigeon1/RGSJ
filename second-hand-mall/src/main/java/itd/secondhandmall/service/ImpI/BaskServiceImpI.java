package itd.secondhandmall.service.ImpI;

import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.dao.BaskMapper;
import itd.secondhandmall.dao.ItemMapper;
import itd.secondhandmall.dao.UserMapper;
import itd.secondhandmall.pojo.Bask;
import itd.secondhandmall.pojo.Item;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.BaskService;
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
public class BaskServiceImpI implements BaskService {
    @Resource
    BaskMapper baskMapper;

    @Resource
    ItemMapper itemMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public List<ItemInfoVO> getAllBaskById(long id) {
        List<Bask> basks = baskMapper.getAllBaskById(id);
        List<ItemInfoVO> itemInfoVOList = new ArrayList<>();
        for(Bask bask:basks){
            Item item = itemMapper.selectById(bask.getTid());
            AssertUtil.isTrue(item  == null,"该商品不存在");
            User user = userMapper.selectById(item.getId());
            AssertUtil.isTrue(user  == null,"该用户不存在");
            ItemInfoVO itemInfoVO = new ItemInfoVO();
            itemInfoVO.setUsername(user.getUsername());
            itemInfoVO.setItemname(item.getItemname());
            itemInfoVO.setStime(item.getStime());
            itemInfoVO.setPrice(item.getPrice());
            itemInfoVO.setBrief(item.getBrief());
            itemInfoVO.setAttributes(item.getAttributes());
            itemInfoVO.setImage(item.getImage());

            itemInfoVOList.add(itemInfoVO);
        }
        return itemInfoVOList;
    }

    @Override
    public List<Bask> getBaskById(long id) {
        List<Bask> basks = baskMapper.getAllBaskById(id);
        return basks;
    }

    @Override
    public void deleteOrSettleBaskList(List<Bask> basks) {
        for(Bask bask:basks){
            if(bask.getIsselect()==1)
                baskMapper.deleteBask(bask);
        }
    }

    @Override
    public void Select(long id,long tid) {
        Bask bask = new Bask();
        bask.setId(id);
        bask.setTid(tid);
        bask.setIsselect(1);
        baskMapper.updateBask(bask);
    }

    @Override
    public void addToBask(long id,long tid) {
        Bask bask = new Bask();
        bask.setId(id);
        bask.setTid(tid);
        bask.setIsselect(0);
        baskMapper.insert(bask);
    }
}
