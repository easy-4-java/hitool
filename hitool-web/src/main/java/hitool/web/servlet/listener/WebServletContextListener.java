package hitool.web.servlet.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Class providing functionality for WebServletContextListener.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class WebServletContextListener implements ServletContextListener, ServletContextAttributeListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
