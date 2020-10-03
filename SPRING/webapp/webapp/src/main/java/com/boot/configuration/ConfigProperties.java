package com.boot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource("classpath:index.properties")})
@ConfigurationProperties(prefix = "index")
public class ConfigProperties {
    
    private String h1Text;
    private String h2Text;
    
	public String getH1Text() {
		return h1Text;
	}
	public void setH1Text(String h1Text) {
		this.h1Text = h1Text;
	}
	public String getH2Text() {
		return h2Text;
	}
	public void setH2Text(String h2Text) {
		this.h2Text = h2Text;
	}
 
    
}