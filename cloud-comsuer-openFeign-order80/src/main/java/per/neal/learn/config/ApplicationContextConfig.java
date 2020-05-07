package per.neal.learn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationContextConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
