package com.hhhhhhhhhy.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.hhhhhhhhhy.mybatis.io.Resources;
import com.hhhhhhhhhy.mybatis.session.SqlSession;
import com.hhhhhhhhhy.mybatis.session.SqlSessionFactory;
import com.hhhhhhhhhy.mybatis.session.SqlSessionFactoryBuilder;
import com.hhhhhhhhhy.mybatis.test.dao.IUserDao;
import com.hhhhhhhhhy.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hhhhhhhhhy
 * @Date 2023/3/6 20:59
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_sqlSessionFactory() throws Exception {
        // 1. 从 SqlSessionFactory 中获取 SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                // 将核心配置文件通过流方式进行加载，解析交付给 SqlSessionFactory
                .build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象(代理对象)
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(10001L);
        logger.info("测试结果 {}", JSON.toJSONString(user));
    }

}
