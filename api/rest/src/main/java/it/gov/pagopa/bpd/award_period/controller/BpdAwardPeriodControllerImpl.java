package it.gov.pagopa.bpd.award_period.controller;

import eu.sia.meda.core.controller.StatelessController;
import it.gov.pagopa.bpd.award_period.assembler.AwardPeriodResourceAssembler;
import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodResource;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodServiceModel;
import it.gov.pagopa.bpd.award_period.service.AwardPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @See BpdAwardPeriodController
 */
@RestController
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
        if (logger.isDebugEnabled()) {
            logger.debug("BpdAwardPeriodControllerImpl.find");
            logger.debug("awardPeriodId = [" + awardPeriodId + "]");
        }

        final AwardPeriodServiceModel awardPeriod = awardPeriodService.find(awardPeriodId);
        return awardPeriodResourceAssembler.toResource(awardPeriod);
    }

    @Override
    public List<AwardPeriodResource> findAll(OffsetDateTime offsetDateTime) {
        if (logger.isDebugEnabled()) {
            logger.debug("BpdAwardPeriodControllerImpl.findAll");
            logger.debug("offsetDateTime = [" + offsetDateTime + "]");
        }

        LocalDate offsetDate = null;
        if (offsetDateTime != null) {
            offsetDate = offsetDateTime.toLocalDate();
        }

        List<AwardPeriodServiceModel> awardPeriods = awardPeriodService.findAll(offsetDate);
        return awardPeriods.stream()
                .map(awardPeriodResourceAssembler::toResource)
                .collect(Collectors.toList());
    }

    @Override
    public List<AwardPeriodResource> findActiveAwardPeriods() {
        if (logger.isDebugEnabled()) {
            logger.debug("BpdAwardPeriodControllerImpl.findActiveAwardPeriods");
        }

        List<AwardPeriodServiceModel> awardPeriods = awardPeriodService.findActiveAwardPeriods();
        return awardPeriods.stream()
                .map(awardPeriodResourceAssembler::toResource)
                .collect(Collectors.toList());
    }

}
