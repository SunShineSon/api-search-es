package com.hlb.app.core.framework.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hlb.app.core.framework.helper.ConfigHelper;
import com.hlb.app.core.framework.helper.ContextParamHelper;
import com.hlb.base.core.helper.SpringHelper;

public class StartupListener   implements
		ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		SpringHelper.cleanup();

		//super.contextDestroyed(event);

		Log logger = LogFactory.getLog(StartupListener.class);
		if (logger.isDebugEnabled()) {
			logger.info("Application cleanup [OK].");
		}

		//Log4jConfig.shutdownLogging();
		//super.contextDestroyed(event);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			//super.contextInitialized(event);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException("Spring context failed to startup.", e);
		}

		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(event.getServletContext());
		SpringHelper.setContext(context);

		ServletContext servletContext = event.getServletContext();

		
		ConfigHelper configHelper = SpringHelper.getBean(ConfigHelper.class);
		configHelper.init();
		
		// 进行框架的初始化工作
		// 将web.xml中的context-param值放在ContextParamHelper对象中
		ContextParamHelper.getInstance().init(servletContext);

		
	}

}
