package asmilk.ascloud.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;
import asmilk.ascloud.repository.jpa.AccountJpaRepository;
import asmilk.ascloud.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountJpaRepository accountJpaRepository;

	@Autowired
	private AccountCloudantRepository accountCloudantRepository;

	@Override
	public Account save(Account account) {
		LOG.info("account1: {}", account);
		account = this.accountCloudantRepository.save(account);
		LOG.info("account2: {}", account);
		account = this.accountJpaRepository.save(account);
		LOG.info("account3: {}", account);
		return account;
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
