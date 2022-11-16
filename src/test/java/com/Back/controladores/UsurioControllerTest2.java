package com.Back.controladores;


import com.Back.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsurioControllerTest2 extends AbstractTest{

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void getUsuariosList() throws Exception{
        String uri= "/usuarios/todos";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Usuario[] usuarios = super.mapFromJson(content, Usuario[].class);
        assertTrue(usuarios.length>0);
    }
    @Test
    public void agregarUsuario() throws Exception {
        String uri = "/usuarios/registros";
        Usuario usuario = new Usuario();
        usuario.setId(18l);
        usuario.setUsername("juan");
        usuario.setPassword("98765");
        usuario.setNombre("Juanes");
        usuario.setApellido("Rodriguez");
        usuario.setEmail("juan@gmail.com");
        String inputJson = super.maptoJson(usuario);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "usuario se creo correctamente");
    }
    @Test
    public void updateProduct() throws Exception {
        String uri = "/usuarios/actualizar";
        Usuario usuario = new Usuario();
        usuario.setId(4l);
        usuario.setUsername("cami");
        usuario.setPassword("13579");
        usuario.setNombre("Camila");
        usuario.setApellido("Perez");
        usuario.setEmail("cami@gmail.com");
        String inputJson = super.maptoJson(usuario);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "El usuario se actualizo correctamente");
    }
    @Test
    public void deleteUsuario() throws Exception {
        String uri = "/usuarios/eliminar/18";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Usuario eliminado correctamente");
    }
}
