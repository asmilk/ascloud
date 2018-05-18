package asmilk.ascloud.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "asmilk.ascloud.repository.jpa")
@EnableTransactionManagement(proxyTargetClass = false)
public class JpaConfig {

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactory.setPackagesToScan("asmilk.ascloud.domain");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "create");
		jpaProperties.put("hibernate.format_sql", true);
		jpaProperties.put("hibernate.generate_statistics", true);
		// jpaProperties.put("hibernate.cache.use_second_level_cache", true);
		// jpaProperties.put("hibernate.cache.use_query_cache", true);
		// jpaProperties.put("hibernate.cache.region.factory_class",
		// "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		entityManagerFactory.setJpaProperties(jpaProperties);
		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
