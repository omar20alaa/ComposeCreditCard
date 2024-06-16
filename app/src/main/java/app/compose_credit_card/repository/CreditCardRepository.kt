package app.compose_credit_card.repository

import app.compose_credit_card.model.CreditCardResponse
import app.compose_credit_card.service.RetrofitInstance

class CreditCardRepository {

    private val creditCardService = RetrofitInstance.creditCardService
    private val numberOfCard = 10

    suspend fun getCreditCardList(): List<CreditCardResponse> {
        return creditCardService.getCreditCards(numberOfCard)
    }


}