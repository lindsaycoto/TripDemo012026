	package com.claseafe.proymvc01.service;
	
	import java.util.List;
	import java.util.LinkedList;
	import org.springframework.stereotype.Service;
	import com.claseafe.proymvc01.model.Categoria;
	
	@Service
	public class CategoriasServiceImpl implements ICategoriaService {
	
	    private List<Categoria> lista = null;
	    public CategoriasServiceImpl() {
	    	lista=new LinkedList<Categoria>();
	    	
	    	Categoria categoria1 = new Categoria();
	    	categoria1.setId(1);
	    	categoria1.setNombre("En la playa");
	    	categoria1.setDescripcion ("Servicios de entretenimiento de playa");
	    	
	    	Categoria categoria2 = new Categoria();
	    	categoria2.setId(2);
	    	categoria2.setNombre("En la ciudad");
	    	categoria2.setDescripcion ("Clasificación de trips en la ciudad");
	    	
	    	Categoria categoria3 = new Categoria();
	    	categoria3.setId(3);
    	categoria3.setNombre("En la montaña");
    	categoria3.setDescripcion ("Interesantes actividades en montañas...");
    	
    	lista.add(categoria1);
    	lista.add(categoria2);
    	lista.add(categoria3);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria categoria : lista) {
        	if (categoria.getId().equals(idCategoria)) {

                return categoria;
            
            }}
        return null;
    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}
}