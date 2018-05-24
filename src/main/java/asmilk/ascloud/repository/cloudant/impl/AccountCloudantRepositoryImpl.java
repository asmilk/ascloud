package asmilk.ascloud.repository.cloudant.impl;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.api.query.QueryResult;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;

//@Repository
//@CacheConfig(cacheNames = "accounts")
public class AccountCloudantRepositoryImpl implements AccountCloudantRepository {

	private static final Logger LOG = LoggerFactory.getLogger(AccountCloudantRepositoryImpl.class);

	@Autowired
	private Database database;

	@Override
	// @CachePut(cacheNames = "accounts", key = "#document.id", condition =
	// "#document != null")
	public Account save(Account document) {
		return this.handleResponse(null != document && null != document.getId() && !document.getId().trim().equals("")
				? this.database.update(document)
				: this.database.save(document), document);
	}

	@Override
	public List<Account> bulk(List<Account> documents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	// @Cacheable(cacheNames = "accounts", key = "#id")
	public Account find(String id) {
		LOG.info("!!!AccountCloudantRepositoryImpl.find(String id)!!!");
		return this.database.find(Account.class, id);
	}

	@Override
	public Account find(String id, String rev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account find(String id, Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getDBUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAny(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<Account> query(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// @CacheEvict
	public Account remove(Account document) {
		// TODO Auto-generated method stub
		return null;
	}

	private Account handleResponse(Response response, Account document) {
		HttpStatus statusCode = HttpStatus.resolve(response.getStatusCode());
		LOG.info("{}:{}-{}", statusCode, response.getReason(), response.getError());
		switch (statusCode) {
		case OK:
		case CREATED:
			document.setId(response.getId());
			document.setRevision(response.getRev());
			break;
		default:
			Series series = statusCode.series();
			switch (series) {
			case CLIENT_ERROR:
				throw new HttpClientErrorException(statusCode, response.getError());
			case SERVER_ERROR:
				throw new HttpServerErrorException(statusCode, response.getError());
			default:
			}
		}
		return document;
	}

}
