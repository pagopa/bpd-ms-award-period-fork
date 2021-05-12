package it.gov.pagopa.bpd.award_period.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AwardPeriodServiceModel {

    private Long awardPeriodId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long gracePeriod;
    private Long minTransactionNumber;
    private BigDecimal maxAmount;
    private Long minPosition;
    private Long maxTransactionCashback;
    private Long maxPeriodCashback;
    private Long cashbackPercentage;
    private String status;
    private Long maxTransactionEvaluated;
    private BigDecimal minAmount;

}