package AIPZ.RFID.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {

   @Autowired
   private LogRepository logRepository;

   @PostMapping
   public Log addLog(@RequestBody Log log) {
      return logRepository.save(log);
   }

   @GetMapping
   public List<Log> getAllLogs() {
      return logRepository.findAll();
   }
}