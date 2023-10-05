package com.hhhhhhhhhy.mybatis.session.defaults;

import com.hhhhhhhhhy.mybatis.executor.Executor;
import com.hhhhhhhhhy.mybatis.mapping.Environment;
import com.hhhhhhhhhy.mybatis.session.Configuration;
import com.hhhhhhhhhy.mybatis.session.SqlSession;
import com.hhhhhhhhhy.mybatis.session.SqlSessionFactory;
import com.hhhhhhhhhy.mybatis.session.TransactionIsolationLevel;
import com.hhhhhhhhhy.mybatis.transaction.Transaction;
import com.hhhhhhhhhy.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * DefaultSqlSession 的配置工厂，MyBatis 中的核心类
 * @author hhhhhhhhhy
 * @Date 2023/3/12 19:56
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();

            // 获取 configuration 中 environment 里的数据源对象，并设置事务隔离级别
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(),
                    TransactionIsolationLevel.READ_COMMITTED, false);

            // 创建执行器，具体的 crud 操作委派给底层的执行器来执行
            Executor executor = configuration.newExecutor(tx);

            // 创建 DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}
