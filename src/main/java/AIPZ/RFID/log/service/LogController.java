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

	@GetMapping("/access/{password}")
	public boolean getAccess(@PathVariable String password) {
		return password.equals("Filip");
	}

	@GetMapping("/new/card/{cardId}")
	public boolean addNewCard(@PathVariable String cardId) {
		Card c = new Card();
		c.setCardId(cardId);
		return cardRepository.save(c) != null;
	}
	
	@GetMapping("/check/card/{cardId}")
	public boolean checkCard(@PathVariable String cardId) {
		return cardRepository.findByCardId("Filip") != null;
	}
	
}