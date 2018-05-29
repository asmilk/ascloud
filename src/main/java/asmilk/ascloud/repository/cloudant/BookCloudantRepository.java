package asmilk.ascloud.repository.cloudant;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.domain.Book;

@Repository
@CacheConfig(cacheNames = "books")
public interface BookCloudantRepository {
	
	@CachePut
	Book save(Book document);
	
	@Cacheable
	Book find(String id);

}
