package it.gov.pagopa.bpd.award_period.service;

import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;

import java.util.Optional;

public interface AwardPeriodService {

    Optional<AwardPeriod> find(int awardPeriodId);

}
