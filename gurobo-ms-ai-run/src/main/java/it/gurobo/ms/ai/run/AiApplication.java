package it.gurobo.ms.ai.run;

import it.gurobo.ms.base.ABaseApplication;
import it.gurobo.ms.base.commons.enumeration.EUriRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "it.gurobo.ms.ai.entity"
})
@EnableJpaRepositories(basePackages = {
        "it.gurobo.ms.ai.repository" })

@ComponentScan(basePackages = {
        "it.gurobo.ms.base.configuration",
        "it.gurobo.ms.ai" })

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AiApplication extends ABaseApplication {

    static void main(String[] args) {
        ConfigurableApplicationContext context = run(AiApplication.class, args, EUriRoot.CRON);

    }

}