package it.gov.pagopa.bpd.award_period.service;

import eu.sia.meda.service.BaseService;
import it.gov.pagopa.bpd.award_period.assembler.AwardPeriodServiceModelAssembler;
import it.gov.pagopa.bpd.award_period.connector.jpa.AwardPeriodDAO;
import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.award_period.exception.AwardPeriodNotFoundException;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @See AwardPeriodService
 */
@Service
class AwardPeriodServiceImpl extends BaseService implements AwardPeriodService {

    private final AwardPeriodDAO awardPeriodDAO;
    private final AwardPeriodServiceModelAssembler awardPeriodServiceModelAssembler;


    static <S extends AwardPeriod> Specification<S> isOffsetDateTimeSpecified(LocalDate offsetDate) {
        return (awardPeriod, cq, cb) ->
                cb.between(cb.literal(offsetDate), awardPeriod.get("startDate"), awardPeriod.get("endDate"));
    }

    @Autowired
    public AwardPeriodServiceImpl(AwardPeriodDAO awardPeriodDAO, AwardPeriodServiceModelAssembler awardPeriodServiceModelAssembler) {
        this.awardPeriodDAO = awardPeriodDAO;
        this.awardPeriodServiceModelAssembler = awardPeriodServiceModelAssembler;
    }

    @Override
    public AwardPeriodServiceModel find(Long awardPeriodId) {
        AwardPeriod awardPeriod = awardPeriodDAO.findById(awardPeriodId)
                .orElseThrow(() -> new AwardPeriodNotFoundException(awardPeriodId));
        AwardPeriodServiceModel awardPeriodServiceModel = awardPeriodServiceModelAssembler.toResource(awardPeriod);
        return defineAndSetStatus(awardPeriodServiceModel);
    }


    @Override
    public List<AwardPeriodServiceModel> findAll(LocalDate offsetDate) {

        List<AwardPeriod> awardPeriods = offsetDate == null ?
                awardPeriodDAO.findAll() : awardPeriodDAO.findAll(isOffsetDateTimeSpecified(offsetDate));
        List<AwardPeriodServiceModel> awardPeriodServiceModels = awardPeriods.stream()
                .map(awardPeriodServiceModelAssembler::toResource).collect(Collectors.toList());

        return awardPeriodServiceModels.stream()
                .map(this::defineAndSetStatus)
                .collect(Collectors.toList());
    }

    @Override
    public List<AwardPeriodServiceModel> findActiveAwardPeriods() {

        List<AwardPeriod> awardPeriods = awardPeriodDAO.findActiveAwardPeriods();
        List<AwardPeriodServiceModel> awardPeriodServiceModels = awardPeriods.stream()
                .map(awardPeriodServiceModelAssembler::toResource).collect(Collectors.toList());

        return awardPeriodServiceModels.stream()
                .map(this::defineAndSetStatus)
                .collect(Collectors.toList());
    }


    public AwardPeriodServiceModel defineAndSetStatus(AwardPeriodServiceModel awardPeriod){
        LocalDate startDate = awardPeriod.getStartDate();
        LocalDate endDate = awardPeriod.getEndDate();
        LocalDate currentDate = LocalDate.now();
        if((currentDate.isEqual(startDate)||currentDate.isAfter(startDate)) &&
                (currentDate.isBefore(endDate)||currentDate.isEqual(endDate))){
            awardPeriod.setStatus("ACTIVE");
            return awardPeriod;
        } else if (currentDate.isBefore(startDate)) {
            awardPeriod.setStatus("INACTIVE");
            return awardPeriod;
        } else {
            awardPeriod.setStatus("CLOSED");
            return awardPeriod;
        }
    }
}
