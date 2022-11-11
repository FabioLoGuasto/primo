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
	
	/*
	 * get list of dipendenti by query
	 */
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
	
	
	/*
	 * get list of dipendenti where age it's more then 30 by query(@RequestParam)
	 */
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
	
	
	
	/*
	 * get list of dipendenti where age it's more then 30 by query(@PathVariable)
	 */
	// localhost:8080/api/getAgeMore30PathValue/30
	@GetMapping(path ="/getAgeMore30PathValue/{eta}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Dipendente>> getAgeMore30PathValue(@PathVariable("eta")int eta){
		logger.info("getAgeMore30PathValue");
		try {
			List<Dipendente> r1 = this.dipendenteService.listaDipendentiAgeMore30PathValue(eta);
			logger.info("DIPENDENTI: \n", r1);
			return new ResponseEntity<List<Dipendente>>(r1, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	/*
	 * get list of dipendenti where age it's beetweek 20 and 30 by query(@RequestParam)
	 */
	// localhost:8080/api/selectNomeBeetweenEta?start=20&end=30
		@GetMapping(path ="/selectNomeBeetweenEta", produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <List<Dipendente>> selectNomeBeetweenEta(@RequestParam(value="start")int start,@RequestParam(value="end")int end){
			logger.info("selectNomeBeetweenEta");
			try {
				List<Dipendente> dipNome2 = this.dipendenteService.findEtaBetween(start,end);
				logger.info("DIPENDENTI: \n", dipNome2);
				return new ResponseEntity<List<Dipendente>>(dipNome2, HttpStatus.OK);
			}catch(Exception e) {
				logger.error("ERROR: \n", e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	
	/*
	 * get list of dipendenti through nome by query(@RequestParam)
	 */
	// localhost:8080/api/findNomeDaQuery?nome=paolo
		@GetMapping(path ="/findNomeDaQuery", produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <List<Dipendente>> findNomeDaQuery(@RequestParam(value="nome")String nome){
			logger.info("findNomeDaQuery");
			try {
				List<Dipendente> dipNome = this.dipendenteService.findNome(nome);
				logger.info("DIPENDENTI: \n", dipNome);
				return new ResponseEntity<List<Dipendente>>(dipNome, HttpStatus.OK);
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
	
	/*
	 * aggiungo un dipendente
	 * faccio tornare un nuovo dipedente
	 */
	// localhost:8080/api/insertDipendente
	@PostMapping(path ="/insertDipendente", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Dipendente> insertDipendente(@RequestBody Dipendente dip){
		logger.info("insertDipendente");
		try {
			Dipendente insertDip = dipendenteService.saveDipendente(dip);
			logger.info("DIPENDENTI: \n", insertDip);
			return new ResponseEntity<Dipendente>(insertDip,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}     
    }
	
	
	/*
	 * aggiungo un dipendente
	 * prova di aggiunta usando un void
	 */
	// localhost:8080/api/insertDipendenteVoid
	@PostMapping(path ="/insertDipendenteVoid", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> insertDipendenteVoid(@RequestBody Dipendente dip){	
		logger.info("insertDipendenteVoid");
		try {
			dipendenteService.saveDipendenteVoid(dip);
			logger.info("DIPENDENTI: \n");
			return new ResponseEntity<String>("inserimento ok", HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}     
    }
	
	
	
//-------------------------- GET ----------------------------------------------------
  
	 /*
	  *  get list of dipendenti 
	  */
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
  
  
  
	/*
	 * get dipendente through id by jpa (@PathVariable)
	 */
	//localhost:8080/api/getOneDipendente/ -----> devo mettere l'ID
	@GetMapping(path ="/getOneDipendente/{id}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity <Dipendente> getOneDipendente(@PathVariable("id")Long id) {		
		logger.info("getOneDipendente");
		try {
			Dipendente singleDip = dipendenteService.getDipendenteById(id);
			logger.info("DIPENDENTI: \n", singleDip);
			return new ResponseEntity<Dipendente>(singleDip,HttpStatus.OK);
		}catch(Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

	/*
	 * get list of dipendenti through nome by jpa (@PathVariable)
	 */
	//localhost:8080/api/getDipendentiByName/ -----> devo mettere l'ID
	@GetMapping(path ="/getDipendentiByName/{nome}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity <List<Dipendente>> getDipendentiByName(@PathVariable("nome")String nome) {
		logger.info("getDipendentiByName");
		try {
			List<Dipendente> listaDip = dipendenteService.getDipendentiByName(nome);
			logger.info("DIPENDENTI: \n", listaDip);
			return new ResponseEntity<List<Dipendente>>(listaDip,HttpStatus.OK);
		}catch(Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}	
	
	

//-------------------------- UPDATE ----------------------------------------------------
	
	/*
	 * update dipendente dato un ID
	 */
	  // localhost:8080/api/updateById/1
	 @PutMapping("/updateById/{id}")
	 public ResponseEntity <String> updateDipendente(@PathVariable("id") Long id, @RequestBody Dipendente d) {
		 logger.info("updateById");
		 try { 
			 dipendenteService.updateDipendenti(d);
			 logger.info("DIPENDENTI: \n");
			 return new ResponseEntity <>("modificato",HttpStatus.OK);
		 }catch(Exception e) {			 
			 logger.error("ERROR: \n", e);
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
     }
	
	
  
//-------------------------- DELETE ----------------------------------------------------
  
	  /* 
	   * Delete one dipendente through id by jpa (@PathVariable)
	   */
	  // localhost:8080/api/deleteById/
	  @DeleteMapping("/deleteById/{id}")
	  public ResponseEntity <String> deleteDipById(@PathVariable("id") Long id) {
		  logger.info("deleteById");
		  try {
			  dipendenteService.deleteDipendentiById(id);
			  logger.info("DIPENDENTI: \n");
			  return new ResponseEntity <>("eliminato",HttpStatus.OK);
		  }catch(Exception e) {
			  logger.error("ERROR: \n", e);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
		  
	  }
  
  
  
  
//  --------------------------- METODO CON ECCEZIONE --------------------------------------    
  
  
	  @ExceptionHandler(NotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public ApiError HandleNoSuchElementException(NotFoundException exception, HttpServletRequest request) {
	  	ApiError error = new ApiError(404, exception.getMessage(), request.getServletPath());
	  	return error;
	  }

}
