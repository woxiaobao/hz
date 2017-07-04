package com.hz.lvbaolin.service;

import com.hz.lvbaolin.Dao.UserDao;
import com.hz.lvbaolin.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by master-lv on 2017/6/30.
 */

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 保存
     * @param user
     */
    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    //删除数据
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
    //查询数据
    @Transactional
    public Iterable<User> getAll() {
        return userDao.findAll();

    }

    //查询数据
    @Transactional
    public Iterable<User> getPageAll(Pageable pageable) {

        return userDao.findAll(pageable);

    }
}
