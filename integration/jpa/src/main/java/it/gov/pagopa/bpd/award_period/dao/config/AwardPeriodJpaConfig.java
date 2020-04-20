package it.gov.pagopa.bpd.award_period.dao.config;

import eu.sia.meda.connector.jpa.JPAConnectorImpl;
import eu.sia.meda.connector.jpa.config.JPAConnectorConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ConditionalOnMissingBean(name = "JPADataSource")
@Configuration
@PropertySource("classpath:config/AwardPeriodJpaConnectionConfig.properties")
@EnableJpaRepositories(
        repositoryBaseClass = JPAConnectorImpl.class,
        basePackages = {"it.gov.pagopa.bpd"}
)
public class AwardPeriodJpaConfig extends JPAConnectorConfig {
}
