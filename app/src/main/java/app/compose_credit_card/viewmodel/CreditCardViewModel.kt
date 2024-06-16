package app.compose_credit_card.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.compose_credit_card.model.CreditCardResponse
import app.compose_credit_card.repository.CreditCardRepository
import kotlinx.coroutines.launch


class CreditCardViewModel : ViewModel() {

    private val repository = CreditCardRepository()
    private val _creditCards = MutableLiveData<List<CreditCardResponse>>()
    val creditCards: LiveData<List<CreditCardResponse>> = _creditCards


    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCardList()
                _creditCards.value = cards
            } catch (_: Exception) { }
        }
    }


}