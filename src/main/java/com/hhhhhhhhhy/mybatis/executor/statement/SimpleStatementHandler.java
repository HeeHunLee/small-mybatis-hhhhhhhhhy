package com.hhhhhhhhhy.mybatis.executor.statement;

import com.hhhhhhhhhy.mybatis.executor.Executor;
import com.hhhhhhhhhy.mybatis.mapping.BoundSql;
import com.hhhhhhhhhy.mybatis.mapping.MappedStatement;
import com.hhhhhhhhhy.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 简单语句处理器（STATEMENT）
 * 只执行最简单的 SQL，不设置参数
 * @author hhhhhhhhhy
 * @Date 2023/3/21 15:29
 */
public class SimpleStatementHandler extends BaseStatementHandler{

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {

    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler handler) throws SQLException {
        return null;
    }
}
