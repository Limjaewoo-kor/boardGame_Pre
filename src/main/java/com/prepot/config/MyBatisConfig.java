package com.prepot.config;


import com.prepot.util.RefreshableSqlSessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Lazy
@EnableTransactionManagement
@MapperScan(basePackages = "com.prepot.repository.mybatis")
public class MyBatisConfig {

    private final ApplicationContext context;

    private final DataSource dataSource;


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new RefreshableSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                context.getResources(
                        "classpath:/mappers/*.xml"
                ));

        sessionFactory.setTypeAliasesPackage( "com.prepot.domain" );

        ((RefreshableSqlSessionFactoryBean) sessionFactory).setInterval(1000);
        return sessionFactory.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionTemplate;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
