package hdr.spring.test.service.impl;

import hdr.spring.test.dao.UserDao;
import hdr.spring.test.entity.UserEntity;
import hdr.spring.test.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Mock
    UserDao userDao;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void getUserInfoById() {
        // param
        Long id = 1L;

        // expect result
        UserEntity user = UserEntity.builder()
                .id(1L)
                .name("huangyicheng")
                .build();

        // stub
        when(userDao.selectById(id)).thenReturn(user);

        // execute
        UserEntity userRet = userService.getUserInfoById(id);

        // verify use AssertJ
        Assertions.assertThat(userRet)
                .isNotNull()
                .isEqualTo(user);
    }
}