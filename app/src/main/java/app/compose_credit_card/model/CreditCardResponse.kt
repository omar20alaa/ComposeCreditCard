package app.compose_credit_card.model

data class CreditCardResponse(
    val id: Int,
    val uid: String,
    val credit_card_number: String,
    val credit_card_expiry_date: String,
    val credit_card_type: String,
)