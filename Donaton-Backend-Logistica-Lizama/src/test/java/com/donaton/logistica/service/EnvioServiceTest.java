package com.donaton.logistica.service;

import com.donaton.logistica.model.Envio;
import com.donaton.logistica.repository.EnvioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EnvioServiceTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioService envioService;

    @Test
    void registrarEnvio_Exito() {
        Envio envio = new Envio();
        envio.setCentroAcopioOrigen("Gimnasio Maipú");
        envio.setDestino("Zona Cero");
        envio.setPatenteTransporte("POR-ASIGNAR");

        Envio envioGuardado = new Envio();
        envioGuardado.setId(10L);
        envioGuardado.setCentroAcopioOrigen("Gimnasio Maipú");

        when(envioRepository.save(envio)).thenReturn(envioGuardado);

        Envio resultado = envioService.registrarEnvio(envio);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getId());
        assertEquals("Gimnasio Maipú", resultado.getCentroAcopioOrigen());
    }
}
