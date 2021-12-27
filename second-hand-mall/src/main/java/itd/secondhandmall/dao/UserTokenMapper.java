package itd.secondhandmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import itd.secondhandmall.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/13 0013
 */
@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
    UserToken selectByToken(String token);
}
