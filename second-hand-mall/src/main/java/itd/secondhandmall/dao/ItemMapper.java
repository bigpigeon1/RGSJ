package itd.secondhandmall.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import itd.secondhandmall.pojo.Item;

import itd.secondhandmall.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

    public List<Item> getAllItemsByAttributes(String attributes);

    public List<Item> selectItemByName(String itemname,String attributes);

    public int updateByPrimaryKeySelective(Item item);
}
