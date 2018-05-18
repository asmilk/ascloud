package asmilk.ascloud.cloud.localconfig;

import org.springframework.cloud.localconfig.LocalConfigServiceInfoCreator;

import asmilk.ascloud.cloud.service.common.CloudantServiceInfo;

public class CloudantServiceInfoCreator extends LocalConfigServiceInfoCreator<CloudantServiceInfo> {

	public CloudantServiceInfoCreator() {
		super(CloudantServiceInfo.CLOUDANT_SCHEME);
	}

	@Override
	public CloudantServiceInfo createServiceInfo(String id, String uri) {
		return new CloudantServiceInfo(id, uri);
	}

}
