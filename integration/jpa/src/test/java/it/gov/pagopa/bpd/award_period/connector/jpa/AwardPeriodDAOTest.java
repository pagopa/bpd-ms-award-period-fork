package it.gov.pagopa.bpd.award_period.connector.jpa;

import eu.sia.meda.layers.connector.query.CriteriaQuery;
import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.common.connector.jpa.BaseCrudJpaDAOTest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class AwardPeriodDAOTest extends BaseCrudJpaDAOTest<AwardPeriodDAO, AwardPeriod, Long> {

    @Autowired
    private AwardPeriodDAO dao;

    @Override
    protected AwardPeriodDAO getDao() {
        return dao;
    }

    @Override
    protected void setId(AwardPeriod entity, Long id) {
        entity.setAwardPeriodId(id);
    }

    @Override
    protected Long getId(AwardPeriod entity) {
        return entity.getAwardPeriodId();
    }

    @Override
    protected CriteriaQuery<? super AwardPeriod> getMatchAlreadySavedCriteria() {
        AwardPeriodDAOTest.AwardPeriodCriteria criteriaQuery = new AwardPeriodDAOTest.AwardPeriodCriteria();
        criteriaQuery.setAwardPeriodId(getStoredId());

        return criteriaQuery;
    }

    @Override
    protected void alterEntityToUpdate(AwardPeriod entity) {
        entity.setUpdateUser("userUpdate");
    }

    @Override
    protected String getIdName() {
        return "awardPeriodId";
    }

    /**
     * {@inheritDoc}
     * It have to return null because of current Entity Id generation type
     */
    @Override
    protected Function<Integer, Long> idBuilderFn() {

        return integer -> null;
    }

    @Data
    private static class AwardPeriodCriteria implements CriteriaQuery<AwardPeriod> {
        private Long awardPeriodId;
    }

}
