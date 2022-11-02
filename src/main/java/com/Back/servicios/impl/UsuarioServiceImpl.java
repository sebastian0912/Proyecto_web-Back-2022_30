package com.Back.servicios.impl;

import com.Back.modelo.Usuario;
import com.Back.repositorios.UsuarioRepository;
import com.Back.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario Actualizar(Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario u: usuarios) {
            if(usuario.getNombre().equals(u.getNombre())){
                u.setNombre(usuario.getNombre());
                u.setEmail(usuario.getEmail());
                u.setPassword(usuario.getPassword());
                u.setApellido(usuario.getApellido());
                u.setUsername(usuario.getUsername());

                //eliminarUsuario(u.getId());
                usuarioRepository.save(u);
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> mostrarTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }
    }

    @Override
    public Optional<Usuario> get(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario BuscarUsuario(Long id) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario u: usuarios) {
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }


}