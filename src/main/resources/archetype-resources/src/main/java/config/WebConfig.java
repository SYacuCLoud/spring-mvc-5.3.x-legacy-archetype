package ${package}.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("${package}")
/*
	Java-based 설정 for Spring MVC
	1. ViewResolver
	2. ResourceHandler
	3. Interceptor
	4. CorsMapping
	5. Spring-beans
	... 등등 설정을 Override 하면 됩니다.
 */
public class WebConfig implements WebMvcConfigurer {
	// 기본 JSP ViewResolver 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
