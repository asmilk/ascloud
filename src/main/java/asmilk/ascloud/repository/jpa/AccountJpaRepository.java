package asmilk.ascloud.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asmilk.ascloud.domain.Account;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

}
