package asmilk.ascloud.data.cloudant.repository;

import java.net.URI;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.query.QueryResult;

@NoRepositoryBean
public interface CloudantRepository<T extends Document> {

	@CachePut
	T save(T document);

	@CachePut
	List<T> bulk(List<T> documents);

	@Cacheable
	boolean contains(String id);

	@Cacheable
	T find(String id);

	@Cacheable
	T find(String id, String rev);

	@Cacheable
	T find(String id, Params params);

	@Cacheable
	URI getDBUri();

	@Cacheable
	T findAny(String uri);

	@Cacheable
	QueryResult<T> query(String query);

	@CacheEvict
	T remove(T document);

}
