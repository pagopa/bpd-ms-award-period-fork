package it.gov.pagopa.bpd.award_period.service;

import eu.sia.meda.service.BaseService;
import it.gov.pagopa.bpd.award_period.connector.jpa.AwardPeriodDAO;
import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.award_period.exception.AwardPeriodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @See AwardPeriodService
 */
@Service
class AwardPeriodServiceImpl extends BaseService implements AwardPeriodService {

    private final AwardPeriodDAO awardPeriodDAO;


    static <S extends AwardPeriod> Specification<S> isOffsetDateTimeSpecified(LocalDate offsetDate) {
        return (awardPeriod, cq, cb) ->
                cb.between(cb.literal(offsetDate), awardPeriod.get("startDate"), awardPeriod.get("endDate"));
    }

    @Autowired
    public AwardPeriodServiceImpl(AwardPeriodDAO awardPeriodDAO) {
        this.awardPeriodDAO = awardPeriodDAO;
    }

    @Override
    public AwardPeriod find(Long awardPeriodId) {
        return awardPeriodDAO.findById(awardPeriodId)
                .orElseThrow(() -> new AwardPeriodNotFoundException(awardPeriodId));
    }


    @Override
    public List<AwardPeriod> findAll(LocalDate offsetDate) {
        return offsetDate == null ?
                awardPeriodDAO.findAll() : awardPeriodDAO.findAll(isOffsetDateTimeSpecified(offsetDate));
    }

    @Override
    public List<AwardPeriod> findActiveAwardPeriods() {
        return awardPeriodDAO.findActiveAwardPeriods();
    }

}
