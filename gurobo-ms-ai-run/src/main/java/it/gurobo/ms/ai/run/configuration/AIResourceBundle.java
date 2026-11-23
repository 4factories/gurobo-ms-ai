package it.gurobo.ms.ai.run.configuration;

import it.gurobo.ms.base.GuroboBaseAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.ArrayList;
import java.util.List;

@Component
public class AIResourceBundle extends GuroboBaseAutoConfiguration {
    @Override
    protected List<String> customMessage() {
        List<String> list = new ArrayList<>();
        list.add("messagges/ai");
        return list;
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        return getReloadableResourceBundleMessageSource();
    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        return getLocalValidatorFactoryBean(messageSource);
    }

}
