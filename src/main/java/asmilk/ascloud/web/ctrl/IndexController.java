package asmilk.ascloud.web.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.api.query.Expression;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.service.AccountService;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	AccountService accountService;

	@Autowired
	Database database;

	@GetMapping({ "/", "/index" })
	public String index() {
		LOG.info("===start===");

		Account account = new Account();
		account.setName("cloudant");
		Response response = this.database.save(account);
		account.setDocId(response.getId());
		account.setDocRev(response.getRev());
		LOG.info("account1: {}", account);

		account.setName("jpa");
		account = this.accountService.save(account);
		LOG.info("account2: {}", account);

		List<Account> accounts = this.accountService.findAll();
		for (Account item : accounts) {
			LOG.info("account3: {}", item);
			item.setName("jpa:" + System.currentTimeMillis());
			item = this.accountService.save(item);
			LOG.info("account4: {}", item);
			break;
		}

		account = this.database.find(Account.class, account.getDocId(), account.getDocRev());
		LOG.info("account5: {}", account);
		account.setName("cloudant:" + System.currentTimeMillis());
		response = this.database.update(account);
		account.setDocId(response.getId());
		account.setDocRev(response.getRev());
		LOG.info("account6: {}", account);

		QueryResult<Account> queryResult = this.database
				.query(new QueryBuilder(Expression.eq("name", "cloudant")).build(), Account.class);
		List<Account> list = queryResult.getDocs();
		for (Account item : list) {
			LOG.info("account7: {}", item);
		}

		return "index";
	}

}
