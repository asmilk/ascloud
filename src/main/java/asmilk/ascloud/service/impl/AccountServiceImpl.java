package asmilk.ascloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.service.AccountService;
import asmilk.ascloud.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return this.accountRepository.save(account);
	}

}
