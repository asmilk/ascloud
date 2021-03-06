package asmilk.ascloud.web.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("/save")
	public String save() {
		Account account = new Account();
		account.setName("account_" + System.currentTimeMillis());
		account = this.accountService.save(account);
		LOG.info("account1:{}", account);
		return "index";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") String id) {
		LOG.info("id:{}", id);
		Account account = this.accountService.find(id);
		LOG.info("account2:{}", account);
		account.setName("account_" + System.currentTimeMillis());
		account = this.accountService.save(account);
		LOG.info("account3:{}", account);
		return "index";
	}

	@GetMapping("/{id}")
	public String find(@PathVariable("id") String id) {
		LOG.info("id:{}", id);
		Account account = this.accountService.find(id);
		LOG.info("account4:{}", account);
		return "index";
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") String id) {
		LOG.info("id:{}", id);
		Account account = this.accountService.find(id);
		LOG.info("account5:{}", account);
		account = this.accountService.remove(account);
		LOG.info("account6:{}", account);
		return "index";
	}

}
