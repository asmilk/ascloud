package asmilk.ascloud.web.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	// @Autowired
	// DataSource dataSource;

	@GetMapping({ "/", "/index" })
	public String index() {
		LOG.info("===start===");
		// LOG.info("dataSource: {}", dataSource);
		return "index";
	}

}
