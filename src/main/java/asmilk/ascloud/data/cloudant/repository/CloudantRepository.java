package asmilk.ascloud.data.cloudant.repository;

import java.net.URI;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.query.QueryResult;

@NoRepositoryBean
public interface CloudantRepository<T extends Document> {
	
	T save(T document);
	
	List<T> bulk(List<T> documents);
	
	boolean contains(String id);
	
	T find(String id);
	
	T find(String id, String rev);
	
	T find(String id, Params params);
	
	URI getDBUri();
	
	T findAny(String uri);
	
	QueryResult<T> query(String query);
	
	T remove(T document);

}
