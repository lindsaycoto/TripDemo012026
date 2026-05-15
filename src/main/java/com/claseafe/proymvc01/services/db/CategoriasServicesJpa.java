package com.claseafe.proymvc01.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.claseafe.proymvc01.repository.CategoriaRepository;
import com.claseafe.proymvc01.model.Categoria;
import com.claseafe.proymvc01.service.ICategoriaService;

@Service
@Primary
public class CategoriasServicesJpa implements ICategoriaService {

	@Autowired
	private CategoriaRepository repoCategoria;

	@Override
	public List<Categoria> buscarTodas() {
		return repoCategoria.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {

		Optional<Categoria> optional = repoCategoria.findById(idCategoria);

		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategoria.save(categoria);
	}
	
	@Override
	public void eliminar(Integer idCategoria) {
	    repoCategoria.deleteById(idCategoria);
	}

}