package com.tukjax.cargo.boot.mybatis.plugin;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig{

    @Bean
    public ConfigurationCustomizer settings(){
        return (customizer)-> {
            customizer.addInterceptor(new InSearchConditionLimitationPlugin());
            customizer.addInterceptor(new PaginationInterceptor());
        };
    }

    @Primary
    @Bean
    public SqlSessionFactory sysSqlSessionFactory(DataSource dataSource)
            throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Interceptor[] plugins =  new Interceptor[]{new InSearchConditionLimitationPlugin()};
        bean.setPlugins(plugins);
        return bean.getObject();
    }

}
