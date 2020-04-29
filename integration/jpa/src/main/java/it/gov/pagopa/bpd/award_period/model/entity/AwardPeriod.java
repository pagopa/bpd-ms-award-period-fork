package it.gov.pagopa.bpd.award_period.model.entity;

import it.gov.pagopa.bpd.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"awardPeriodId"}, callSuper = false)
@Table(name = "bpd_award_period")
@Where(clause = "ENABLED_B = 'TRUE'")
public class AwardPeriod extends BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "id", sequenceName = "bpd_award_period_award_period_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @Column(name = "award_period_id_n")
    private Long awardPeriodId;

    @Column(name = "aw_period_start_d")
    private LocalDate startDate;

    @Column(name = "aw_period_end_d")
    private LocalDate endDate;

}
