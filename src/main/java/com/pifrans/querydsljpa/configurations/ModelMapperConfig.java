package com.pifrans.querydsljpa.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta classe criar um {@link Bean} de {@link ModelMapper} para converter model em dto e dto em model
 */
@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
