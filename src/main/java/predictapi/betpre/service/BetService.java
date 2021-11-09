package predictapi.betpre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import predictapi.betpre.domain.Bet;
import predictapi.betpre.repository.BetRepository;



@Service
public class BetService {
	@Autowired
	BetRepository betRepo;
	
	public List<Bet> findAllb(){
		return (List<Bet>) betRepo.findAll();
		
	
	}
	
	public Bet save(Bet bet) {
		return betRepo.save(bet);
		
	}
	
	public Bet findById(long id) {
		return betRepo.findById(id).get();
	}
	
	public void delete(long id) {
		betRepo.deleteById(id);
	}

	public void delete(Bet bet) {
		// TODO Auto-generated method stub
		betRepo.delete(bet);
		
	}
	

}
