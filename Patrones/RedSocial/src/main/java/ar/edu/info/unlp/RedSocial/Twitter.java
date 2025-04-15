package ar.edu.info.unlp.RedSocial;
import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(String screenName) {
        boolean existe = usuarios.stream()
                .anyMatch(usuario->usuario.getScreenName().equals(screenName));
        if (!existe) {
            Usuario usuario = new Usuario(screenName);
            usuarios.add(usuario);
        }
    }

    public void eliminarUsuario(Usuario usuarioEliminar) {
        Usuario existe = usuarios.stream()
                .filter(usuario->usuario.equals(usuarioEliminar))
                .findFirst().orElse(null);
        if (existe != null) {
            usuarios.remove(existe);
        }
    }
}
