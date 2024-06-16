package app.compose_credit_card.service

import app.compose_credit_card.model.CreditCardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CreditCardService {


    @GET("credit_cards")
    suspend fun getCreditCards(
        @Query("size") size: Int
    ): List<CreditCardResponse>

}