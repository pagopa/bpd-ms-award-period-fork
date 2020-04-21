package it.gov.pagopa.bpd.award_period;


import eu.sia.meda.connector.jpa.JPAConnectorImpl;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class AwardPeriodDAOImpl extends JPAConnectorImpl<AwardPeriod, Long> implements AwardPeriodDAO {
    @Autowired
    public AwardPeriodDAOImpl(EntityManager em) {
        super(AwardPeriod.class, em);
    }

    static <S extends AwardPeriod> Specification<S> isEnabled() {
        return (awardPeriod, cq, cb) -> cb.equal(awardPeriod.get("enabled"), true);
    }

    @Override
    protected <S extends AwardPeriod> TypedQuery<Long> getCountQuery(Specification<S> spec, Class<S> domainClass) {
        return super.getCountQuery(spec == null ? isEnabled() : spec.and(isEnabled()), domainClass);
    }

    @Override
    protected <S extends AwardPeriod> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {
        return super.getQuery(spec == null ? isEnabled() : spec.and(isEnabled()), domainClass, sort);
    }
}
