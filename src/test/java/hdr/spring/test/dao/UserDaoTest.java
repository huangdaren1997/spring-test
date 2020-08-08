package hdr.spring.test.dao;

import hdr.spring.test.entity.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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

}