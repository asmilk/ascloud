package asmilk.ascloud.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import asmilk.ascloud.data.cloudant.repository.support.SimpleCloudantRepository;
import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;

@EnableCaching
@ComponentScan("asmilk.ascloud.repository.cloudant")
public class CloudantConfig {

	private static final Logger LOG = LoggerFactory.getLogger(CloudantConfig.class);

	@Bean
	public Database database(CloudantClient cloudantClient) {
		return cloudantClient.database("test", true);
	}

	@Bean
	public AccountCloudantRepository accountCloudantRepository(Database database) {
		final SimpleCloudantRepository<Account> simpleCloudantRepository = new SimpleCloudantRepository<Account>(
				database, Account.class);
		return (AccountCloudantRepository) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class<?>[] { AccountCloudantRepository.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return method.invoke(simpleCloudantRepository, args);
					}

				});
	}
	
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
