package com.Back.controladores;

import com.Back.modelo.Usuario;
import com.Back.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin("http://localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registros")
    public Usuario guardarUsuario(@RequestBody Usuario newUsuario) throws Exception{
        System.out.println("Usuario a guardar: " + newUsuario.getUsername());
        System.out.println("Usuario a guardar: " + newUsuario.getPassword());
        System.out.println("Usuario a guardar: " + newUsuario.getNombre());
        System.out.println("Usuario a guardar: " + newUsuario.getApellido());
        System.out.println("Usuario a guardar: " + newUsuario.getEmail());

        return usuarioService.guardarUsuario(newUsuario);
    }


    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
