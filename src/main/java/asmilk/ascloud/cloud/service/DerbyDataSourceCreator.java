package asmilk.ascloud.cloud.service;

import org.springframework.cloud.service.relational.DataSourceCreator;

public class DerbyDataSourceCreator extends DataSourceCreator<DerbyServiceInfo> {
	
	private static final String[] DRIVERS = new String[]{"org.apache.derby.jdbc.ClientDriver"};
	private static final String VALIDATION_QUERY = "VALUES 1";

	public DerbyDataSourceCreator() {
		super("spring-cloud.derby.driver", DRIVERS, VALIDATION_QUERY);
	}

}
