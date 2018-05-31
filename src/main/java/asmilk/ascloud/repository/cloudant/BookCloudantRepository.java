package asmilk.ascloud.repository.cloudant;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.domain.Book;

@Repository
@CacheConfig(cacheNames = "books")
public interface BookCloudantRepository {

	@CachePut(key = "#result.id")
	Book save(Book document);

	@Cacheable
	Book find(String id);

	@Cacheable
	Book find(String id, String rev);

	@CacheEvict(key = "#result.getId()")
	Book remove(Book document);

}
