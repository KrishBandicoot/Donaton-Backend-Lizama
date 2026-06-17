package com.donaton.Donacion.controller;

import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.service.DonacionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DonacionControllerTest {

    @Mock
    private DonacionService donacionService;

    @InjectMocks
    private DonacionController donacionController;

    @Test
    void listarDonaciones_RetornaListaYEstado200() {
        List<Donacion> mockList = Arrays.asList(new Donacion(), new Donacion());
        when(donacionService.obtenerTodas()).thenReturn(mockList);

        ResponseEntity<List<Donacion>> response = donacionController.listarDonaciones();

        // CORRECCIÓN AQUÍ
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, response.getBody().size());
    }
}