package it.gov.pagopa.bpd.award_period.service;

import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;

import java.util.List;
import java.util.Optional;

public interface AwardPeriodService {

    Optional<AwardPeriod> find(Long awardPeriodId);

    List<AwardPeriod> findAll();

}
