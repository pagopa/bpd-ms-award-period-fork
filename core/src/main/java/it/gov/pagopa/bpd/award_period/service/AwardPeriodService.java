package it.gov.pagopa.bpd.award_period.service;

import it.gov.pagopa.bpd.award_period.model.AwardPeriodServiceModel;

import java.time.LocalDate;
import java.util.List;

/**
 * A service to manage the Business Logic related to AwardPeriod
 */
public interface AwardPeriodService {

    AwardPeriodServiceModel find(Long awardPeriodId);

    List<AwardPeriodServiceModel> findAll(LocalDate offsetDate);

    List<AwardPeriodServiceModel> findActiveAwardPeriods();

}
