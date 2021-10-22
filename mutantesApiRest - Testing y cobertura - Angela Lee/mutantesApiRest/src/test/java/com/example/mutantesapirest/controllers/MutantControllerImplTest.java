package com.example.mutantesapirest.controllers;

import com.example.mutantesapirest.MutantesApiRestApplication;
import com.example.mutantesapirest.services.MutantService;
import com.example.mutantesapirest.services.MutantServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes=MutantesApiRestApplication.class)
@WebMvcTest (MutantControllerImpl.class)
public class MutantControllerImplTest {

    @MockBean
    public MutantService serviceTest;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ImplementarControladorMutante() throws Exception {
        String[] cadenaMatriz = {"GGGG", "TCGA", "AAAA", "GCAG"};

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson;

        try {
            requestJson = ow.writeValueAsString(cadenaMatriz);
            when(serviceTest.isMutant(any(String[].class))).thenReturn(true);

            mockMvc.perform(post("/api/mutants/post").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(status().isOk());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void ImplementarControladorMutanteFalso() throws Exception {
        String[] cadenaMatriz = {"GGGG", "TCGA", "AGTA", "GCAG"};

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson;

        try {
            requestJson = ow.writeValueAsString(cadenaMatriz);
            when(serviceTest.isMutant(any(String[].class))).thenReturn(false);

            mockMvc.perform(post("/api/mutants/post").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                    .andExpect(status().isForbidden());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}