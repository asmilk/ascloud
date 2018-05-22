package asmilk.ascloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.jpa.AccountJpaRepository;
import asmilk.ascloud.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountJpaRepository accountJpaRepository;

	@Override
	public Account save(Account account) {
		return this.accountJpaRepository.save(account);
	}

	@Override
	public List<Account> findAll() {
		return this.accountJpaRepository.findAll();
	}

}
