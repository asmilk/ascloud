package asmilk.ascloud.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;

@ServiceScan
public class CloudConfig extends AbstractCloudConfig {

	// @Bean
	// public DataSource dataSource() {
	// PoolConfig poolConfig = new PoolConfig(5, 3000);
	// DataSourceConfig dataSourceConfig = new DataSourceConfig(poolConfig, null);
	// return this.connectionFactory().dataSource("ElephantSQL-Tiny_Turtle",
	// dataSourceConfig);
	// }

	// @Bean
	// public RedisConnectionFactory redisConnectionFactory() {
	// PoolConfig poolConfig = new PoolConfig(30, 3000);
	// RedisConnectionFactoryConfig redisConfig = new
	// RedisConnectionFactoryConfig(poolConfig);
	// return connectionFactory().redisConnectionFactory("Redis_Cloud-Free",
	// redisConfig);
	// }

}
