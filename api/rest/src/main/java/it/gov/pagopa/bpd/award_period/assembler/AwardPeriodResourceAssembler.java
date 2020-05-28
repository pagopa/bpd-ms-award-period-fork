package it.gov.pagopa.bpd.award_period.assembler;

import it.gov.pagopa.bpd.award_period.connector.jpa.model.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodResource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Mapper between <AwardPeriod> Entity class and <AwardPeriodResource> Resource class
 */
@Service
public class AwardPeriodResourceAssembler {

    public AwardPeriodResource toResource( AwardPeriod awardPeriod) {
        AwardPeriodResource resource = null;

        if (awardPeriod != null) {
            resource = new AwardPeriodResource();
            BeanUtils.copyProperties(awardPeriod, resource);
        }
        return resource;
    }

}
