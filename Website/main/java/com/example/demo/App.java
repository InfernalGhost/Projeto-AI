package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;


@SpringBootApplication
@EnableMongoRepositories
@EntityScan("com.example.*")
public class App implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
    public void run(String...args) throws Exception {
        System.out.println("Application Started !!");
    }

	// @Bean
	// public ServletWebServerFactory servletContainer(SSLProperties sslProperties) {
	// 	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
	// 	tomcat.addAdditionalTomcatConnectors(createSslConnector(sslProperties));
	// 	return tomcat;
	// }

	// @Bean
	// private Connector createSslConnector(SSLProperties sslProperties) {
	// 	Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	// 	Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
	// 	try {
	// 		connector.setScheme("https");
	// 		connector.setSecure(true);
	// 		connector.setPort(8443);
	// 		protocol.setSSLEnabled(true);
	// 		protocol.setKeystoreFile(((Resource) sslProperties.getKeyStore()).getFile().getAbsolutePath());
	// 		protocol.setKeystorePass(sslProperties.getKeyStorePassword());
	// 		protocol.setTruststoreFile(((Resource) sslProperties.getTrustStore()).getFile().getAbsolutePath());
	// 		protocol.setTruststorePass(sslProperties.getTrustStorePassword());
	// 		protocol.setKeyAlias("tomcat");
	// 	return connector;
	// 	}
	// 	catch (IOException ex) {
	// 	throw new IllegalStateException("can't access keystore: [" + "keystore"
	// 		+ "] or truststore: [" + "keystore" + "]", ex);
	// 	}
	// }
}
