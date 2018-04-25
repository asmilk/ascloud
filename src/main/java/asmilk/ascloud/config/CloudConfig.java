package asmilk.ascloud.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.PooledServiceConnectorConfig.PoolConfig;
import org.springframework.cloud.service.keyval.RedisConnectionFactoryConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@ServiceScan
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public DataSource dataSource() {
		PoolConfig poolConfig = new PoolConfig(5, 3000);
		DataSourceConfig dataSourceConfig = new DataSourceConfig(poolConfig, null);
		return this.connectionFactory().dataSource(dataSourceConfig);
	}

	@Bean
	public RedisConnectionFactory redisFactory() {
		PoolConfig poolConfig = new PoolConfig(30, 3000);
		RedisConnectionFactoryConfig redisConfig = new RedisConnectionFactoryConfig(poolConfig);
		return connectionFactory().redisConnectionFactory(redisConfig);
	}

}
