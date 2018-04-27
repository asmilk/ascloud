package asmilk.ascloud.cloud.service.document;

import java.net.MalformedURLException;
import java.net.URL;

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
		CloudantClient cloudantClient = null;
		String uri = serviceInfo.getUri();
		LOG.info("uri: {}", uri);
		try {
			URL url = new URL(uri);
			cloudantClient = ClientBuilder.url(url).build();
			String serverVersion = cloudantClient.serverVersion();
			LOG.info("serverVersion: {}", serverVersion);
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage(), e);
		}
		LOG.info("cloudantClient: {}", cloudantClient);
		return cloudantClient;
	}

}
