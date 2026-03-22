package xyz.teamgravity.ksafedemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewmodel = viewModel { AppViewModel() }

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(
                        horizontal = 16.dp
                    )
            ) {
                Text(
                    text = viewmodel.counter.toString()
                )
                Button(
                    onClick = {
                        viewmodel.onIncrementCounter()
                    }
                ) {
                    Text(
                        text = "Increment"
                    )
                }
                TextField(
                    value = viewmodel.userProfile.email,
                    onValueChange = viewmodel::onEmailChange,
                    label = {
                        Text(
                            text = "Email"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = viewmodel.userProfile.password,
                    onValueChange = viewmodel::onPasswordChange,
                    label = {
                        Text(
                            text = "Password"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}