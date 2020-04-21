package it.gov.pagopa.bpd.award_period.controller;

import eu.sia.meda.core.controller.StatelessController;
import it.gov.pagopa.bpd.award_period.assembler.AwardPeriodResourceAssembler;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.resource.AwardPeriodResource;
import it.gov.pagopa.bpd.award_period.service.AwardPeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
class BpdAwardPeriodControllerImpl extends StatelessController implements BpdAwardPeriodController {

    private final AwardPeriodService awardPeriodService;
    private final AwardPeriodResourceAssembler awardPeriodResourceAssembler;

    @Autowired
    public BpdAwardPeriodControllerImpl(AwardPeriodService awardPeriodService, AwardPeriodResourceAssembler awardPeriodResourceAssembler) {
        this.awardPeriodService = awardPeriodService;
        this.awardPeriodResourceAssembler = awardPeriodResourceAssembler;
    }

    @Override
    public AwardPeriodResource find(Long awardPeriodId) {
        logger.debug("Start find by awardPeriodId");
        logger.debug("awardPeriodId = [" + awardPeriodId + "]");

        try {
            final Optional<AwardPeriod> awardPeriod = awardPeriodService.find(awardPeriodId);
            return awardPeriodResourceAssembler.toResource(awardPeriod.get());
        } catch (
                NoSuchElementException e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public List<AwardPeriodResource> findAll() {
        logger.debug("Start findAll awardPeriod");

        List<AwardPeriod> awardPeriods = awardPeriodService.findAll();
        return awardPeriods.stream()
                .map(awardPeriodResourceAssembler::toResource)
                .collect(Collectors.toList());
    }

}
