package asmilk.ascloud.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;

@ServiceScan
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public DataSource dataSource() {
		return this.connectionFactory().dataSource();
	}

}
