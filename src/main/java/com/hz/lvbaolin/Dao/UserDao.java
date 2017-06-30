package com.hz.lvbaolin.Dao;

import com.hz.lvbaolin.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by master-lv on 2017/6/30.
 */
public interface UserDao extends CrudRepository<User, Long> {
}
