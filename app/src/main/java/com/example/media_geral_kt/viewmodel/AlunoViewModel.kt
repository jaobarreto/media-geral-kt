package com.example.media_geral_kt.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.media_geral_kt.model.Aluno

class AlunoViewModel : ViewModel() {
    var alunos = mutableStateOf<List<Aluno>>(emptyList())
        private set
    
    var nome = mutableStateOf("")
    var tp1 = mutableStateOf("")
    var tp2 = mutableStateOf("")
    var tp3 = mutableStateOf("")
    
    fun adicionarAluno() {
        val novoAluno = Aluno(
            nomeCompleto = nome.value,
            tp1 = tp1.value.toDoubleOrNull() ?: 0.0,
            tp2 = tp2.value.toDoubleOrNull() ?: 0.0,
            tp3 = tp3.value.toDoubleOrNull() ?: 0.0
        )
        
        alunos.value = alunos.value + novoAluno
        limparCampos()
    }
    
    private fun limparCampos() {
        nome.value = ""
        tp1.value = ""
        tp2.value = ""
        tp3.value = ""
    }
}
