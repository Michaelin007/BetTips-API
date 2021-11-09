package predictapi.betpre.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import predictapi.betpre.domain.Bet;
import predictapi.betpre.service.BetService;



@RestController
@RequestMapping("/api")
public class BetController {
	
	@Autowired
	BetService betService;
	
	//Get all bet post
	@GetMapping("/bet-day")
	public List<Bet> getToday (){
		
		return betService.findAllb();
		
	}
	
	//creating new bet post
	@PostMapping("/betp")
	public Bet createBet(@Valid @RequestBody Bet bet) {
		
		return betService.save(bet);
		
	}
	
	//Get a Single Bet
	@GetMapping("/bet/{id}")
	public Bet getBetId(@PathVariable(value="id") Long betId) {
		return betService.findById(betId);
				
		   
	}
	
	//updatebet
	@PutMapping("/bett/{id}")
	public Bet updateBB(@PathVariable(value="id")Long betId, @Valid @RequestBody Bet betdetails ) {
		Bet bet= betService.findById(betId);
		bet.setTips(betdetails.getTips());
		
		Bet uBet = betService.save(bet);
		
		return uBet;
	}
	
	//delete bet
	@DeleteMapping("/bet/{id}")
	public ResponseEntity <?> deleteNote(@PathVariable (value="id") Long betid){
		Bet bet= betService.findById(betid);
		betService.delete(bet);
		return ResponseEntity.ok().build();
		
	
		
	}
	

	
	
	
	

}
