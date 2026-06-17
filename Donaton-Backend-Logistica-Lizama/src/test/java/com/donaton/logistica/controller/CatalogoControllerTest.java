package com.donaton.logistica.controller;

import com.donaton.logistica.controller.CatalogoController;
import com.donaton.logistica.model.Catalogo;
import com.donaton.logistica.repository.CatalogoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatalogoControllerTest {

    @Mock
    private CatalogoRepository catalogoRepository;

    @InjectMocks
    private CatalogoController catalogoController;

    @Test
    void obtenerTodos_RetornaListaDeCatalogos() {
        Catalogo cat = new Catalogo();
        cat.setTipoCatalogo("TIPO_AYUDA");
        cat.setValor("Agua");
        when(catalogoRepository.findAll()).thenReturn(Collections.singletonList(cat));

        List<Catalogo> resultado = catalogoController.obtenerTodos();

        assertEquals(1, resultado.size());
        assertEquals("Agua", resultado.get(0).getValor());
    }
}