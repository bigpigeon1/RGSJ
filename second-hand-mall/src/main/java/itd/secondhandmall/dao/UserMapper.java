package itd.secondhandmall.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import itd.secondhandmall.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User selectUserByUserName(String username);

    public User selectUserByAccount(String Account);

    public int updateByPrimaryKeySelective(User user);
}
