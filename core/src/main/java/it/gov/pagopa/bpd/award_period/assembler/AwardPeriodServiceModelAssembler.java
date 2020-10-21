package it.gov.pagopa.bpd.award_period.assembler;

import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodServiceModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Mapper between <AwardPeriod> Entity class and <AwardPeriodServiceModel> Resource class
 */
@Service
public class AwardPeriodServiceModelAssembler {

    public AwardPeriodServiceModel toResource(AwardPeriod awardPeriod) {
        AwardPeriodServiceModel resource = null;

        if (awardPeriod != null) {
            resource = new AwardPeriodServiceModel();
            BeanUtils.copyProperties(awardPeriod, resource);
        }
        return resource;
    }

}