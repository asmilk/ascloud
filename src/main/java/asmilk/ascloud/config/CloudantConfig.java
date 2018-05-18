package asmilk.ascloud.config;

import org.springframework.context.annotation.Bean;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

//@Profile("cloud")
public class CloudantConfig {

	@Bean
	public Database database(CloudantClient cloudantClient) {
		return cloudantClient.database("test", true);
	}

}
