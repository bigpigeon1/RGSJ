package itd.secondhandmall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import itd.secondhandmall.api.param.ItemUpdateParam;
import itd.secondhandmall.api.vo.ItemGroundingVO;
import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */

public interface ItemService {
    // 上架，下架，修改信息,查看，查找
    List<ItemInfoVO> getAllItemByAttributes(String attributes);

    List<ItemInfoVO> searchItems(String itemname,String attributes);

    void Grounding(ItemGroundingVO itemGroundingVO,long id);

    void Down(long tid);

    void update(ItemUpdateParam itemUpdateParam, long tid);


}
