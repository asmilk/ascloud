package asmilk.ascloud.data.cloudant.repository.support;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.api.query.QueryResult;

import asmilk.ascloud.data.cloudant.repository.CloudantRepository;

public class SimpleCloudantRepository<T extends Document> implements CloudantRepository<T> {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleCloudantRepository.class);

	private Database database;

	private Class<T> classT;

	public SimpleCloudantRepository(Database database, Class<T> classT) {
		super();
		this.database = database;
		this.classT = classT;
	}

	@Override
	public T save(T document) {
		String id = document.getId();
		this.handleResponse(
				(null != id && !id.trim().equals("")) ? this.database.update(document) : this.database.save(document),
				document);
		return document;
	}

	@Override
	public List<T> bulk(List<T> documents) {
		Iterator<Response> responses = this.database.bulk(documents).iterator();
		documents.forEach(document -> {
			if (responses.hasNext()) {
				this.handleResponse(responses.next(), document);
			}
		});
		return documents;
	}

	@Override
	public boolean contains(String id) {
		return this.database.contains(id);
	}

	@Override
	public T find(String id) {
		return this.database.find(classT, id);
	}

	@Override
	public T find(String id, String rev) {
		return this.database.find(classT, id, rev);
	}

	@Override
	public T find(String id, Params params) {
		return this.database.find(classT, id, params);
	}

	@Override
	public URI getDBUri() {
		return this.database.getDBUri();
	}

	@Override
	public T findAny(String uri) {
		return this.database.findAny(classT, uri);
	}

	@Override
	public QueryResult<T> query(String query) {
		return this.database.query(query, classT);
	}

	@Override
	public T remove(T document) {
		this.handleResponse(this.database.remove(document), document);
		return document;
	}

	private void handleResponse(Response response, T document) {
		HttpStatus statusCode = HttpStatus.resolve(response.getStatusCode());
		LOG.info("{}:{}-{}", statusCode, response.getReason(), response.getError());
		switch (statusCode) {
		case OK:
		case CREATED:
			document.setId(response.getId());
			document.setRevision(response.getRev());
			break;
		default:
			throw new HttpClientErrorException(statusCode, response.getError());
		}
	}

}
