package it.gov.pagopa.bpd.award_period.service;

import eu.sia.meda.service.BaseService;
import it.gov.pagopa.bpd.award_period.AwardPeriodDAO;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
class AwardPeriodServiceImpl extends BaseService implements AwardPeriodService {

    private final AwardPeriodDAO awardPeriodDAO;


    @Autowired
    public AwardPeriodServiceImpl(AwardPeriodDAO awardPeriodDAO) {
        this.awardPeriodDAO = awardPeriodDAO;
    }

    @Override
    public Optional<AwardPeriod> find(Long awardPeriodId) {
        return awardPeriodDAO.findById(awardPeriodId);
    }

    @Override
    public List<AwardPeriod> findAll() {
        return awardPeriodDAO.findAll();
    }

}
