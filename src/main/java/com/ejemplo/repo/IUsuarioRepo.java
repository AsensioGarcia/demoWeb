package com.ejemplo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer>{
	
	//Puedo añadir una funcion nueva a la interfaz para buscar por nombre, solo con poner esto:
	Usuario findByNombre(String Nombre);
}
