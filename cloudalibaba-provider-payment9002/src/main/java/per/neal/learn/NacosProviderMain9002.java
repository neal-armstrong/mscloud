package per.neal.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {
    public static void main(String[] args) {
        System.out.println("just A test git rebase");
        System.out.println("just B test git rebase");
        System.out.println("just C test git rebase");
        SpringApplication.run(NacosProviderMain9002.class, args);
    }
}
