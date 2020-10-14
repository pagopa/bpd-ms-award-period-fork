package it.gov.pagopa.bpd.award_period.connector.jpa;

import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.common.connector.jpa.CrudJpaDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data Access Object to manage all CRUD operations to the database
 */
@Repository
public interface AwardPeriodDAO extends CrudJpaDAO<AwardPeriod, Long> {

    @Query(value = "SELECT aw " +
            "FROM AwardPeriod aw " +
            "WHERE CURRENT_DATE BETWEEN aw_period_start_d" +
            " AND (aw_period_end_d + aw_grace_period_n)")
    List<AwardPeriod> findActiveAwardPeriods();
}


