package asmilk.ascloud.web.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.service.AccountService;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	AccountService accountService;

	@GetMapping({ "/", "/index" })
	public String index() {
		LOG.info("===start===");
		LOG.info("accountService: {}", this.accountService);
		Account account = new Account();
		account.setName("abc");
		account = this.accountService.save(account);
		LOG.info("account: {}", account);

		List<Account> accounts = this.accountService.findAll();
		for (Account item : accounts) {
			LOG.info("account: {}", item);
		}

		return "index";
	}

}
