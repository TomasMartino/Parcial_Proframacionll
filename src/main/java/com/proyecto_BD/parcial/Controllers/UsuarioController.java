package com.proyecto_BD.parcial.Controllers;

import com.proyecto_BD.parcial.Dao.UsuarioDao;
import com.proyecto_BD.parcial.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
   
		@Autowired
	    private UsuarioDao usuarioDao;
	
	    /*@RequestMapping(value = "mensaje")
	    public String mensaje(){
	        return "mensaje";
	    }
	    @RequestMapping(value = "listado")
	    public List<String> listarPersonas(){
	        return List.of("Diego", "Juan", "Jose");
	    }
	    @RequestMapping(value = "Usuarios")
	    public List<Usuario> listarUsuarios(){
	        List<Usuario> usuarios= new ArrayList<>();
	
	        Usuario u1 =new Usuario("Tomas","Martino","2612441823","tomasdiamante882@gmail.com","abc");
	        usuarios.add(u1);
	
	        return usuarios;
	    }*/
		
	    @RequestMapping(value = "api/usuario")
	    public List<Usuario> getUsuarios(){
	        return usuarioDao.getUsuarios();
	    }
	    @RequestMapping(value = "api/usuario/{id}", method=RequestMethod.DELETE)
	    public void eliminar(@PathVariable Long id){
	        
	    	usuarioDao.eliminar(id);
	    }
	    @RequestMapping(value = "api/usuario", method=RequestMethod.POST)
	    public void registrarUsuario(@RequestBody Usuario usuario){
	        
	    	 usuarioDao.registrar(usuario);
	    }

    }
    
    	
    
    
    
