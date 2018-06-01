package asmilk.ascloud.repository.cloudant.impl;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.query.QueryResult;

import asmilk.ascloud.domain.Book;
import asmilk.ascloud.repository.cloudant.BookCloudantRepository;

//@Repository
public class BookCloudantRepositoryImpl implements BookCloudantRepository {

	private static final Logger LOG = LoggerFactory.getLogger(BookCloudantRepositoryImpl.class);

	@Override
	public Book save(Book document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> bulk(List<Book> documents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book find(String id, String rev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book find(String id, Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getDBUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findAny(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<Book> query(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book remove(Book document) {
		// TODO Auto-generated method stub
		return null;
	}

}
