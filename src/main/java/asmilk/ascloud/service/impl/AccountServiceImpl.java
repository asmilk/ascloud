package asmilk.ascloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;
import asmilk.ascloud.repository.jpa.AccountJpaRepository;
import asmilk.ascloud.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountJpaRepository accountJpaRepository;

	@Autowired
	private AccountCloudantRepository accountCloudantRepository;

	@Override
	public Account save(Account account) {
		return this.accountCloudantRepository.save(account);
	}

	@Override
	public List<Account> findAll() {
		return this.accountJpaRepository.findAll();
	}

	@Override
	public Account find(String id) {
		return this.accountCloudantRepository.find(id);
	}

	@Override
	public Account remove(Account account) {
		return this.accountCloudantRepository.remove(account);
	}

}
