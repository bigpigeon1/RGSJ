package itd.secondhandmall.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import itd.secondhandmall.pojo.Bask;
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
public interface BaskMapper extends BaseMapper<Bask> {
    public List<Bask> getAllBaskById(long id);

    public int updateBask(Bask bask);

    public int deleteBask(Bask bask);


}
