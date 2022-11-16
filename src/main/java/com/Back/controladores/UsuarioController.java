package com.Back.controladores;

import com.Back.modelo.Usuario;
import com.Back.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController

@CrossOrigin("http://localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    pdfGenerator pdf = new pdfGenerator();

    @PostMapping("/registros")
    public Usuario guardarUsuario(@RequestBody Usuario newUsuario) throws Exception{
        System.out.println("Usuario a guardar: " + newUsuario.getUsername());
        System.out.println("Usuario a guardar: " + newUsuario.getPassword());
        System.out.println("Usuario a guardar: " + newUsuario.getNombre());
        System.out.println("Usuario a guardar: " + newUsuario.getApellido());
        System.out.println("Usuario a guardar: " + newUsuario.getEmail());
        return usuarioService.guardarUsuario(newUsuario);
    }

    @GetMapping( "/getUser/{id}")
    public Optional<Usuario> getTipoServicioById(@PathVariable("id") Long id) {
        return usuarioService.get(id);
    }

    @GetMapping("/contrato/{id}")
    public void getDocumento(@PathVariable("id") Long id) {
        System.out.println("Usuario a guardar: " + id);
        Usuario usuario = usuarioService.BuscarUsuario(id);
        pdf.Contrato(usuario);
    }

    @GetMapping("/certificado/{id}")
    public void getDocumentoCertificado(@PathVariable("id") Long id) {
        System.out.println("Usuario a guardar: " + id);
        Usuario usuario = usuarioService.BuscarUsuario(id);
        pdf.CertificadoLaboral(usuario);
    }

    @GetMapping("/desprendible/{id}")
    public void getDocumentoDesprendible(@PathVariable("id") Long id) throws FileNotFoundException {
        System.out.println("Usuario a guardar: " + id);
        Usuario usuario = usuarioService.BuscarUsuario(id);
        pdf.DesprendibleNomina(usuario);
    }

    @PostMapping("/todos")
    public List<Usuario> mostrarTodosLosUsuarios(){
        return usuarioService.mostrarTodosLosUsuarios();
    }

    @PutMapping("/actualizar")
    public Usuario actualizar(@RequestBody Usuario acUsuario) throws Exception{
        return usuarioService.Actualizar(acUsuario);
    }



    @DeleteMapping( "/eliminar/{id}")
    public HttpStatus eliminarUsuario(@PathVariable  Long id){
        return usuarioService.eliminarUsuario(id)? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

}
