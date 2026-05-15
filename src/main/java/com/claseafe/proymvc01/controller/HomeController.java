package com.claseafe.proymvc01.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.claseafe.proymvc01.service.ITripService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.LinkedList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.claseafe.proymvc01.model.Trip;

@Controller
public class HomeController {
	
	@Autowired
	private ITripService tripService;
	
	@GetMapping ("/")
	public String mostrarHome (Model model) {
	
			List<Trip> lista = tripService.buscarTodos();
			model.addAttribute("trips", lista);
			
			return "home";
			
	}
		
	@GetMapping ("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip= new Trip();
		trip.setNombre ("Rapel en Volcatenando");
		trip.setDescripcion("Aventa rapel en un circuito conectado en las ...");
		trip.setFecha (new Date());
		trip.setCosto (10.0);
		model.addAttribute("trip", trip);
		
		return "detalle";
	}
	
	
	
	@GetMapping ("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("En la Montaña");
		lista.add("En la Ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		model.addAttribute("listadoTrips", lista);
		
		return "listado";
	}
	
	@GetMapping ("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = tripService.buscarPorId(idTrip);
		System.out.println("ID de Trip es: "+idTrip);
		model.addAttribute("trip",trip);
		
		return "detalle";
	}
	
}
	


