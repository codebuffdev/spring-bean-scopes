package in.spdev.scopes.applicationscope.webapp1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "in.spdev.scopes.applicationscope")
public class AppConfig1 implements WebMvcConfigurer {
}
