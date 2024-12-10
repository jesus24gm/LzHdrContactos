package com.example.lzhdrcontactos.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lzhdrcontactos.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun muestraContactos(modifier: Modifier = Modifier) {
    val contactosPorLetra: Map<Char, List<contactos>> = getContactos().groupBy { it.nombre.first() }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        contactosPorLetra.forEach { (letraInicial, contactos) ->
            stickyHeader {
                Text(
                    text = letraInicial.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(8.dp),
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
            items(contactos) { contacto -> // Aquí usamos "contactos", que es una lista por cada letra
                ItemContacto(contacto)
            }
        }
    }
}

fun getContactos(): List<contactos> {
    return listOf(
        contactos("Alice", 123456789),
        contactos("Bob", 987654321),
        contactos("Charlie", 233445566),
        contactos("Diana", 334556677),
        contactos("Eve", 445667788),
        contactos("Frank", 566778899),
        contactos("Grace", 677889900),
        contactos("Hank", 788990011),
        contactos("Ivy", 889001122),
        contactos("Jack", 900112233),
        contactos("Karen", 1011121314),
        contactos("Leo", 1112131415),
        contactos("Mandy", 1213141516),
        contactos("Nancy", 1314151617),
        contactos("Oscar", 1415161718),
        contactos("Paul", 1516171819),
        contactos("Quincy", 1617181920),
        contactos("Rachel", 1718192021),
        contactos("Steve", 1819202122),
        contactos("Tracy", 1920212223),
        contactos("Uma", 2021222324),
        contactos("Victor", 2122232425),
        contactos("Wendy", 222342526),
        contactos("Xander", 234252627),
        contactos("Yara", 242262728),
        contactos("Zane", 256272829),
        contactos("Alan", 227282930),
        contactos("Bella", 728293031),
        contactos("Cindy", 282903132),
        contactos("David", 293013233),
        contactos("Ella", 303123334)




    )
}

@Composable
fun ItemContacto(contacto: contactos) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = contacto.nombre,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp
        )
        Text(
            text = contacto.numero.toString(),
            fontSize = 18.sp
        )
    }
}