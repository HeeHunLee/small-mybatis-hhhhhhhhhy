package com.hhhhhhhhhy.mybatis.executor.statement;

import com.hhhhhhhhhy.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 语句处理器
 * 准备语句、传递参数、执行查询、update、批处理、获取参数处理器
 * @author hhhhhhhhhy
 * @Date 2023/3/19 19:49
 */
public interface StatementHandler {

    /**
     * 准备语句
     * @param connection
     * @return
     * @throws SQLException
     */
    Statement prepare(Connection connection) throws SQLException;

    /**
     * 设置参数
     * @throws SQLException
     * @param statement
     */
    void parameterize(Statement statement) throws SQLException;

    /**
     * 执行查询操作和封装结果
     * @param <E>
     * @param statement
     * @param handler
     * @return
     * @throws SQLException
     */
    <E> List<E> query(Statement statement, ResultHandler handler) throws SQLException;

}
