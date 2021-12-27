package itd.secondhandmall.service.ImpI;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import itd.secondhandmall.api.param.ItemUpdateParam;
import itd.secondhandmall.api.vo.ItemGroundingVO;
import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.dao.BaskMapper;
import itd.secondhandmall.dao.ItemMapper;
import itd.secondhandmall.dao.RecordsMapper;
import itd.secondhandmall.dao.UserMapper;
import itd.secondhandmall.pojo.Bask;
import itd.secondhandmall.pojo.Item;
import itd.secondhandmall.pojo.User;
import itd.secondhandmall.service.ItemService;
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
public class ItemServiceImpI implements ItemService{
    @Resource
    ItemMapper itemMapper;

    @Resource
    UserMapper userMapper;


    @Override
    public List<ItemInfoVO> getAllItemByAttributes(String attributes) {
        List<Item> Items = itemMapper.getAllItemsByAttributes(attributes);
        List<ItemInfoVO> itemInfoVOList = new ArrayList<>();
        for(Item item:Items){
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
    public List<ItemInfoVO> searchItems(String itemname, String attributes) {
        List<Item> Items = itemMapper.selectItemByName(itemname,attributes);
        List<ItemInfoVO> itemInfoVOList = new ArrayList<>();
        for(Item item:Items){
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
    public void Grounding(ItemGroundingVO itemGroundingVO, long id) {
        Item item = new Item();

        item.setId(id);
        item.setStime(itemGroundingVO.getStime());
        item.setPrice(itemGroundingVO.getPrice());
        item.setBrief(itemGroundingVO.getBrief());
        item.setAttributes(itemGroundingVO.getAttributes());
        item.setImage(itemGroundingVO.getImage());
        item.setItemname(itemGroundingVO.getItemname());
        item.setIsbuy(0);
        item.setIsgrounding(1);
        itemMapper.insert(item);

    }

    @Override
    public void Down(long tid) {
        Item item = itemMapper.selectById(tid);
        item.setIsgrounding(0);
        itemMapper.updateByPrimaryKeySelective(item);

    }


    @Override
    public void update(ItemUpdateParam itemUpdateParam, long tid) {
        Item item = new Item();
        item.setItemname(itemUpdateParam.getItemname());
        item.setPrice(itemUpdateParam.getPrice());
        item.setAttributes(itemUpdateParam.getAttributes());
        item.setBrief(itemUpdateParam.getBrief());
        item.setImage(itemUpdateParam.getImage());
        itemMapper.updateByPrimaryKeySelective(item);
    }

}
