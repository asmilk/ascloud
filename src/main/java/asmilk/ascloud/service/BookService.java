package asmilk.ascloud.service;

import javax.transaction.Transactional;

import asmilk.ascloud.domain.Book;

@Transactional
public interface BookService {

	Book save(Book document);

	Book find(String id);
	
	Book find(String id, String rev);
	
	Book remove(Book document);

}
