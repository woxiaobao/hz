package com.hz.lvbaolin.Dao;

import com.hz.lvbaolin.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by master-lv on 2017/6/30.
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {
}
