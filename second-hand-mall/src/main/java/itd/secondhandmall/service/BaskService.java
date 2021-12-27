package itd.secondhandmall.service;

import itd.secondhandmall.api.vo.ItemInfoVO;
import itd.secondhandmall.pojo.Bask;

import java.util.List;

/**
 * Descripton:
 * Param:
 * return:
 * Author:吴国旭
 * Data:2021/12/12 0012
 */
public interface BaskService {

    /**
     * 购物车内容
     * @param id
     * @return
     */

    List<ItemInfoVO> getAllBaskById(long id);

    /**
     * 购物车列表
     * @param id
     * @return
     */
    List<Bask> getBaskById(long id);

    /**
     * 删除或结算已选中的商品
     * @param basks
     * @return
     */
    void deleteOrSettleBaskList(List<Bask> basks);


    /**
     * 选择商品
     * @param id
     * @param tid
     * @return
     */
    void Select(long id,long tid);

    /**
     * 加入购物车
     * @param id
     * @param tid
     * @return
     */
    void addToBask(long id,long tid);
}
