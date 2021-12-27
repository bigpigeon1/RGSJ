package itd.secondhandmall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ApiModel(description = "用户字段")
public class User {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;

  private String account;

  private String password;

  private String username;

  private String sex;

  private long age;

  private String email;

  private String idcard;

  private String address;

  private String image;


}
