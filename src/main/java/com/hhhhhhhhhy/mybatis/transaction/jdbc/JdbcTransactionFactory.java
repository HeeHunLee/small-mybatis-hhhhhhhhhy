package com.hhhhhhhhhy.mybatis.transaction.jdbc;

import com.hhhhhhhhhy.mybatis.session.TransactionIsolationLevel;
import com.hhhhhhhhhy.mybatis.transaction.Transaction;
import com.hhhhhhhhhy.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author hhhhhhhhhy
 * @Date 2023/3/14 12:47
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
