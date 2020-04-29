package it.gov.pagopa.bpd.award_period;

import eu.sia.meda.connector.jpa.CrudJpaDAO;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object to manage all CRUD operations to the database
 */
@Repository
public interface AwardPeriodDAO extends CrudJpaDAO<AwardPeriod, Long> {
}


