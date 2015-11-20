package com.pmc;

import static org.dozer.loader.api.FieldsMappingOptions.copyByReference;
import static org.dozer.loader.api.FieldsMappingOptions.oneWay;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pmc.dto.MemberRecordDto;
import com.pmc.dto.base.BaseDto;
import com.pmc.model.MemberRecord;
import com.pmc.model.base.BaseEntity;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@Configuration
public class MapperConfig {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

    @PostConstruct
    public void initMapping() {
        mapper().addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(BaseEntity.class, BaseDto.class)
                        .fields("dateCreated", "dateCreated", copyByReference(), oneWay())
                        .fields("dateUpdated", "dateUpdated", copyByReference(), oneWay());

                mapping(MemberRecord.class, MemberRecordDto.class)
                        .fields("approvedDate", "approvedDate", copyByReference(), oneWay())
                        .fields("expirationDate", "expirationDate", copyByReference(), oneWay());
            }
        });
    }

}
