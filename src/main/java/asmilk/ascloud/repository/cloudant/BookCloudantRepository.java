package asmilk.ascloud.repository.cloudant;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.data.cloudant.repository.CloudantRepository;
import asmilk.ascloud.domain.Book;

@Repository
@CacheConfig(cacheNames = "books")
public interface BookCloudantRepository extends CloudantRepository<Book> {

}
