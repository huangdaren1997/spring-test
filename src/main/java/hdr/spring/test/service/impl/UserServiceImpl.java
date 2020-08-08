package hdr.spring.test.service.impl;

import hdr.spring.test.dao.UserDao;
import hdr.spring.test.entity.UserEntity;
import hdr.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserInfoById(Long id) {
        return userDao.selectById(id);
    }
}
