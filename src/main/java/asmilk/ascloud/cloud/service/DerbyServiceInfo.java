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
		return String.format("%s%s://%s%s/%s%s%s", JDBC_PREFIX, jdbcUrlDatabaseType, getHost(), formatPort(), getPath(),
				formatUserinfo(), formatQuery());
	}

	private String formatPort() {
		return -1 != getPort() ? String.format(":%d", getPort()) : "";
	}

	private String formatUserinfo() {
		String userinfo = null != getUserName() && !"".equals(getUserName()) ? String.format(";user=%s", getUserName())
				: "";
		userinfo += !"".equals(userinfo) && null != getPassword() && !"".equals(getPassword())
				? String.format(";password=%s", getPassword())
				: "";
		return userinfo;
	}

	private String formatQuery() {
		return null != getQuery() ? String.format(";%s", getQuery()) : "";
	}

}
