package asmilk.ascloud.web.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import asmilk.ascloud.domain.Book;
import asmilk.ascloud.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/save")
	public String save() {
		Book book = new Book();
		book.setName("book_" + System.currentTimeMillis());
		LOG.info("book1:{}", book);
		book = this.bookService.save(book);
		LOG.info("book2:{}", book);
		
		this.rabbitTemplate.convertAndSend("myqueue", book);
		return "index";
	}

	@GetMapping("/{id}")
	public String find(@PathVariable("id") String id) {
		Book book = this.bookService.find(id);
		LOG.info("book3:{}", book);
		return "index";
	}

	@GetMapping("/{id}/{rev}")
	public String find(@PathVariable("id") String id, @PathVariable("rev") String rev) {
		Book book = this.bookService.find(id, rev);
		LOG.info("book4:{}", book);
		return "index";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") String id) {
		Book book = this.bookService.find(id);
		LOG.info("book5:{}", book);
		book = this.bookService.remove(book);
		LOG.info("book6:{}", book);
		return "index";
	}
	
	@GetMapping("/receive")
	public String receive() {
		Book book = (Book) this.rabbitTemplate.receiveAndConvert("myqueue");
		LOG.info("book7:{}", book);
		return "index";
	}

}
