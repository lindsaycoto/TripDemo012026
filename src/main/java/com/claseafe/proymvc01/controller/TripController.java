package com.claseafe.proymvc01.controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.claseafe.proymvc01.service.ICategoriaService;
import com.claseafe.proymvc01.services.db.TripServiceJpa;
import com.claseafe.proymvc01.model.Trip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder; 
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

	
@Controller
@RequestMapping("/trips")
public class TripController {
	
    
    @Autowired
    private TripServiceJpa servicesTrip;
    
    @Autowired
    private ICategoriaService serviceCategorias;
    
    @GetMapping("/create")
    public String crear(Trip trip, Model model) {
    	model.addAttribute("categorias", serviceCategorias.buscarTodas());
    	
    	return "trips/formTrip";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idTrip, Model model) {
      
        return "redirect:/trips";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {

        Trip trip = servicesTrip.buscarPorId(idTrip);
        System.out.println("IdTrip es " + idTrip);

        model.addAttribute("trip", trip);

        return "detalle";
    }
    
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("trips", servicesTrip.buscarTodos());
        return "trips/listTrips";
    } 
    
    
    @PostMapping("/save")
    public String guardar (Trip trip, BindingResult result, RedirectAttributes attributes){
    	
    	if (result.hasErrors()) {
    		for (ObjectError error: result.getAllErrors()) {
    			System.out.println(error.getDefaultMessage());
    		}
    		
    		return "trips/formTrip";
    	}
    	
    	System.out.println("Objeto Trip: " + trip);
    	servicesTrip.guardar(trip);
    	attributes.addFlashAttribute ("msg", "Registro Guardado");
    	
    	return "redirect:/trips/index";
    	
    	
    }
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idTrip, Model model) {

        Trip trip = servicesTrip.buscarPorId(idTrip);

        model.addAttribute("trip", trip);
        model.addAttribute("categorias", serviceCategorias.buscarTodas());

        return "trips/formTrip";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idTrip, RedirectAttributes attributes) {

        servicesTrip.eliminar(idTrip);
        attributes.addFlashAttribute("msg", "Trip eliminado");

        return "redirect:/trips/index";
    }

}
