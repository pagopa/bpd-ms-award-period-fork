package it.gov.pagopa.bpd.award_period.controller;

import it.gov.pagopa.bpd.award_period.assembler.AwardPeriodResourceAssembler;
import eu.sia.meda.core.controller.StatelessController;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.resource.AwardPeriodResource;
import it.gov.pagopa.bpd.award_period.service.AwardPeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
class BpdAwardPeriodControllerImpl extends StatelessController implements BpdAwardPeriodController {

    private final AwardPeriodService awardPeriodService;
    private final AwardPeriodResourceAssembler awardPeriodResourceAssembler;

    @Autowired
    public BpdAwardPeriodControllerImpl(AwardPeriodService awardPeriodService, AwardPeriodResourceAssembler awardPeriodResourceAssembler){
        this.awardPeriodService = awardPeriodService;
        this.awardPeriodResourceAssembler = awardPeriodResourceAssembler;
    }

    @Override
    public AwardPeriodResource find(int awardPeriodId) {
        logger.debug("Start find by awardPeriodId");
        logger.debug("awardPeriodId = [" + awardPeriodId + "]");

        final Optional<AwardPeriod> awardPeriod = awardPeriodService.find(awardPeriodId);
        return awardPeriodResourceAssembler.toResource(awardPeriod.get());
    }

}
