package com.extend.virtualcardapi.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("extend")
public class ExtendClientConfig {
    public String url;
    public String email;
    public String password;
    public String apiVersion;
}
