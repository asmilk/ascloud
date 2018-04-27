package asmilk.ascloud.cloud.service.common;

import org.springframework.cloud.service.UriBasedServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("cloudant")
public class CloudantServiceInfo extends UriBasedServiceInfo {
	
	public static final String CLOUDANT_SCHEME = "cloudant";
	
	public CloudantServiceInfo(String id, String host, int port, String username, String password) {
		super(id, CLOUDANT_SCHEME, host, port, username, password, null);
	}
	
	public CloudantServiceInfo(String id, String uriString) {
		super(id, uriString);
	}

}
