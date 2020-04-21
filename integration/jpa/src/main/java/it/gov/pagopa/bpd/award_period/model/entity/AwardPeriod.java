package it.gov.pagopa.bpd.award_period.model.entity;

import it.gov.pagopa.bpd.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"awardPeriodId"}, callSuper = false)
@Table(name = "bpd_award_period")
public class AwardPeriod extends BaseEntity implements Serializable {

    @Id
    @Column(name = "award_period_id")
    private Long awardPeriodId;

    @Column(name = "aw_period_start_d")
    private LocalDate startDate;

    @Column(name = "aw_period_end_d")
    private LocalDate endDate;

    @Column(name = "enabled_b")
    private Boolean enabled;

}
