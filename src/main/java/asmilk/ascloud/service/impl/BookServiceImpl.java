package asmilk.ascloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asmilk.ascloud.domain.Book;
import asmilk.ascloud.repository.cloudant.BookCloudantRepository;
import asmilk.ascloud.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookCloudantRepository bookCloudantRepository;

	@Override
	public Book save(Book document) {
		return this.bookCloudantRepository.save(document);
	}

	@Override
	public Book find(String id) {
		return this.bookCloudantRepository.find(id);
	}

	@Override
	public Book find(String id, String rev) {
		return this.bookCloudantRepository.find(id, rev);
	}

	@Override
	public Book remove(Book document) {
		return this.bookCloudantRepository.remove(document);
	}

}
