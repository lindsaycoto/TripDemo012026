package com.claseafe.proymvc01.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.claseafe.proymvc01.model.Trip;

@Service
public class TripServiceImpl implements ITripService {

    private List<Trip> lista;

    public TripServiceImpl() {
        lista = getTrip();  
    }

    @Override
    public List<Trip> buscarTodos() {
        return lista;
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {

        for (Trip trip : lista) {
            if (trip.getId()==idTrip) {
                return trip;
            }
        }

        return null;
    }
    
    @Override
    public void guardar (Trip trip) {
    	lista.add(trip);
    }

    private List<Trip> getTrip() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Trip> lista = new LinkedList<>();

        try {

            	Trip trip1 = new Trip();
            	trip1.setId(1);
            	trip1.setNombre("Rapel en Volcatenando");
            	trip1.setDescripcion("Hacer rapel en los circuitos del Volcatenando");
            	trip1.setFecha(sdf.parse("10-05-2022"));
            	trip1.setCosto(5.0);
            	trip1.setDestacado(1);
            	trip1.setCalificacion(5);
            	trip1.setImagen("trip01.png");
				
				Trip trip2=new Trip();
				trip2.setId(2);
				trip2.setNombre ("Deslizadero en El Picnic");
				trip2.setDescripcion ("Deslizarte en un divertido tobogan sobre la colina");
				trip2.setFecha (sdf.parse ("10-05-2022"));
				trip2.setCosto (5.0);
				trip2.setDestacado(1);
				trip2.setCalificacion(3);
				trip2.setImagen("trip02.png");
				
				Trip trip3=new Trip();
				trip3.setId(3);
				trip3.setNombre ("Comida y flores");
				trip3.setDescripcion ("Disfrutar en un amplio jardin en el cual podras comprar");
				trip3.setFecha (sdf.parse ("10-05-2022"));
				trip3.setCosto (1.0);
				trip3.setDestacado(0);
				trip3.setCalificacion(7);
				trip3.setImagen("tirp03.png");
				
				Trip trip4=new Trip();
				trip4.setId (4);
				trip4.setNombre ("Caminatas");
				trip4.setDescripcion ("Disfruta hacer senderismo por las montañas chalatecas");
				trip4.setFecha (sdf.parse ("01-02-2022"));
				trip4.setCosto (1.0);
				trip4.setDestacado(1);
				trip4.setCalificacion(10);
				
				Trip trip5 = new Trip();
				trip5.setId(5);
				trip5.setNombre("Tour en bicicleta extrema");
				trip5.setDescripcion("Recorrido extremo por senderos naturales");
				trip5.setFecha(sdf.parse("12-03-2022"));
				trip5.setCosto(3.0);
				trip5.setDestacado(1);
				trip5.setCalificacion(4);

				Trip trip6 = new Trip();
				trip6.setId(6);
				trip6.setNombre("Camping nocturno");
				trip6.setDescripcion("Noche bajo las estrellas en la montaña");
				trip6.setFecha(sdf.parse("15-04-2022"));
				trip6.setCosto(4.0);
				trip6.setDestacado(0);
				trip6.setCalificacion(6);

				Trip trip7 = new Trip();
				trip7.setId(7);
				trip7.setNombre("Surf en la playa");
				trip7.setDescripcion("Clases básicas de surf en la playa");
				trip7.setFecha(sdf.parse("20-06-2022"));
				trip7.setCosto(8.0);
				trip7.setDestacado(1);
				trip7.setCalificacion(5);
				
				lista.add(trip1);
				lista.add(trip2);
				lista.add(trip3);
				lista.add(trip4);
				lista.add(trip5);
				lista.add(trip6);
				lista.add(trip7);
			
			
			}
        catch (ParseException e) {
            System.out.println(e.getMessage());

        return lista;
        }
		return lista;
    
    }

	@Override
	public void eliminar(Integer idTrip) {
		// TODO Auto-generated method stub
		
	}
    }