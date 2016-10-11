package cloud.simple.service.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
//mybaits dao 搜索路径
//@MapperScan("cloud.simple.service.dao")
public class MybatisDataSource {
	@Autowired
	private DataSourceProperties dataSourceProperties;
	//mybaits mapper xml搜索路径
	private final static String mapperLocations="classpath:cloud/simple/service/dao/*.xml"; 

	private org.apache.tomcat.jdbc.pool.DataSource pool;

	@RefreshScope
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {		
		DataSourceProperties config = dataSourceProperties;		
		this.pool = new org.apache.tomcat.jdbc.pool.DataSource();		
		this.pool.setDriverClassName(config.getDriverClassName());
		this.pool.setUrl(config.getUrl());
		if (config.getUsername() != null) {
			this.pool.setUsername(config.getUsername());
		}
		if (config.getPassword() != null) {
			this.pool.setPassword(config.getPassword());
		}
		this.pool.setInitialSize(config.getInitialSize());
		this.pool.setMaxActive(config.getMaxActive());
		this.pool.setMaxIdle(config.getMaxIdle());
		this.pool.setMinIdle(config.getMinIdle());
		this.pool.setTestOnBorrow(config.isTestOnBorrow());
		this.pool.setTestOnReturn(config.isTestOnReturn());
		this.pool.setValidationQuery(config.getValidationQuery());
		return this.pool;
	}

	@PreDestroy
	public void close() {
		if (this.pool != null) {
			this.pool.close();
		}
	}
//
//	@Bean
//	@RefreshScope
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
//		 return sqlSessionFactoryBean.getObject();
//	}
	
//	@Bean
//	@RefreshScope
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
}
