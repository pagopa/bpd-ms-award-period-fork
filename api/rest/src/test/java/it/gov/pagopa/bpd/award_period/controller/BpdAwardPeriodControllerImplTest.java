package it.gov.pagopa.bpd.award_period.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.sia.meda.config.ArchConfiguration;
import it.gov.pagopa.bpd.award_period.assembler.AwardPeriodResourceAssembler;
import it.gov.pagopa.bpd.award_period.model.entity.AwardPeriod;
import it.gov.pagopa.bpd.award_period.model.resource.AwardPeriodResource;
import it.gov.pagopa.bpd.award_period.service.AwardPeriodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BpdAwardPeriodControllerImpl.class})
@AutoConfigureMockMvc(secure = false)
@EnableWebMvc
public class BpdAwardPeriodControllerImplTest {

    @Autowired
    protected MockMvc mvc;
    protected ObjectMapper objectMapper = new ArchConfiguration().objectMapper();

    LocalDate CURRENT_DATE = LocalDate.now(ZoneOffset.UTC);
    @MockBean
    private AwardPeriodService awardPeriodServiceMock;
    @SpyBean
    private AwardPeriodResourceAssembler awardPeriodResourceAssemblerMock;

    @PostConstruct
    public void configureTest() {
        AwardPeriod foundAwardPeriod = new AwardPeriod();
        foundAwardPeriod.setAwardPeriodId(0L);
        foundAwardPeriod.setEnabled(true);

        AwardPeriod awardPeriod = new AwardPeriod();
        awardPeriod.setEnabled(true);
        awardPeriod.setAwardPeriodId(0L);
        List<AwardPeriod> awardPeriodList = new ArrayList<>();
        awardPeriodList.add(awardPeriod);

        doReturn(foundAwardPeriod).when(awardPeriodServiceMock).find(eq(0L));
        doReturn(awardPeriodList).when(awardPeriodServiceMock).findAll(Mockito.any());

    }

    @Test
    public void find() throws Exception {
        MvcResult result = (MvcResult) mvc.perform(MockMvcRequestBuilders
                .get("/bpd/award-periods/0")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        AwardPeriodResource awardPeriodResource = objectMapper.readValue(result.getResponse().getContentAsString(),
                AwardPeriodResource.class);
        assertNotNull(awardPeriodResource);
        verify(awardPeriodServiceMock).find(eq(0L));
        verify(awardPeriodResourceAssemblerMock).toResource(any(AwardPeriod.class));
    }

    @Test
    public void find_nullCase() throws Exception {
        MvcResult result = (MvcResult) mvc.perform(MockMvcRequestBuilders
                .get("/bpd/award-periods/null")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();

        Mockito.verifyZeroInteractions(awardPeriodServiceMock, awardPeriodResourceAssemblerMock);
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = (MvcResult) mvc.perform(MockMvcRequestBuilders
                .get("/bpd/award-periods")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        List<AwardPeriodResource> awardPeriodResourceList = objectMapper.
                readValue(result.getResponse().
                        getContentAsString(), new TypeReference<List<AwardPeriodResource>>() {
                });

        assertNotNull(awardPeriodResourceList);
        awardPeriodResourceList.stream().forEach(awPeriod -> verify(awardPeriodResourceAssemblerMock)
                .toResource(any(AwardPeriod.class)));

    }

}