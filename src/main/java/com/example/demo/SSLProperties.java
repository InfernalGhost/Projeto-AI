package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("ssl")
@Component
public class SSLProperties {
  
  private Resource keyStore;
  private String keyStorePassword;
  private Resource trustStore;
  private String trustStorePassword;

  public Resource getKeyStore() {
    return keyStore;
}
public void setKeyStore(Resource keyStore) {
    this.keyStore = keyStore;
}
public String getKeyStorePassword() {
    return keyStorePassword;
}
public void setKeyStorePassword(String keyStorePassword) {
    this.keyStorePassword = keyStorePassword;
}
public Resource getTrustStore() {
    return trustStore;
}
public void setTrustStore(Resource trustStore) {
    this.trustStore = trustStore;
}
public String getTrustStorePassword() {
    return trustStorePassword;
}
public void setTrustStorePassword(String trustStorePassword) {
    this.trustStorePassword = trustStorePassword;
}

  
  
  // Getters and setters
}
