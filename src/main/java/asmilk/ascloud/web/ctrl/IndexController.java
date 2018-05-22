package asmilk.ascloud.web.ctrl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloudant.client.api.model.Params;
import com.cloudant.client.api.query.EmptyExpression;
import com.cloudant.client.api.query.ExecutionStats;
import com.cloudant.client.api.query.Expression;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;

import asmilk.ascloud.domain.Account;
import asmilk.ascloud.repository.cloudant.AccountCloudantRepository;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	AccountCloudantRepository accountCloudantRepository;

	@GetMapping({ "/", "/index" })
	public String index() {
		LOG.info("===start===");

		Account account = new Account();
		account.setName("cloudant1");
		LOG.info("account1:{}", account);
		account = this.accountCloudantRepository.save(account);
		LOG.info("account2:{}", account);

		account.setName("cloudant2");
		LOG.info("account3:{}", account);
		account = this.accountCloudantRepository.save(account);
		LOG.info("account4:{}", account);

		boolean isContains = this.accountCloudantRepository.contains(account.getId());
		LOG.info("isContains:{}", isContains);

		account = this.accountCloudantRepository.find(account.getId());
		LOG.info("account5:{}", account);

		account.setName("cloudant3");
		LOG.info("account6:{}", account);
		account = this.accountCloudantRepository.save(account);
		LOG.info("account7:{}", account);

		account = this.accountCloudantRepository.find(account.getId(), account.getRevision());
		LOG.info("account8:{}", account);

		account.setName("cloudant4");
		LOG.info("account9:{}", account);
		account = this.accountCloudantRepository.save(account);
		LOG.info("account10:{}", account);

		account = this.accountCloudantRepository.find(account.getId(), new Params().rev(account.getRevision()));
		LOG.info("account11:{}", account);

		URI dbUri = this.accountCloudantRepository.getDBUri();
		LOG.info("dbUri:{}", dbUri);

		String uri = dbUri.toString() + "/" + account.getId();
		LOG.info("uri:{}", uri);
		account = this.accountCloudantRepository.findAny(uri);
		LOG.info("account12:{}", account);

		QueryResult<Account> queryResult = this.accountCloudantRepository
				.query(new QueryBuilder(EmptyExpression.empty()).build());
		String bookmark = queryResult.getBookmark();
		LOG.info("bookmark:{}", bookmark);
		String warning = queryResult.getWarning();
		LOG.info("warning:{}", warning);
		ExecutionStats executionStats = queryResult.getExecutionStats();
		LOG.info("executionStats:{}", executionStats);
		for (Account item : queryResult.getDocs()) {
			LOG.info("item:{}", item);
		}

		account = this.accountCloudantRepository.remove(account);
		LOG.info("account13:{}", account);

		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account();
		account1.setName("account1");
		accounts.add(account1);
		Account account2 = new Account();
		account2.setName("account1");
		accounts.add(account2);
		Account account3 = new Account();
		account3.setName("account2");
		accounts.add(account3);
		Account account4 = new Account();
		account4.setName("account3");
		accounts.add(account4);
		accounts = this.accountCloudantRepository.bulk(accounts);
		for (Account item : accounts) {
			LOG.info("item:{}", item);
			if ("account2".equals(item.getName())) {
				item.setName("account22");
			}
		}
		LOG.info("##############################");
		accounts = this.accountCloudantRepository.bulk(accounts);
		for (Account item : accounts) {
			LOG.info("item:{}", item);
		}

		LOG.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		queryResult = this.accountCloudantRepository.query(new QueryBuilder(Expression.eq("name", "account1")).build());
		bookmark = queryResult.getBookmark();
		LOG.info("bookmark:{}", bookmark);
		warning = queryResult.getWarning();
		LOG.info("warning:{}", warning);
		executionStats = queryResult.getExecutionStats();
		LOG.info("executionStats:{}", executionStats);
		for (Account item : queryResult.getDocs()) {
			LOG.info("item:{}", item);
		}
		return "index";
	}

}
