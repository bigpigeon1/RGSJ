package itd.secondhandmall.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserToken {

  @TableId(value = "id")
  private long id;

  private String token;

  private Date updateTime;

  private Date expireTime;



}
