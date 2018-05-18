package asmilk.ascloud.cloud.service.relational;

import org.springframework.cloud.service.relational.DataSourceCreator;

import asmilk.ascloud.cloud.service.common.DerbyServiceInfo;

public class DerbyDataSourceCreator extends DataSourceCreator<DerbyServiceInfo> {

	private static final String[] DRIVERS = new String[] { "org.apache.derby.jdbc.ClientDriver" };
	private static final String VALIDATION_QUERY = "VALUES 1";

	public DerbyDataSourceCreator() {
		super("spring-cloud.derby.driver", DRIVERS, VALIDATION_QUERY);
	}

}
