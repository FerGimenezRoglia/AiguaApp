package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.model.Anomaly;
import com.aigua.aiguaapp.service.AnomalyService;

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

class AnomalyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AnomalyService service;

    @InjectMocks
    private AnomalyController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllAnomalies() throws Exception {
        when(service.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/anomalies"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}