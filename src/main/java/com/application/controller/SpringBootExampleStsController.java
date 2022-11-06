package com.application.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.error.ApiError;
import com.application.error.NotFoundException;
import com.application.model.Dipendente;
import com.application.service.DipendenteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


/**
 * 
 * @author dmasone
 * @implSpec class used for map API endPoint
 *
 */
@RestController
@RequestMapping(value = "/api")
public class SpringBootExampleStsController {
	
	public static final Logger logger = LoggerFactory.getLogger(SpringBootExampleStsController.class);
	
	@Autowired
	DipendenteService dipendenteService;
	
	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Welcome";
	}

	
	/*@Value("${api.path}")
	private String apiPath;
	@Value("${api.key}")
	private String apiKey;*/
	
	
	/**
	 * 
	 * @return Test for check webApp works on
	 */
	@RequestMapping("/")
	public String index() {
		return "IT WORKS!!";
	}
	
//	----------------- GET ------------------------------------
	
	// localhost:8080/api/findDipendente/ -----> devo mettere l'ID
	@GetMapping("/findDipendente/{id}") // -----------------------------> OK
	public Dipendente getDipendente3(@PathVariable("id")int id) {
		return this.dipendenteService.findDipendentiById(id);
	}

	// localhost:8080/api/findDipendente?id=1  -----------------> OK
	@GetMapping("/findDipendente") 
	public Dipendente getDipendente4(@RequestParam("id")int id) {
		return this.dipendenteService.findDipendentiById(id);
	}
	
//	----------------- POST ------------------------------------
	
	// localhost:8080/api/addDipendente
	@PostMapping("/addDipendente") // -----------------------------> SOLO TRAMITE POSTMAN, NON FUNZIONA CON BROWSER
	public Dipendente addStudent(@RequestBody Dipendente s) {
		Dipendente nuovo = this.dipendenteService.insertDipendente(s); // il metodo ritorna uno Student quindi lo salvo in una var Student
		System.out.println(nuovo);
		return nuovo;
	}
	
//  -------------------------- GUIDA ----------------------------------------------------	
//  -------------------------- CREATE ----------------------------------------------------	
	// localhost:8080/api/dipendenteSave
  @PostMapping("/dipendenteSave")
  public Dipendente saveDepartment(
      @Valid @RequestBody Dipendente dipendente) {
      return dipendenteService.saveDepartment(dipendente);
  }
	
	
//-------------------------- GET ----------------------------------------------------
// localhost:8080/api/getDipendenti
  @GetMapping(path ="/getDipendenti", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Dipendente>> getDipendenti(){ // CREO IL METODO X LA RISPOSTA HTTP
	  logger.info("GetDipendenti");
	try {
		List<Dipendente> res = this.dipendenteService.getAllDipendenti();
		logger.info("DIPENDENTI: \n", res);
		return new ResponseEntity<List<Dipendente>>(res, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}      
  }   

//-------------------------- UPDATE ----------------------------------------------------
  // localhost:8080/api/updateById/1
  @PutMapping("/updateById/{id}")
  public Dipendente updateDepartment(@RequestBody Dipendente d, @PathVariable("id") int id) {
      return dipendenteService.updateDipendenti(d, id);
  }
	
	
  
//-------------------------- DELETE ----------------------------------------------------
  // localhost:8080/api/deleteById/
  @DeleteMapping("/deleteById/{id}")
  public String deleteDipById(@PathVariable("id") int id) {
  	dipendenteService.deleteDipendentiById(id);
      return "Deleted Successfully";
  }
  
  
  
  
//  --------------------------- METODO CON ECCEZIONE --------------------------------------    
  
  
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiError HandleNoSuchElementException(NotFoundException exception, HttpServletRequest request) {
  	ApiError error = new ApiError(404, exception.getMessage(), request.getServletPath());
  	return error;
  }

}
