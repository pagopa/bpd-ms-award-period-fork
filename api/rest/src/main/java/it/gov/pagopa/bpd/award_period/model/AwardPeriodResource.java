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

    @ApiModelProperty(value = "${swagger.awardPeriod.gracePeriod}", required = true)
    @JsonProperty(required = true)
    private Long gracePeriod;

}
