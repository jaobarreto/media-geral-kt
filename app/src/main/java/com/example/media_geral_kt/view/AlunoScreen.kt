package com.example.media_geral_kt.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.media_geral_kt.model.Aluno
import com.example.media_geral_kt.viewmodel.AlunoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlunoScreen(viewModel: AlunoViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Média Geral - Alunos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Formulário de cadastro
            CadastroSection(viewModel)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Lista de alunos
            Text(
                text = "Alunos Cadastrados",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            ListaAlunos(alunos = viewModel.alunos.value)
        }
    }
}

@Composable
fun CadastroSection(viewModel: AlunoViewModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Cadastro de Aluno",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            OutlinedTextField(
                value = viewModel.nome.value,
                onValueChange = { viewModel.nome.value = it },
                label = { Text("Nome Completo") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = viewModel.tp1.value,
                    onValueChange = { viewModel.tp1.value = it },
                    label = { Text("TP1") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f)
                )
                
                OutlinedTextField(
                    value = viewModel.tp2.value,
                    onValueChange = { viewModel.tp2.value = it },
                    label = { Text("TP2") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f)
                )
                
                OutlinedTextField(
                    value = viewModel.tp3.value,
                    onValueChange = { viewModel.tp3.value = it },
                    label = { Text("TP3") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { viewModel.adicionarAluno() },
                modifier = Modifier.fillMaxWidth(),
                enabled = viewModel.nome.value.isNotBlank() &&
                        viewModel.tp1.value.isNotBlank() &&
                        viewModel.tp2.value.isNotBlank() &&
                        viewModel.tp3.value.isNotBlank()
            ) {
                Text("Cadastrar Aluno")
            }
        }
    }
}

@Composable
fun ListaAlunos(alunos: List<Aluno>) {
    if (alunos.isEmpty()) {
        Text(
            text = "Nenhum aluno cadastrado ainda.",
            color = Color.Gray,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(alunos) { aluno ->
                AlunoCard(aluno)
            }
        }
    }
}

@Composable
fun AlunoCard(aluno: Aluno) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (aluno.statusFinal) {
                "Reprovado" -> Color(0xFFFFEBEE)
                "Aprovado" -> Color(0xFFE8F5E9)
                else -> Color(0xFFE3F2FD)
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = aluno.nomeCompleto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("TP1: ${String.format("%.1f", aluno.tp1)}")
                Text("TP2: ${String.format("%.1f", aluno.tp2)}")
                Text("TP3: ${String.format("%.1f", aluno.tp3)}")
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Divider()
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Média: ${String.format("%.2f", aluno.mediaGeral)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                
                Text(
                    text = aluno.statusFinal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = when (aluno.statusFinal) {
                        "Reprovado" -> Color(0xFFD32F2F)
                        "Aprovado" -> Color(0xFF388E3C)
                        else -> Color(0xFF1976D2)
                    }
                )
            }
        }
    }
}
