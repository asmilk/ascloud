package asmilk.ascloud.service;

import javax.transaction.Transactional;

import asmilk.ascloud.domain.Account;

@Transactional
public interface AccountService {

	Account save(Account account);

}
