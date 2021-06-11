package it.gov.pagopa.bpd.award_period.assembler;

import it.gov.pagopa.bpd.award_period.model.AwardPeriodResource;
import it.gov.pagopa.bpd.award_period.model.AwardPeriodServiceModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Mapper between <AwardPeriodServiceModel> class and <AwardPeriodResource> Resource class
 */
@Service
public class AwardPeriodResourceAssembler {

    public AwardPeriodResource toResource( AwardPeriodServiceModel awardPeriod) {
        AwardPeriodResource resource = null;

        if (awardPeriod != null) {
            resource = new AwardPeriodResource();
            BeanUtils.copyProperties(awardPeriod, resource);
        }
        return resource;
    }

}



