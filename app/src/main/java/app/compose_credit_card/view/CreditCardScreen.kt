package app.compose_credit_card.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.compose_credit_card.R
import app.compose_credit_card.model.CreditCardResponse
import app.compose_credit_card.viewmodel.CreditCardViewModel


@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {

    val creditCards by viewModel.creditCards.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCards == null) {
            Text(text = stringResource(id = R.string.loading))
        } else {
            CreditCardItem(creditCards!!)
        }
    }
}

@Composable
fun CreditCardItem(items: List<CreditCardResponse>) {

    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn {
                items(items) { item ->
                    Text(
                        text = item.credit_card_number,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = stringResource(R.string.expiry_date, item.credit_card_expiry_date),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = item.credit_card_type,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(Modifier.height(2.dp))
                }
            }
        }

    }

}