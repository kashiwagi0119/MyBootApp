package com.tuyano.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.GzipResourceResolver;

@Configuration
public class WebConfig {
	
	/**
	 * 静的リソースに対する定義。
	 *
	 * @param registry {@link ResourceHandlerRegistry}
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	     // webjars の定義
	     registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
	                 .resourceChain(false) // 自動で WebJarsResourceResolver が有効化される。
	                 .addResolver(new GzipResourceResolver()); // gz ファイルへのアクセス有効化。
	}
}
