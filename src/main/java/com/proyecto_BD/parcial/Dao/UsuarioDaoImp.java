package com.proyecto_BD.parcial.Dao;

import com.proyecto_BD.parcial.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query="from Usuario";
        
        List<Usuario> resultado = entityManager.createQuery(query).getResultList();

        
        return resultado;


    }

	@Override
	public void eliminar(Long id) {
		Usuario usuario=entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		
		
	}

	@Override
	public void registrar(Usuario usuario) {
		entityManager.merge(usuario);
		
	}

	@Override
	public boolean verificarCredencial(Usuario usuario) {
		String query="from Usuario WHERE email= :email AND password= :password";
		List<Usuario> lista= entityManager.createQuery(query).setParameter("email",usuario.getEmail()).setParameter("password", usuario.getPassword()).getResultList();
		if (lista.isEmpty()){
			return false;
		}else {
			return true;
		}
	}


}
