package com.hhhhhhhhhy.mybatis.build;

import com.hhhhhhhhhy.mybatis.session.Configuration;
import com.hhhhhhhhhy.mybatis.type.TypeAliasRegistry;

/**
 * @author hhhhhhhhhy
 * @Date 2023/3/13 13:27
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
