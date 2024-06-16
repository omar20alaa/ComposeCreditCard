package app.compose_credit_card.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import app.compose_credit_card.CustomAppBar
import app.compose_credit_card.R
import app.compose_credit_card.view.CreditCardScreen
import app.compose_credit_card.viewmodel.CreditCardViewModel

@Composable
fun ArticlesScreen(drawerState: DrawerState, viewModel: CreditCardViewModel) {
    Scaffold(
        topBar = {
            CustomAppBar(
                drawerState = drawerState,
                title = LocalContext.current.getString(R.string.list_of_credit_cards)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CreditCardScreen(viewModel = viewModel)
        }
    }
}
