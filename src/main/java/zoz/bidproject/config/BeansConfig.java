package zoz.bidproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(basePackages ={"zoz.bidproject"})
@ComponentScan(basePackages = {"zoz.bidproject"})
public class BeansConfig {

}
