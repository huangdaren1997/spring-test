package hdr.spring.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("user")
public class UserEntity {

    public UserEntity(){}

    public UserEntity(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

}
