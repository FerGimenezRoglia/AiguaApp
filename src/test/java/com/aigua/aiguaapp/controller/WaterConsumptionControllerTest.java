package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.service.WaterConsumptionService;
import com.aigua.aiguaapp.model.WaterConsumption;
import com.aigua.aiguaapp.dto.SummaryDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class WaterConsumptionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WaterConsumptionService service;

    @InjectMocks
    private WaterConsumptionController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAll() throws Exception {
        when(service.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/consumption"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void testGetSummary() throws Exception {
        when(service.calculateSummary()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/consumption/summary"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}