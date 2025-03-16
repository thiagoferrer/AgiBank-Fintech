package br.com.fiap.agibank

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun LoginScreen(navController: NavController) {

    var isDarkTheme by remember { mutableStateOf(false) } // Estado do tema
    val lemon = FontFamily(Font(R.font.lemon_milk_pro_variable))
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    AgiBankTheme(darkTheme = isDarkTheme) { // Aplica o tema dinamicamente
        Surface( // Adicionado para alterar o fundo conforme o tema
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background // Define o fundo automaticamente
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
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

                    // Título
                    Text(
                        fontFamily = lemon,
                        fontSize = 26.sp,
                        text = "Bem-vindo à AgiBank",
                        color = if (isDarkTheme) Color.White else Color(0xFF0267FF),
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Login",
                        fontSize = 24.sp,
                        color = if (isDarkTheme) Color.White else Color(0xFF0267FF),
                        fontFamily = lemon
                    )

                    Spacer(modifier = Modifier.height(16.dp))

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
                        Text(text = "Entrar", fontSize = 18.sp)
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

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para ir para a tela de cadastro
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = { navController.navigate("cadastro") }) {
                        Text("Não tem uma conta? Cadastre-se")
                    }
                }

                // Botão de alternância de tema no canto superior direito
                IconButton(
                    onClick = { isDarkTheme = !isDarkTheme },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isDarkTheme) R.drawable.sol else R.drawable.lua
                        ),
                        contentDescription = "Alternar Tema",
                        tint = if (isDarkTheme) Color.White else Color.Black
                    )
                }
            }
        }
    }
}
