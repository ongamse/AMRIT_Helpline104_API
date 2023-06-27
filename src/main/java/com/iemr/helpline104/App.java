package com.iemr.helpline104;

import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.helpline104.utils.IEMRApplBeans;
import com.iemr.helpline104.utils.config.ConfigProperties;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
public class App extends SpringBootServletInitializer {

	@Bean
	public ConfigProperties configProperties() {
        return new ConfigProperties();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
	
	@Bean
	public IEMRApplBeans instantiateBeans()
	{
		return new IEMRApplBeans();
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<App> applicationClass = App.class;
}

@RestController
class HelloController {

	@RequestMapping(value ="/hello/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	public String hello(@PathVariable String name) {

		return "Hi " + name + " !";

	}
}


