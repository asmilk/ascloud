package asmilk.ascloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
