package com.esusige.feed_api.Config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeanFactory {
    //PRTEST
    @Bean
    public ModelMapper modellMapper(){
        return new ModelMapper();
    }
    //testGithubPR
}
