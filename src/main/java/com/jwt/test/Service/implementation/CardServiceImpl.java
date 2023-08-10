package com.jwt.test.Service.implementation;

import com.jwt.test.Repository.CardRepository;
import com.jwt.test.entity.Card;
import com.jwt.test.dto.requestBody.CardRequestBody;
import com.jwt.test.dto.requestBody.UpdateCardRequestBody;
import com.jwt.test.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    public Card createCardDetail(CardRequestBody cardRequestBody) {
        Card card= new Card();
        card.setId(UUID.randomUUID().toString().split("-")[0]);
        card.setCardNumber(cardRequestBody.getCardNumber());
        card.setNameOnCard(cardRequestBody.getNameOnCard());
        card.setTypeOfCard(cardRequestBody.getTypeOfCard());
        card.setCvv(cardRequestBody.getCvv());
        card.setExpMM(cardRequestBody.getExpMM());
        card.setExpYY(cardRequestBody.getExpYY());
        card.setName(cardRequestBody.getName());
        card.setNumber(cardRequestBody.getNumber());
        card.setAddress(cardRequestBody.getAddress());

        card.setCreatedAt(new Date());
        card.setUpdatedAt(new Date());
        return cardRepository.save(card);
    }

    public List<Card> fetchAllCardDetails() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    public Card getCardById(String id) {
        Card card = cardRepository.findById(id).get();
        return card;
    }

    public Card updateCardDetails(String id, UpdateCardRequestBody updateCardRequestBody) {
        Card card=cardRepository.findById(id).get();
        card.setCardNumber(updateCardRequestBody.getCardNumber());
        card.setNameOnCard(updateCardRequestBody.getNameOnCard());
        card.setTypeOfCard(updateCardRequestBody.getTypeOfCard());
        card.setCvv(updateCardRequestBody.getCvv());
        card.setExpMM(updateCardRequestBody.getExpMM());
        card.setExpYY(updateCardRequestBody.getExpYY());
        card.setAddress(updateCardRequestBody.getAddress());
        card.setName(updateCardRequestBody.getName());
        card.setNumber(updateCardRequestBody.getNumber());
        card.setUpdatedAt(new Date());
        return cardRepository.save(card);
    }

    @Override
    public String deleteCardbyId(String id) {
        Card card = cardRepository.findById(id).get();
        if(cardRepository.existsById(id)){
            cardRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "Card Doesn't Exist" ;
    }
}
