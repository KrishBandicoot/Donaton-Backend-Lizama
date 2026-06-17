package com.donaton.donacion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.donaton.donacion.model.DonacionEmpresa;
import com.donaton.donacion.repository.DonacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DonacionServiceTest {

    @Mock
    private DonacionRepository donacionRepository;

    @InjectMocks
    private DonacionService donacionService;

    @Test
    public void testGuardarDonacionEmpresa() {
        DonacionEmpresa empresa = new DonacionEmpresa();
        empresa.setMonto(500000.0);
        empresa.setRazonSocial("TechCorp Limitada");

        when(donacionRepository.save(empresa)).thenReturn(empresa);

        DonacionEmpresa resultado = (DonacionEmpresa) donacionService.guardarDonacion(empresa);
        
        assertEquals("TechCorp Limitada", resultado.getRazonSocial());
        assertEquals(500000.0, resultado.getMonto());
    }
}