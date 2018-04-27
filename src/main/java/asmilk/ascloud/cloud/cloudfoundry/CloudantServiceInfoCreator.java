package asmilk.ascloud.cloud.cloudfoundry;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import asmilk.ascloud.cloud.service.common.CloudantServiceInfo;

public class CloudantServiceInfoCreator extends CloudFoundryServiceInfoCreator<CloudantServiceInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(CloudantServiceInfoCreator.class);

	public CloudantServiceInfoCreator() {
		super(new Tags("cloudant"), CloudantServiceInfo.CLOUDANT_SCHEME);
	}

	@Override
	public CloudantServiceInfo createServiceInfo(Map<String, Object> serviceData) {
		String id = getId(serviceData);
		String uri = getUriFromCredentials(getCredentials(serviceData));
		LOG.info("id:{}", id);
		LOG.info("uri:{}", uri);
		return new CloudantServiceInfo(id, uri);
	}

}
