package asmilk.ascloud.cloud.cloudfoundry;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import asmilk.ascloud.cloud.service.common.CloudantServiceInfo;

public class CloudantServiceInfoCreator extends CloudFoundryServiceInfoCreator<CloudantServiceInfo> {

	public CloudantServiceInfoCreator() {
		super(new Tags(CloudantServiceInfo.CLOUDANT_SCHEME));
	}

	@Override
	public CloudantServiceInfo createServiceInfo(Map<String, Object> serviceData) {
		String id = getId(serviceData);
		String uri = getUriFromCredentials(getCredentials(serviceData));
		return new CloudantServiceInfo(id, uri);
	}

}
