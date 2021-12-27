package itd.secondhandmall.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import itd.secondhandmall.pojo.Records;
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
public interface RecordsMapper extends BaseMapper<Records> {
    public int insertRecord(Records records);

    public List<Records> selectAllByUserId(long id);

}
