package cn.yantumeijing.dao;

import cn.yantumeijing.mybatis.annotations.Select;
import cn.yantumeijing.domain.User;

import java.util.List;

/**
 * @author rui
 * @create 2019-09-02 20:44
 */
public interface UserDao {
    /**
     *查询所有
     * @return
     */
    List<User> findAll();
 }
