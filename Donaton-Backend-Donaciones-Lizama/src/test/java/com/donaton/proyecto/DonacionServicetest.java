package com.donaton.proyecto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.donaton.Donacion.dto.DonacionRequestDTO;
import com.donaton.Donacion.model.Donacion;
import com.donaton.Donacion.model.DonacionEmpresa;
import com.donaton.Donacion.model.DonacionPersona;
import com.donaton.Donacion.repository.DonacionRepository;
import com.donaton.Donacion.service.DonacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class DonacionServicetest {

    @Mock
    private DonacionRepository donacionRepository;

    @InjectMocks
    private DonacionService donacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarDonacionEmpresa_UsaFactoryCorrectamente() {
        // Arrange: Preparamos el DTO de entrada
        DonacionRequestDTO request = new DonacionRequestDTO();
        request.setTipoDonante("EMPRESA");
        request.setRut("76.555.444-3");
        request.setNombreRazonSocial("Empresa Tech Limitada");
        request.setTipo("Alimentos");
        request.setCantidad(500);

        // Simulamos la entidad que retornaría la base de datos
        DonacionEmpresa mockDonacion = new DonacionEmpresa();
        mockDonacion.setRazonSocial("Empresa Tech Limitada");
        mockDonacion.setCantidad(500);

        when(donacionRepository.save(any(Donacion.class))).thenReturn(mockDonacion);

        // Act: Ejecutamos el servicio
        Donacion resultado = donacionService.registrarDonacion(request);

        // Assert: Verificamos que el Factory haya instanciado la clase hija correcta
        assertNotNull(resultado);
        assertTrue(resultado instanceof DonacionEmpresa, "El Factory debió crear una instancia de DonacionEmpresa");
        assertEquals("Empresa Tech Limitada", ((DonacionEmpresa) resultado).getRazonSocial());
        verify(donacionRepository, times(1)).save(any(Donacion.class));
    }

    @Test
    void testRegistrarDonacionPersona_UsaFactoryCorrectamente() {
        // Arrange
        DonacionRequestDTO request = new DonacionRequestDTO();
        request.setTipoDonante("PERSONA");
        request.setRut("19.123.456-7");
        request.setNombreRazonSocial("Juan Perez");
        request.setCantidad(50);

        DonacionPersona mockDonacion = new DonacionPersona();
        mockDonacion.setNombreCompleto("Juan Perez");

        when(donacionRepository.save(any(Donacion.class))).thenReturn(mockDonacion);

        // Act
        Donacion resultado = donacionService.registrarDonacion(request);

        // Assert
        assertNotNull(resultado);
        assertTrue(resultado instanceof DonacionPersona);
        assertEquals("Juan Perez", ((DonacionPersona) resultado).getNombreCompleto());
        verify(donacionRepository, times(1)).save(any(Donacion.class));
    }

    @Test
    void testObtenerTodasLasDonaciones() {
        when(donacionRepository.findAll()).thenReturn(Arrays.asList(new DonacionEmpresa(), new DonacionPersona()));
        List<Donacion> lista = donacionService.obtenerTodas();
        assertEquals(2, lista.size());
        verify(donacionRepository, times(1)).findAll();
    }
}