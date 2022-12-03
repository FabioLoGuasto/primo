package com.application.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestBody;

import com.application.error.ApiError;
import com.application.error.NotFoundException;
import com.application.model.Azienda;
import com.application.model.DatoLavorativo;
import com.application.model.Dipendente;
import com.application.model.Generico;
import com.application.service.AziendaService;
import com.application.service.DatoLavorativoService;
import com.application.service.DipendenteService;



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
	
	@Autowired
	AziendaService aziendaService;
	
	@Autowired
	DatoLavorativoService datoLavorativoService;
	
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
	
// --------------------- QUERY GET DIPENDENTE -------------------------------------	
		
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
	

//  -------------------------- INSERT DIPENDENTE ----------------------------------------------------	
	
	/*
	 * aggiungo un dipendente
	 * faccio tornare un nuovo dipedente
	 */
	// localhost:8080/api/insertDipendente
	@PostMapping(path ="/insertDipendente", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Dipendente> insertDipendente(@RequestBody Dipendente dip){
		logger.info("insertDipendente");
		logger.info("@RequestBody:",dip);
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
	 * aggiungo un dipendente tramite payload differente 
	 * faccio tornare un nuovo dipedente che salverò del db
	 */
	// localhost:8080/api/insertDipendenteGenerico
	@PostMapping(path ="/insertDipendenteGenerico", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Dipendente> insertDipendenteGenerico(@RequestBody Generico g){
		logger.info("insertDipendenteGenerico");
		logger.info("@RequestBody:",g);
		try {
			Dipendente insertDipGenerico = dipendenteService.insertDipendenteGenerico(g);
			logger.info("DIPENDENTI: \n", insertDipGenerico);
			return new ResponseEntity<Dipendente>(insertDipGenerico,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("ERROR: \n", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}     
    }
	
	
	
//-------------------------- GET DIPENDENTE ----------------------------------------------------
  
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
	
//-------------------------- UPDATE DIPENDENTE ----------------------------------------------------
	
	/*
	 * update dipendente dato un ID
	 * nella logica di businnes setto l'id dell'url che passo cosi su postman non devo scrivere l'id
	 * fa tutto in automatico
	 */
	  // localhost:8080/api/updateById/1
	 @PutMapping("/updateById/{id}")
	 public ResponseEntity <String> updateDipendente(@PathVariable("id") Long id, @RequestBody Dipendente d) {
		 logger.info("updateById");
		 try { 
			 dipendenteService.updateDipendenti(id,d);
			 logger.info("\n Il dipendente: " + d.getId() + " " + d.getNome() + " " + d.getCognome() + " è stato modificato !!!!");
			 return new ResponseEntity <>("modificato",HttpStatus.OK);
		 }catch(Exception e) {			 
			 logger.error("ERROR: \n", e);
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
     }  
	 
//-------------------------- DELETE DIPENDENTE ----------------------------------------------------
  
	  /* 
	   * Delete one dipendente through id by jpa (@PathVariable)
	   */
	  // localhost:8080/api/deleteById/
	  @DeleteMapping("/deleteById/{id}")
	  public ResponseEntity <String> deleteDipById(@PathVariable("id") Long id) {
		  logger.info("deleteById");
		  try {
			  dipendenteService.deleteDipendentiById(id);
			  logger.info("Dipendente " + id + " eliminato !!!");
			  return new ResponseEntity <>("eliminato",HttpStatus.OK);
		  }catch(Exception e) {
			  logger.error("ERROR: \n", e);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
		  
	  }
	    
// ---------------------------- GET AZIENDA --------------------------------------------------
	  
	  /*
	  *  get list of aziende through jpa
	  */
	  // localhost:8080/api/getAziende
	  @GetMapping(path ="/getAziende", produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<List<Azienda>> getAziende(){ // CREO IL METODO X LA RISPOSTA HTTP
		  logger.info("getAziende");		  
		  try {
			  List<Azienda> res = this.aziendaService.getAllAziende();
			  logger.info("aZIENDE: \n", res);
			  return new ResponseEntity<List<Azienda>>(res, HttpStatus.OK);
			  }catch (Exception e) {				   
				 logger.error("ERROR: \n", e);
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			 }      
	  }

// ---------------------------- INSERT AZIENDA --------------------------------------------------
	  
	  /*
	   * insert new azienda through jpa
	   */
	  // localhost:8080/api/insertAzienda
	  @PostMapping(path ="/insertAzienda", produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity <Azienda> insertAzienda(@RequestBody Azienda az){
		  logger.info("insertAzienda");
		  try {
			  Azienda insertAzienda = aziendaService.saveAzienda(az);
			  logger.info("INSERIMENTO AZIENDA: \n", insertAzienda.getId_azienda(), insertAzienda.getNome_azienda(), insertAzienda.getSede_azienda());
			  return new ResponseEntity<Azienda>(insertAzienda,HttpStatus.CREATED);
		  } catch (Exception e) {
			  logger.error("ERROR: \n", e);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }     
	  }
	  
// ---------------------------- UPDATE AZIENDA --------------------------------------------------	  
	  
	  /*
	   * update azienda dato un ID
	   * nella logica di businnes setto l'id dell'url che passo, cosi su postman non devo scrivere l'id
	   * fa tutto in automatico
	   */
	  // localhost:8080/api/updateAziendaById/1
	  @PutMapping("/updateAziendaById/{id}")
	  public ResponseEntity <String> updateAzienda(@PathVariable("id") Long id, @RequestBody Azienda az) {
		  logger.info("updateAziendaById");
		  try { 
			  aziendaService.updateAzienda(id, az);
			  logger.info("\n L'azienda: " + az.getId_azienda() + " " + az.getNome_azienda() + " " + az.getSede_azienda() + " è stato modificato !!!!");
			  return new ResponseEntity <>("modificato",HttpStatus.OK);
		  }catch(Exception e) {	
			  logger.error("ERROR: \n", e);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		  }
	  } 
	  
// ---------------------------- DELETE AZIENDA --------------------------------------------------	
	  
	  /* 
	   * Delete one azienda through id by jpa (@PathVariable)
	   */
	  // localhost:8080/api/deleteAziendaById/1
	  @DeleteMapping("/deleteAziendaById/{id}")
	  public ResponseEntity <String> deleteAziendaDipById(@PathVariable("id") Long id) {
		  logger.info("deleteAziendaById");
		  try {
			  aziendaService.deleteAziendaById(id);
			  logger.info("L'azienda " + id + " è stata eliminata !!!");
			  return new ResponseEntity <>("eliminata",HttpStatus.OK);
		  }catch(Exception e) {
			  logger.error("ERROR: \n", e);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
	  }
// ---------------------------- GET DATOLAVORATIVO --------------------------------------------------	
	  
	  /*
	   *  get list of dati lavorativi through jpa
	   */
	  // localhost:8080/api/getDatiLavorativi
	  @GetMapping(path ="/getDatiLavorativi", produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<List<DatoLavorativo>> getDatiLavorativi(){ // CREO IL METODO X LA RISPOSTA HTTP
		  logger.info("getDatiLavorativi");
		  try {
			   List<DatoLavorativo> res = this.datoLavorativoService.getAllDatiDipendenti();
			   logger.info("DatoLavorativo: \n", res);
			   return new ResponseEntity<List<DatoLavorativo>>(res, HttpStatus.OK);
			   }catch (Exception e) {	  
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
