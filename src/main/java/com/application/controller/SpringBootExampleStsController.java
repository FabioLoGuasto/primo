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
	
// --------------------- QUERY -------------------------------------	
	
//	----------------- GET ------------------------------------
	
//	// localhost:8080/api/findDipendente/ -----> devo mettere l'ID
//	@GetMapping("/findDipendente/{id}") // -----------------------------> OK
//	public Dipendente getDipendente3(@PathVariable("id")int id) {
//		return this.dipendenteService.findDipendentiById(id);
//	}

//	// localhost:8080/api/findDipendente?id=1  -----------------> OK
//	@GetMapping("/findDipendente") 
//	public Dipendente getDipendente4(@RequestParam("id")int id) {
//		return this.dipendenteService.findDipendentiById(id);
//	}
	
	
	// localhost:8080/api/dammiTuttiDipendentiQuery
	@GetMapping(path ="/dammiTuttiDipendentiQuery", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Dipendente>> dammiTuttiDipendenti(){
		logger.info("dammiTuttiDipendenti");
		try {
			List<Dipendente> risultato = this.dipendenteService.listaDipendenti();
			logger.info("DIPENDENTI: \n", risultato);
			return new ResponseEntity<List<Dipendente>>(risultato, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	// localhost:8080/api/getAgeMore30?eta=30
	@GetMapping(path ="/getAgeMore30", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Dipendente>> getAgeMore30(@RequestParam(value="eta")int eta){
		logger.info("getAgeMore30");
		try {
			List<Dipendente> r = this.dipendenteService.listaDipendentiAgeMore30(eta);
			logger.info("DIPENDENTI: \n", r);
			return new ResponseEntity<List<Dipendente>>(r, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	----------------- POST ------------------------------------
	
//	// localhost:8080/api/addDipendente
//	@PostMapping("/addDipendente") // -----------------------------> SOLO TRAMITE POSTMAN, NON FUNZIONA CON BROWSER
//	public Dipendente addStudent(@RequestBody Dipendente s) {
//		Dipendente nuovo = this.dipendenteService.insertDipendente(s); // il metodo ritorna uno Student quindi lo salvo in una var Student
//		System.out.println(nuovo);
//		return nuovo;
//	}
	
	
	
	
	
//  -------------------------- GUIDA ----------------------------------------------------	
	
	
	
//  -------------------------- CREATE ----------------------------------------------------	
	
	// localhost:8080/api/insertDipendente
  @PostMapping(path ="/insertDipendente", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity <Dipendente> insertDipendente(@RequestBody Dipendente dip){
	  try {
		  Dipendente insertDip = dipendenteService.saveDipendente(dip);
		  return new ResponseEntity<Dipendente>(insertDip, HttpStatus.OK);
	  } catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	  }
      
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
  
  
  
  
  //localhost:8080/api/getOneDipendente/ -----> devo mettere l'ID
	@GetMapping(path ="/getOneDipendente/{id}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity <Dipendente> getOneDipendente(@PathVariable("id")Long id) {
		try {
			Dipendente singleDip = dipendenteService.getDipendenteById(id);
			return new ResponseEntity<Dipendente>(singleDip,HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

	
//localhost:8080/api/getDipendentiByName/ -----> devo mettere l'ID
	@GetMapping(path ="/getDipendentiByName/{nome}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity <List<Dipendente>> getDipendentiByName(@PathVariable("nome")String nome) {
		try {
			List<Dipendente> listaDip = dipendenteService.getDipendentiByName(nome);
			return new ResponseEntity<List<Dipendente>>(listaDip,HttpStatus.OK);
		}catch(Exception e) {
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
