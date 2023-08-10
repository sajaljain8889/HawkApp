package com.jwt.test.Controller;

import com.jwt.test.Service.interface_s.AuthService;
import com.jwt.test.entity.Card;
import com.jwt.test.dto.requestBody.CardRequestBody;
import com.jwt.test.dto.requestBody.UpdateCardRequestBody;
import com.jwt.test.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

   @Autowired
   private AuthService authService;

    @PostMapping("/addCardDetails")
    public ResponseEntity<Card> addCardDetails(@RequestBody CardRequestBody cardRequestBody){
                Card card=cardService.createCardDetail(cardRequestBody);
                return new ResponseEntity<>(card,HttpStatus.CREATED);
    }

    @GetMapping("/allCards")
    public ResponseEntity<List<Card>> getAllCardDetails(@RequestHeader("Authorization") String authorizationHeader){
        String token = authorizationHeader.replace("Bearer ", "");

        if (authService.validateToken(token)) {
            List<Card> cards= cardService.fetchAllCardDetails();
            return ResponseEntity.ok(cards);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/getCardById/{id}")
    public ResponseEntity<Card> getCardById(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String id){
        String token = authorizationHeader.replace("Bearer ", "");
        if (authService.validateToken(token)) {
            Card card=cardService.getCardById(id);
            return ResponseEntity.ok(card);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/updateCard/{id}")
    public Card updateCardDetails(@PathVariable String id, @RequestBody UpdateCardRequestBody updateCardRequestBody){
        return cardService.updateCardDetails(id,updateCardRequestBody);
    }

    @DeleteMapping("/deleteCard/{id}")
    public String deleteCardDetails(@PathVariable String id){
        return cardService.deleteCardbyId(id);
    }
}
