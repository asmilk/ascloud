package asmilk.ascloud.cloud.local;

import org.springframework.cloud.localconfig.LocalConfigServiceInfoCreator;

import asmilk.ascloud.cloud.service.DerbyServiceInfo;

public class DerbyServiceInfoCreator extends LocalConfigServiceInfoCreator<DerbyServiceInfo> {

	public DerbyServiceInfoCreator() {
		super(DerbyServiceInfo.DERBY_SCHEME);
	}

	@Override
	public DerbyServiceInfo createServiceInfo(String id, String uri) {
		return new DerbyServiceInfo(id, uri);
	}

}
