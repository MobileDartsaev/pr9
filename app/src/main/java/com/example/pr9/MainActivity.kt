package com.example.pr9

import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    // Устанавливаем переменную для отслеживания текущего экрана
    var isMainScreen by remember { mutableStateOf(true) }

    if (isMainScreen) {
        MainScreen(onRegisterClick = { isMainScreen = false }) // Переход на экран регистрации
    } else {
        ConfirmationScreen(onBackClick = { isMainScreen = true }) // Возврат на основной экран
    }
}

@Composable
fun MainScreen(onRegisterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Картинка
            Image(
                painter = painterResource(id = R.drawable.p1), // Замените на имя вашего изображения
                contentDescription = "Example Image",
                modifier = Modifier.size(80.dp) // Размер квадратного изображения
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Тексты для регистрации, помощи и входа
            Column {
                Text("Регистрация", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Помощь", fontSize = 16.sp)
                Text("Вход", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Поля для ввода
        var textFieldValue1 by remember { mutableStateOf("") }
        var textFieldValue2 by remember { mutableStateOf("") }
        var textFieldValue3 by remember { mutableStateOf("") }

        BasicTextField(
            value = textFieldValue1,
            onValueChange = { textFieldValue1 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = textFieldValue2,
            onValueChange = { textFieldValue2 = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = textFieldValue3,
            onValueChange = { textFieldValue3 = it },
            modifier = Modifier

                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Чекбокс с текстом о согласии
        var checkedState by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )
            Text("Согласен(-а) с условиями использования и политикой конфиденциальности")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка "Зарегистрироваться"
        Button(
            onClick = {
                if (checkedState) {
                    onRegisterClick() // Переход на экран подтверждения
                } else {
                    // Здесь можно показать сообщение об ошибке, если необходимо
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp), // Скругленные края
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7FC35))
        ) {
            Text("Зарегистрироваться", color = Color.Black)
        }
    }
}

@Composable
fun ConfirmationScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Вы на втором экране!", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackClick) {
            Text("Назад на главный экран")

        }
    }
}






