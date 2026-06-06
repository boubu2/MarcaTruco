package com.example.trucomarcar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NomesActivity : AppCompatActivity() {

    private lateinit var etNomeJogador1: EditText
    private lateinit var etNomeJogador2: EditText
    private lateinit var btnConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nomes)

        etNomeJogador1 = findViewById(R.id.etNomeJogador1)
        etNomeJogador2 = findViewById(R.id.etNomeJogador2)
        btnConfirmar   = findViewById(R.id.btnConfirmar)

        if (MainActivity.nomeJogador1 != "Jogador 1") {
            etNomeJogador1.setText(MainActivity.nomeJogador1)
        }
        if (MainActivity.nomeJogador2 != "Jogador 2") {
            etNomeJogador2.setText(MainActivity.nomeJogador2)
        }

        btnConfirmar.setOnClickListener {
            var nome1 = etNomeJogador1.text.toString().trim()
            var nome2 = etNomeJogador2.text.toString().trim()

            if (nome1.isEmpty()) nome1 = "Jogador 1"
            if (nome2.isEmpty()) nome2 = "Jogador 2"

            MainActivity.nomeJogador1 = nome1
            MainActivity.nomeJogador2 = nome2

            Toast.makeText(this, "Nomes atualizados!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
