package per.neal.learn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("per.neal.learn.dao")
public class MybatisConfig {
}
