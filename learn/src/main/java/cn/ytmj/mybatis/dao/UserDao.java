package cn.ytmj.mybatis.dao;

import cn.ytmj.mybatis.domain.User;

import java.util.List;

/**
 * @author rui
 * @create 2019-09-03 19:39
 */
public interface UserDao {
    List<User> findAll();
}
