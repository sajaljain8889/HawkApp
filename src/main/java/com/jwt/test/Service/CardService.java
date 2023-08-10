package com.jwt.test.Service;

import com.jwt.test.entity.Card;
import com.jwt.test.dto.requestBody.CardRequestBody;
import com.jwt.test.dto.requestBody.UpdateCardRequestBody;

import java.util.List;
import java.util.Optional;

public interface CardService{

    Card createCardDetail(CardRequestBody cardRequestBody);

    List<Card> fetchAllCardDetails();

    Card getCardById(String id);

    Card updateCardDetails(String id, UpdateCardRequestBody updateCardRequestBody);

    String deleteCardbyId(String id);
}
