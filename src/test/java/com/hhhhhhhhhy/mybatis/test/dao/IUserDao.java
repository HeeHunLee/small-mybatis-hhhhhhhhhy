package com.hhhhhhhhhy.mybatis.test.dao;

import com.hhhhhhhhhy.mybatis.test.po.User;

/**
 * @author hhhhhhhhhy
 * @Date 2023/3/6 21:00
 */
public interface IUserDao {

    User queryUserInfoById(Long uId);

}
