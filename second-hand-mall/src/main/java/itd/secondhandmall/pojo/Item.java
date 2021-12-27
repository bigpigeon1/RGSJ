package itd.secondhandmall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Item {
  @TableId(value = "tid",type = IdType.AUTO)
  private long tid;

  private long id;

  private String itemname;

  private String stime;

  private double price;

  private String brief;

  private String attributes;

  private String image;

  private long isbuy;

  private long isgrounding;

}
