package it.gov.pagopa.bpd.award_period.exception;

import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.common.exception.ResourceNotEnabledException;

public class AwardPeriodNotEnabledException extends ResourceNotEnabledException {

    public AwardPeriodNotEnabledException(Long awardPeriodId) {
        super(AwardPeriod.class, awardPeriodId);
    }

}