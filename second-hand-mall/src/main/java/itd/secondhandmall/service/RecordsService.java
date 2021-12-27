package itd.secondhandmall.service;

import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.api.vo.RecordsInfoVO;
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
public interface RecordsService {
    /**
     * 单个用户消费记录
     * @param id
     * @return
     */
    List<RecordsInfoVO> findAllRecords(long id);

    /**
     * 添加消费记录
     * @param id
     * @param tid
     * @return
     */
    void addRecord(long id, long tid);
}
