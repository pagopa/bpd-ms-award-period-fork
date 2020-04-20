package it.gov.pagopa.bpd.award_period;

import eu.sia.meda.connector.jpa.CrudJpaDAO;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AwardPeriodDAO extends CrudJpaDAO<AwardPeriod, Serializable> {
}


