package com.example.trucomarcar

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoricoActivity : AppCompatActivity() {

    private lateinit var tvHistoricoJogador1: TextView
    private lateinit var tvHistoricoJogador2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        tvHistoricoJogador1 = findViewById(R.id.tvHistoricoJogador1)
        tvHistoricoJogador2 = findViewById(R.id.tvHistoricoJogador2)

        tvHistoricoJogador1.text =
            "${MainActivity.nomeJogador1}: ${MainActivity.partidasJogador1} partida(s) ganha(s)"
        tvHistoricoJogador2.text =
            "${MainActivity.nomeJogador2}: ${MainActivity.partidasJogador2} partida(s) ganha(s)"
    }
}
