package hdr.spring.test.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hdr.spring.test.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        System.out.println("start testing...........");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test end...........");
    }

    @Test
    void testList(){
        List<UserEntity> userList = userDao.selectList(null);
    }

    @Test
    @Transactional
    @Rollback
    void testSelectById(){
        UserEntity user = UserEntity.builder()
                .name("huangyicheng")
                .age(23)
                .email("huang_yicheng@foxmail.com")
                .build();
        int i = userDao.insert(user);
        assertEquals(1,i);

        UserEntity dbUser = userDao.selectById(user.getId());
        assertEquals(user,dbUser);
    }

    /** 学学AssertJ怎么玩 */

    /** 简单分页查询 */
    @Test
    void testSelectPage(){
        Page<UserEntity> pageParam = new Page<>();
        pageParam.setCurrent(1);
        pageParam.setSize(1);
        IPage<UserEntity> pageResult = userDao.selectPage(pageParam, null);

        System.out.println(pageResult.getRecords());
        Assertions.assertThat(pageResult.getRecords()).isNotNull();

        Page<UserEntity> pageParam2 = new Page<>();
        pageParam2.setCurrent(2);
        pageParam2.setSize(1);
        IPage<UserEntity> pageResult2 = userDao.selectPage(pageParam2, null);

        System.out.println(pageResult2.getRecords());
        Assertions.assertThat(pageResult2.getRecords()).isNotNull().isNotEqualTo(pageResult.getRecords());

        Assertions.assertThat(pageParam2).isEqualTo(pageResult2);
    }


    @Test
    @Transactional
    @Rollback
    void testDeleteByWrapper(){
        // 删除用户名叫Jack的记录
        UserEntity user = new UserEntity();
        UpdateWrapper<UserEntity> param = new UpdateWrapper<>(user);
        param.eq("name","Jack");
        int i = userDao.delete(param);
        Assertions.assertThat(i).isGreaterThan(0);
    }

    @Test
    void testQueryByWrapper(){
        UserEntity user = new UserEntity();
        QueryWrapper<UserEntity> query = new QueryWrapper<>(user);
        query.select("name", "age").eq("name","Jack");
        userDao.selectList(query).forEach(System.out::println);
    }


}