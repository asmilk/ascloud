package asmilk.ascloud.repository.cloudant.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

import asmilk.ascloud.domain.Book;
import asmilk.ascloud.repository.cloudant.BookCloudantRepository;

@Repository
public class BookCloudantRepositoryImpl implements BookCloudantRepository {

	private static final Logger LOG = LoggerFactory.getLogger(BookCloudantRepositoryImpl.class);

	@Autowired
	private Database database;

	@Override
	public Book save(Book document) {
		Response response = this.database.save(document);
		document.setId(response.getId());
		document.setRev(response.getRev());
		return document;
	}

	@Override
	public Book find(String id) {
		LOG.info("!!!BookCloudantRepositoryImpl.find(id)!!!");
		return this.database.find(Book.class, id);
	}

	@Override
	public Book find(String id, String rev) {
		LOG.info("!!!BookCloudantRepositoryImpl.find(id, rev)!!!");
		return this.database.find(Book.class, id, rev);
	}

	@Override
	public Book remove(Book document) {
		Response response = this.database.remove(document);
		document.setId(response.getId());
		document.setRev(response.getRev());
		return document;
	}

}
