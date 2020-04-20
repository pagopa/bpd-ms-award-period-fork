package it.gov.pagopa.bpd.award_period.assembler;

import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.resource.AwardPeriodResource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
