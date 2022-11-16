package com.Back.controladores;


import com.Back.configuraciones.JwtAuthenticationFilter;
import com.Back.modelo.JwtRequest;
import com.Back.modelo.Usuario;
import com.Back.repositorios.UsuarioRepository;
import com.Back.servicios.impl.UsuarioServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("unittest")
@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private JwtRequest jwtRequest;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void init(){
        when(usuarioRepository.findById(1l))
                .thenReturn(Optional.of(new Usuario(1l, "prueba","12345", "Sebastian","Soto", "prueba@gmail.com")));
        when(usuarioRepository.findById(1l))
                .thenReturn(Optional.of(new Usuario(2l, "santi","24680", "Santiago","Ruiz", "santi@gmail.com")));
    }
    //PRUEBAS EN EL GET
    @Test
    void mostrarUsuarios() throws Exception{
        MvcResult result=mockMvc.perform(get("/usuarios/todos")).andExpect(status().isOk()).andReturn();
    }

    @Test
    void mostrarUsuarioIdError() throws Exception{
        authenticationController.generarToken(new JwtRequest("santi","24680"));
        MvcResult result = mockMvc.perform(get("/usuarios/getUser/{id}", 1)).andExpect(status().isOk()).andReturn();
        assertEquals("Santi",result.getResponse().getContentAsString());
    }

    @Test
    void mostrarUsuarioIdSuccess() throws Exception{
        authenticationController.generarToken(new JwtRequest("prueba","12345"));
        MvcResult result = mockMvc.perform(get("/usuarios/getUser/{id}", 1)).andExpect(status().isOk()).andReturn();
        assertEquals("prueba",result.getResponse().getContentAsString());
    }
    //PRUEBA EN EL POST
    @Test
    public void  guardarUsuario() throws Exception{
        this.mockMvc
                .perform(
                        post("/usuarios/registros")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"username\": \"prueba\",\"password\": \"12345\",\"nombre\": \"Sebastian\",\"apellido\": \"Soto\",\"email\": \"prueba@gmail.com\"}")
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.containsString("prueba")));
        verify(usuarioService).guardarUsuario(any(Usuario.class));
    }
}