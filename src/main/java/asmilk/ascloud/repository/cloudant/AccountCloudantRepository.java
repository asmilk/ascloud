package asmilk.ascloud.repository.cloudant;

import org.springframework.stereotype.Repository;

import asmilk.ascloud.data.cloudant.repository.CloudantRepository;
import asmilk.ascloud.domain.Account;

@Repository
public interface AccountCloudantRepository extends CloudantRepository<Account> {

}
