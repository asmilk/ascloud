package asmilk.ascloud.service;

import java.util.List;

import javax.transaction.Transactional;

import asmilk.ascloud.domain.Account;

@Transactional
public interface AccountService {

	Account save(Account account);

	List<Account> findAll();

}
