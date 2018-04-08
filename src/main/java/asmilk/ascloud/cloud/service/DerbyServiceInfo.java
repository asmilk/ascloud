package asmilk.ascloud.cloud.service;

import org.springframework.cloud.service.ServiceInfo.ServiceLabel;
import org.springframework.cloud.service.common.RelationalServiceInfo;

@ServiceLabel("derby")
public class DerbyServiceInfo extends RelationalServiceInfo {
	
	public static final String DERBY_SCHEME = "derby";
	
	public DerbyServiceInfo(String id, String uriString) {
		this(id, uriString, null);
	}

	public DerbyServiceInfo(String id, String uriString, String jdbcUrl) {
		super(id, uriString, jdbcUrl, DERBY_SCHEME);
	}

	@Override
	protected String buildJdbcUrl() {
		return String.format("%s%s://%s%s/%s%s%s", JDBC_PREFIX, jdbcUrlDatabaseType, getHost(), formatPort(),
				getPath(), formatUserinfo(), formatQuery());
	}
	
	private String formatPort() {
		if (getPort() != -1) {
			return String.format(":%d", getPort());
		}
		return "";
	}
	
	private String formatUserinfo() {
		if (getUserName() != null && getPassword() != null) {
			return String.format(";user=%s;password=%s", getUserName(), getPassword());
		}
		if (getUserName() != null) {
			return String.format(";user=%s", getUserName());
		}
		return "";
	}
	
	private String formatQuery() {
		if (getQuery() != null) {
			return String.format(";%s", getQuery());
		}
		return "";
	}

}

