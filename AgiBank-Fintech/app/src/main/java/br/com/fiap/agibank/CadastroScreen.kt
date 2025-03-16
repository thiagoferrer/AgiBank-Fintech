package br.com.fiap.agibank

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.agibank.ui.theme.AgiBankTheme

@Composable
fun CadastroScreen(navController: NavController) {
    val lemon = FontFamily(Font(R.font.lemon_milk_pro_variable))

    var isDarkTheme by remember { mutableStateOf(false) } // Estado do tema
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }

    AgiBankTheme(darkTheme = isDarkTheme) { // Aplica o tema dinamicamente
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                // Botão de alternância de tema no canto superior direito
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    IconButton(onClick = { isDarkTheme = !isDarkTheme }) {
                        Icon(
                            painter = painterResource(
                                id = if (isDarkTheme) R.drawable.sol else R.drawable.lua
                            ),
                            contentDescription = "Alternar Tema",
                            tint = if (isDarkTheme) Color.White else Color.Black
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Logo Agibank
                    Image(
                        painter = painterResource(id = R.drawable.agibank_logo),
                        contentDescription = "Logo Agibank",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        "Crie sua conta",
                        fontFamily = lemon,
                        fontSize = 26.sp,
                        color = Color(0xFF0267FF)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Cadastro",
                        fontSize = 24.sp,
                        color = Color(0xFF0267FF),
                        fontFamily = lemon
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = nome,
                        onValueChange = { nome = it },
                        label = { Text("Nome") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Senha") },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .width(280.dp)
                            .height(52.dp)
                    ) {
                        Text(
                            text = "Cadastrar",
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Ou",
                        color = Color.Gray,
                        modifier = Modifier.padding(5.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Login com Google
                    Button(
                        onClick = { /* Google login */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier
                            .height(52.dp)
                            .width(280.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Logo"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Entrar com Google", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Botão Login com Apple
                    Button(
                        onClick = { /* Apple login */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier
                            .height(52.dp)
                            .width(280.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.apple_logo),
                            contentDescription = "Apple Logo"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Entrar com Apple", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Botão para ir para a tela de login
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = { navController.navigate("login") }) {
                        Text("Já tem uma conta? Faça login aqui")
                    }
                }
            }
        }
    }
}
