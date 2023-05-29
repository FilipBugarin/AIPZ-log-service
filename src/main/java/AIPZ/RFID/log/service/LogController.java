package AIPZ.RFID.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {

	@Autowired
	private LogRepository logRepository;

	@Autowired
	private CardRepository cardRepository;

	@PostMapping
	public Log addLog(@RequestBody Log log) {
		return logRepository.save(log);
	}

	@GetMapping
	public List<Log> getAllLogs() {
		return logRepository.findAll();
	}

	@GetMapping("/new/card/{cardId}")
	public boolean addNewCard(@PathVariable String cardId) {
		
		Log l= new Log();
		l.setMessage("Registering new card");
		
		if(cardRepository.findByCardId(cardId) != null) {
			l.setMessage("Card already registered with id:" + cardId);
			return false;
		}
		
		Card c = new Card();
		c.setCardId(cardId);
		l.setMessage("Card registered:" + cardId);
		logRepository.save(l);
		return cardRepository.save(c) != null;
	}
	
	@GetMapping("/check/card/{cardId}")
	public boolean checkCard(@PathVariable String cardId) {
		Log l= new Log();
		l.setMessage("Reqiested access wiht card id:" + cardId);
		logRepository.save(l);
		return cardRepository.findByCardId(cardId) != null;
	}
	
}