package com.example.media_geral_kt.model

data class Aluno(
    val nomeCompleto: String,
    val tp1: Double,
    val tp2: Double,
    val tp3: Double
) {
    val mediaGeral: Double
        get() = (tp1 + tp2 + tp3) / 3.0
    
    val statusFinal: String
        get() = when {
            mediaGeral < 6.0 -> "Reprovado"
            mediaGeral in 6.0..9.0 -> "Aprovado"
            else -> "Ótimo Aproveitamento"
        }
}
