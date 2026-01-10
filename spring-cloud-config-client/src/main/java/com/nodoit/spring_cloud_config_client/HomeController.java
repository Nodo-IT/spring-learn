package com.nodoit.spring_cloud_config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RefreshScope // set this bean to be refreshed by actuator
public class HomeController {

  @Value("${example.property}")
  private String property;

  @GetMapping("/config")
  public String printSimpleProperty() {
    return property;
  }

}
