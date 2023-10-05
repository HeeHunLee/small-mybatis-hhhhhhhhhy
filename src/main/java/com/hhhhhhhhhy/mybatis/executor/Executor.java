package com.hhhhhhhhhy.mybatis.executor;

import com.hhhhhhhhhy.mybatis.mapping.BoundSql;
import com.hhhhhhhhhy.mybatis.mapping.MappedStatement;
import com.hhhhhhhhhy.mybatis.session.ResultHandler;
import com.hhhhhhhhhy.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * SQL 执行器
 * 定义事务相关处理方法，执行 SQL 查询的操作，后续功能继续迭代
 * @author hhhhhhhhhy
 * @Date 2023/3/19 16:40
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    /**
     * 执行底层 JDBC 封装好的接口
     */
    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler handler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}
