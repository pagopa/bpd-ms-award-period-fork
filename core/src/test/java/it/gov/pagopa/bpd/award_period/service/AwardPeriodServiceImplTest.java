package it.gov.pagopa.bpd.award_period.service;

import it.gov.pagopa.bpd.award_period.AwardPeriodDAO;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AwardPeriodServiceImpl.class)
public class AwardPeriodServiceImplTest {

    @MockBean
    private AwardPeriodDAO awardPeriodDAOMock;

    @Autowired
    private AwardPeriodServiceImpl awardPeriodService;


    @PostConstruct
    public void configureTests() {
        when(awardPeriodDAOMock.findById(any(Long.class)))
                .thenAnswer(invocation -> {
                    final Optional<AwardPeriod> result = Optional.of(new AwardPeriod());
                    result.get().setAwardPeriodId(invocation.getArgument(0));
                    return result;
                });

        when(awardPeriodDAOMock.findAll())
                .thenAnswer(invocation -> {
                    AwardPeriod awp = new AwardPeriod();
                    final List<AwardPeriod> results = new ArrayList<AwardPeriod>();
                    results.add(awp);
                    return results;
                });

        when(awardPeriodDAOMock.findAll(Mockito.any(Specification.class)))
                .thenAnswer(invocation -> {
                    AwardPeriod awp = new AwardPeriod();
                    final List<AwardPeriod> results = new ArrayList<AwardPeriod>();
                    results.add(awp);
                    return results;
                });


    }


    @Test
    public void find() {
        Long awardPeriodId = new Random().nextLong();

        final Optional<AwardPeriod> found = awardPeriodService.find(awardPeriodId);

        verify(awardPeriodDAOMock, only()).findById(eq(awardPeriodId));
        verify(awardPeriodDAOMock, times(1)).findById(eq(awardPeriodId));
        assertEquals(awardPeriodId, found.get().getAwardPeriodId());
        assertNotNull(found.get().getAwardPeriodId());
    }

    @Test
    public void findAll_offsetDateNotSpecified() {

        final List<AwardPeriod> founds = awardPeriodService.findAll(null);

        verify(awardPeriodDAOMock, only()).findAll();
        verify(awardPeriodDAOMock, times(1)).findAll();
        assertNotNull(founds);
    }

    @Test
    public void findAll_offsetDateSpecified() {


        final List<AwardPeriod> founds = awardPeriodService.findAll(LocalDate.now());

        verify(awardPeriodDAOMock, only()).findAll(Mockito.any(Specification.class));
        verify(awardPeriodDAOMock, times(1)).findAll(Mockito.any(Specification.class));
        assertNotNull(founds);
    }


}