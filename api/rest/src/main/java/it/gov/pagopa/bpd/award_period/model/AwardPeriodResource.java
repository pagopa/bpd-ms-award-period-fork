package it.gov.pagopa.bpd.award_period.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "awardPeriodId", callSuper = false)
public class AwardPeriodResource {

    @ApiModelProperty(value = "${swagger.awardPeriod.awardPeriodId}", required = true)
    @JsonProperty(required = true)
    private Long awardPeriodId;

    @ApiModelProperty(value = "${swagger.awardPeriod.startDate}", required = true)
    @JsonProperty(required = true)
    private LocalDate startDate;

    @ApiModelProperty(value = "${swagger.awardPeriod.endDate}", required = true)
    @JsonProperty(required = true)
    private LocalDate endDate;

    @ApiModelProperty(value = "${swagger.awardPeriod.minTransactionNumber}", required = true)
    @JsonProperty(required = true)
    private Long minTransactionNumber;

    @ApiModelProperty(value = "${swagger.awardPeriod.maxAmount}", required = true)
    @JsonProperty(required = true)
    private Long maxAmount;

    @ApiModelProperty(value = "${swagger.awardPeriod.minPosition}", required = true)
    @JsonProperty(required = true)
    private Long minPosition;

    @ApiModelProperty(value = "${swagger.awardPeriod.maxTransactionCashback}", required = true)
    @JsonProperty(required = true)
    private Long maxTransactionCashback;

    @ApiModelProperty(value = "${swagger.awardPeriod.maxPeriodCashback}", required = true)
    @JsonProperty(required = true)
    private Long maxPeriodCashback;

    @ApiModelProperty(value = "${swagger.awardPeriod.cashbackPercentage}", required = true)
    @JsonProperty(required = true)
    private Long cashbackPercentage;

    @ApiModelProperty(value = "${swagger.awardPeriod.gracePeriod}", required = true)
    @JsonProperty(required = true)
    private Long gracePeriod;

    @ApiModelProperty(value = "${swagger.awardPeriod.status}", required = true)
    @JsonProperty(required = true)
    private String status;

    @ApiModelProperty(value = "${swagger.awardPeriod.maxTransactionEvaluated}", required = true)
    @JsonProperty(required = true)
    private Long maxTransactionEvaluated;

}
