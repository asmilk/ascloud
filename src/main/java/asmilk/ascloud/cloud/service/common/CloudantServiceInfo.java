package asmilk.ascloud.cloud.service.common;

import org.springframework.cloud.service.ServiceInfo.ServiceLabel;
import org.springframework.cloud.service.UriBasedServiceInfo;

@ServiceLabel(CloudantServiceInfo.CLOUDANT_SCHEME)
public class CloudantServiceInfo extends UriBasedServiceInfo {

	public static final String CLOUDANT_SCHEME = "cloudant";

	public CloudantServiceInfo(String id, String uriString) {
		super(id, uriString);
	}

}
