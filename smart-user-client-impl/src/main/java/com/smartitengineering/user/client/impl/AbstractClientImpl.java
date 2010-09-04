/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.client.impl;

import com.smartitengineering.user.client.impl.login.LoginCenter;
import com.smartitengineering.util.rest.atom.HttpClient;
import com.smartitengineering.util.rest.client.jersey.cache.CacheableClient;
import com.smartitengineering.util.rest.client.jersey.cache.CacheableClientConfigProps;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.atom.abdera.impl.provider.entity.FeedProvider;
import java.net.URI;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.ws.rs.core.UriBuilder;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author russel
 */
public class AbstractClientImpl {

  protected static final URI BASE_URI;
  protected static final ConnectionConfig CONNECTION_CONFIG;

  static {
    ApplicationContext context = new ClassPathXmlApplicationContext("config-context.xml");
    CONNECTION_CONFIG = ConfigFactory.getInstance().getConnectionConfig();

    UriBuilder.fromUri(CONNECTION_CONFIG.getBasicUri());

//    BASE_URI = UriBuilder.fromUri(CONNECTION_CONFIG.getContextPath()).host(CONNECTION_CONFIG.getHost()).port(CONNECTION_CONFIG.
//        getPort()).path(CONNECTION_CONFIG.getBasicUri()).build();

    //BASE_URI = UriBuilder.fromUri("").host(CONNECTION_CONFIG.getHost()).port(CONNECTION_CONFIG.getPort()).path(CONNECTION_CONFIG.getBasicUri()).build();
    BASE_URI = UriBuilder.fromUri("http://localhost:9090").build();

  }
  private Client client;
  private HttpClient httpClient;

  protected AbstractClientImpl() {
  }

  public URI getBaseUri() {
    return BASE_URI;
  }

  public Client getClient() {
    if (client == null) {
      DefaultClientConfig clientConfig = new DefaultClientConfig();
      clientConfig.getProperties().put(CacheableClientConfigProps.USERNAME, LoginCenter.getUsername());
      clientConfig.getProperties().put(CacheableClientConfigProps.PASSWORD, LoginCenter.getPassword());
      clientConfig.getClasses().add(FeedProvider.class);
      //clientConfig.getClasses().add(JSONRootElementProvider.App.class);
      clientConfig.getClasses().add(JacksonJsonProvider.class);

      client = CacheableClient.create(clientConfig);
    }
    return client;
  }

  public HttpClient getHttpClient() {
    if (httpClient == null) {
      httpClient = new HttpClient(getClient(), BASE_URI.getHost(), CONNECTION_CONFIG.getPort());
    }
    return httpClient;
  }
}
