package com.aw.vmall.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket adminApiConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("adminApi")//给api分组，页面会出现下拉菜单
				.apiInfo(adminApiInfo())//注册api信息
				.select()
				.paths(Predicates.and(PathSelectors.regex("/admin/.*")))//只要/admin/路径下的api
				.build();
	}

	@Bean
	public Docket webApiConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("webApi")
				.apiInfo(webApiInfo())
				.select()
				.paths(Predicates.not(PathSelectors.regex("/admin/.*")))//过滤掉路径为/admin/的api
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}

	//辅助定义api的一些信息
	private ApiInfo adminApiInfo(){

		return new ApiInfoBuilder()
				.title("后台管理系统-PI文档")
				.description("本文档描述了后台管理系统商品中心微服务接口定义")
				.version("1.0")
				.contact(new Contact("dengtongle", "http://aw.com", "120222126@qq.com"))
				.build();
	}

	private ApiInfo webApiInfo(){

		return new ApiInfoBuilder()
				.title("网站-API文档")
				.description("本文档描述了微服务接口定义")
				.version("1.0")
				.contact(new Contact("dengtongle", "http://aw.com", "120222126@qq.com"))
				.build();
	}
}
