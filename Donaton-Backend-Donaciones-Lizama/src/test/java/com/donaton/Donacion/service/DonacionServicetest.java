package com.donaton.Donacion.service;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.repository.DonacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DonacionServicetest {

    @Mock
    private DonacionRepository donacionRepository;

    @InjectMocks
    private DonacionService donacionService;

    @Test
    void registrarDonacion_Exito() {
        DonacionRequestDTO dto = new DonacionRequestDTO();
        dto.setTipo("Alimentos");
        dto.setRecurso("Arroz (Kilos)");
        dto.setCantidad(5);
        dto.setTipoDonante("PERSONA");

        Donacion donacionMock = new Donacion();
        donacionMock.setId(1L);
        donacionMock.setRecurso("Arroz (Kilos)");

        when(donacionRepository.save(any(Donacion.class))).thenReturn(donacionMock);

        Donacion resultado = donacionService.registrarDonacion(dto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Arroz (Kilos)", resultado.getRecurso());
        verify(donacionRepository, times(1)).save(any(Donacion.class));
    }

    @Test
    void obtenerTodas_RetornaLista() {
        when(donacionRepository.findAll()).thenReturn(Arrays.asList(new Donacion(), new Donacion()));

        List<Donacion> lista = donacionService.obtenerTodas();

        assertEquals(2, lista.size());
        verify(donacionRepository, times(1)).findAll();
    }
}