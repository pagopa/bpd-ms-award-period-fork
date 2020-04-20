package it.gov.pagopa.bpd.award_period.model.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "awardPeriodId", callSuper = false)
public class AwardPeriodResource {

    private int awardPeriodId;
    private LocalDate startDate;
    private LocalDate endDate;


}
