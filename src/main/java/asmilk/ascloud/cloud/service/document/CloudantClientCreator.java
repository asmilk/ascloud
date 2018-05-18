package asmilk.ascloud.cloud.service.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;

import asmilk.ascloud.cloud.service.common.CloudantServiceInfo;

public class CloudantClientCreator extends AbstractServiceConnectorCreator<CloudantClient, CloudantServiceInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(CloudantClientCreator.class);

	@Override
	public CloudantClient create(CloudantServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
		CloudantClient cloudantClient = ClientBuilder.account(serviceInfo.getHost().replace(".cloudant.com", ""))
				.username(serviceInfo.getUserName()).password(serviceInfo.getPassword()).build();
		String serverVersion = cloudantClient.serverVersion();
		LOG.info("serverVersion: {}", serverVersion);
		return cloudantClient;
	}

}
