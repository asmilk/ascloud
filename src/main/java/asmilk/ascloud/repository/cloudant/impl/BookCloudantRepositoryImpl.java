package asmilk.ascloud.repository.cloudant.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.domain.Book;
import asmilk.ascloud.repository.cloudant.BookCloudantRepository;

@Repository
public class BookCloudantRepositoryImpl implements BookCloudantRepository {

	private static final Logger LOG = LoggerFactory.getLogger(BookCloudantRepositoryImpl.class);

	private Book instance;

	@Override
	public Book save(Book document) {
		LOG.info("book:{}", document);
		document.setId(UUID.randomUUID().toString());
		document.setRev("1");
		this.instance = document;
		return this.instance;
	}

	@Override
	public Book find(String id) {
		LOG.info("!!!BookCloudantRepositoryImpl.find()!!!");
		return this.instance;
	}

}
