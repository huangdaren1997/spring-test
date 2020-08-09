package hdr.spring.test;

import hdr.spring.test.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockDemoApplicationTests {

    @Autowired
    private UserDao dao;

    @Test
    void contextLoads() {
        System.out.println(dao.selectList(null));
    }


}
