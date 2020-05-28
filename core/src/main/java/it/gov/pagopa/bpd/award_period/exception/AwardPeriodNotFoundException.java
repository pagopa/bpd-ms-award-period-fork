package it.gov.pagopa.bpd.award_period.exception;

import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.common.exception.ResourceNotFoundException;

public class AwardPeriodNotFoundException extends ResourceNotFoundException {

    public AwardPeriodNotFoundException(Long awardPeriodId) {
        super(AwardPeriod.class, awardPeriodId);
    }
}
