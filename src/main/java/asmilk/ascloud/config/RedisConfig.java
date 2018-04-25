package asmilk.ascloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig {

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
}
