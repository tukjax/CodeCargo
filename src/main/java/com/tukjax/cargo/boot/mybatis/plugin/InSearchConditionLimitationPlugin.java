package com.tukjax.cargo.boot.mybatis.plugin;


import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLInListExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class InSearchConditionLimitationPlugin implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(InSearchConditionLimitationPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler handler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = handler.getBoundSql();
        String sql = boundSql.getSql();
        //powered by alibaba druid. Thanks this, we can easily resolve sql~
        MySqlStatementParser mySqlStatementParser = new MySqlStatementParser(sql);
        SQLStatement statement = mySqlStatementParser.parseStatement();

        if (statement instanceof SQLSelectStatement) {
            SQLSelect selectQuery = ((SQLSelectStatement) statement).getSelect();
            MySqlSelectQueryBlock sqlSelectQuery = (MySqlSelectQueryBlock) selectQuery.getQuery();
            SQLExpr whereExp = sqlSelectQuery.getWhere();
            if(whereExp instanceof SQLInListExpr){
                if(((SQLInListExpr) whereExp).getTargetList().size() > 1000){
                    //here we limited
                    throw new IllegalStateException("done");
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
    }
}