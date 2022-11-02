package com.Back.servicios;

import com.Back.modelo.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario Actualizar (Usuario usuario );

    public List<Usuario> mostrarTodosLosUsuarios ();
    public boolean eliminarUsuario(Long id);
    public Optional<Usuario> get(Long id);

    public Usuario BuscarUsuario(Long id);


}
