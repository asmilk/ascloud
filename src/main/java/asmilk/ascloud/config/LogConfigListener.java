package asmilk.ascloud.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

@WebListener
public class LogConfigListener implements ServletContextListener {

	private static final Logger LOG = LoggerFactory.getLogger(LogConfigListener.class);

	public void contextInitialized(ServletContextEvent sce) {
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
		LOG.info("Installed root logger handler.");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		SLF4JBridgeHandler.uninstall();
		LOG.info("Uninstalled root logger handler.");
	}

}
