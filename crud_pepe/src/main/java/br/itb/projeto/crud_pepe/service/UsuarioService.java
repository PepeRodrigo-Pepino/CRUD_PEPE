package br.itb.projeto.crud_pepe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.crud_pepe.model.entity.Usuario;
import br.itb.projeto.crud_pepe.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado."));
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario usuario) {
        Usuario existente = buscarPorId(id);

        existente.setNome(usuario.getNome());
        existente.setUsername(usuario.getUsername());
        existente.setStatusUsuario(usuario.getStatusUsuario());

        return repository.save(existente);
    }

    public void excluir(Integer id) {
        Usuario usuario = buscarPorId(id);
        repository.delete(usuario);
    }
}
