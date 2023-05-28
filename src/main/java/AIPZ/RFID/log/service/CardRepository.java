package AIPZ.RFID.log.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long>{

	public Card findByCardId(String cardId);

}
