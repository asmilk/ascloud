package asmilk.ascloud.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

public class CacheConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);
	
	@Bean
	@Profile("default")
	public ConcurrentMapCacheFactoryBean booksCacheFactoryBean() {
		ConcurrentMapCacheFactoryBean booksCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		booksCacheFactoryBean.setName("books");
		return booksCacheFactoryBean;
	}

	@Bean
	@Profile("default")
	public ConcurrentMapCacheFactoryBean accountsCacheFactoryBean() {
		ConcurrentMapCacheFactoryBean accountsCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		accountsCacheFactoryBean.setName("accounts");
		return accountsCacheFactoryBean;
	}

	@Bean
	@Profile("default")
	public CacheManager cacheManager(Cache... caches) {
		for (Cache cache : caches) {
			LOG.info("cache.name:{}", cache.getName());
		}
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(caches));
		return cacheManager;
	}

	@Bean
	@Profile("cloud")
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		return RedisCacheManager.create(connectionFactory);
	}

}
