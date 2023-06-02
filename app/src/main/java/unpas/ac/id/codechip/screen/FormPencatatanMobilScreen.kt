package unpas.ac.id.codechip.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import unpas.ac.id.codechip.ui.theme.Purple700
import unpas.ac.id.codechip.ui.theme.Teal200
import kotlinx.coroutines.launch


@Composable
fun FormPencatatanMobilScreen( navController:NavHostController, id: String? = null, modifier: Modifier = Modifier) {
        val viewModel = hiltViewModel<PengelolaanMobilViewModel>()
        val merk = remember { mutableStateOf(TextFieldValue("")) }
        val model = remember { mutableStateOf(TextFieldValue("")) }
        val bahan_bakar = remember { mutableStateOf(TextFieldValue("")) }
        val dijual = remember { mutableStateOf(TextFieldValue("")) }
        val deskripsi = remember { mutableStateOf(TextFieldValue("")) }
        val isLoading = remember { mutableStateOf(false) }
        val buttonLabel = if (isLoading.value) "Mohon tunggu..."
        else "Simpan"
        val scope = rememberCoroutineScope()
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                label = { Text(text = "Merk") },
                value = merk.value,
                onValueChange = {
                    merk.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                placeholder = { Text(text = "XXXXX") }
            )
            OutlinedTextField(
                label = { Text(text = "Model") },
                value = model.value,
                onValueChange = {
                    model.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization =
                    KeyboardCapitalization.Characters, keyboardType =
                    KeyboardType.Text
                ),
                placeholder = { Text(text = "XXXXX") }
            )
            OutlinedTextField(
                label = { Text(text = "Bahan Bakar") },
                value = bahan_bakar.value,
                onValueChange = {
                    bahan_bakar.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "5") }
            )
            OutlinedTextField(
                label = { Text(text = "Dijual") },
                value = dijual.value,
                onValueChange = {
                    dijual.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "5") }
            )
            OutlinedTextField(
                label = { Text(text = "Deskripsi") },
                value = deskripsi.value,
                onValueChange = {
                    deskripsi.value = it
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType =
                    KeyboardType.Decimal
                ),
                placeholder = { Text(text = "5") }
            )
            val loginButtonColors = ButtonDefaults.buttonColors(
                backgroundColor = Purple700,
                contentColor = Teal200
            )
            val resetButtonColors = ButtonDefaults.buttonColors(
                backgroundColor = Teal200,
                contentColor = Purple700
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Button(modifier = Modifier.weight(5f), onClick = {
                    if (id == null) {
                        scope.launch {
                            viewModel.insert(
                                merk.value.text,model.value.text, bahan_bakar.value.text,dijual.value.text,deskripsi.value.text
                            )
                        }
                    } else {
                        scope.launch {
                            viewModel.update(
                                id, merk.value.text,model.value.text, bahan_bakar.value.text,dijual.value.text,deskripsi.value.text
                            )
                        }
                    }
                    navController.navigate("pengelolaan-sampah")
                }, colors = loginButtonColors) {
                    Text(
                        text = buttonLabel,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
                Button(modifier = Modifier.weight(5f), onClick = {
                    merk.value = TextFieldValue("")
                    model.value = TextFieldValue("")
                    bahan_bakar.value = TextFieldValue("")
                    dijual.value = TextFieldValue("")
                    deskripsi.value = TextFieldValue("")
                }, colors = resetButtonColors) {
                    Text(
                        text = "Reset",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        viewModel.isLoading.observe(LocalLifecycleOwner.current) {
            isLoading.value = it
        }
        if (id != null) {
            LaunchedEffect(scope) {
                viewModel.loadItem(id) { setoranSampah ->
                    setoranSampah?.let {
                        merk.value = TextFieldValue(setoranSampah.merk)
                        model.value = TextFieldValue(setoranSampah.model)
                        bahan_bakar.value = TextFieldValue(setoranSampah.bahan_bakar)
                        dijual.value = TextFieldValue(setoranSampah.dijual)
                        deskripsi.value = TextFieldValue(setoranSampah.deskripsi)
                    }
                }
            }
        }
}