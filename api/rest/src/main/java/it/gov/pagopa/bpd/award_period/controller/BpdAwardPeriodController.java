package it.gov.pagopa.bpd.award_period.controller;

import io.swagger.annotations.Api;
import it.gov.pagopa.bpd.award_period.model.resource.AwardPeriodResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Api(tags = "Bonus Pagamenti Digitali award-period Controller")
@RequestMapping("/bpd/award-periods")
public interface BpdAwardPeriodController {

    @GetMapping(value = "/{awardPeriodId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    AwardPeriodResource find(@PathVariable("awardPeriodId") @Valid @NotBlank Long awardPeriodId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<AwardPeriodResource> findAll();

}
