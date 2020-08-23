package hdr.spring.test;

import hdr.spring.test.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MockDemoApplicationTests {

    @Autowired
    private UserDao dao;

    @Autowired
    private ApplicationContext ctx;

    @Test
    void contextLoads() {
        System.out.println(dao.selectList(null));
    }

    @Test
    void ctxTest(){
        ApplicationContext parent = ctx.getParent();
    }
}
