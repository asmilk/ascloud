package asmilk.ascloud.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import asmilk.ascloud.data.cloudant.repository.support.SimpleCloudantRepository;
import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;

//@Profile("cloud")
@ComponentScan("asmilk.ascloud.repository.cloudant")
@EnableCaching
public class CloudantConfig {

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

}
