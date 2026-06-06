package com.example.trucomarcar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvNomeJogador1: TextView
    private lateinit var tvNomeJogador2: TextView
    private lateinit var tvPontuacaoJogador1: TextView
    private lateinit var tvPontuacaoJogador2: TextView

    private lateinit var btnJ1Mais1: Button
    private lateinit var btnJ1Mais3: Button
    private lateinit var btnJ1Mais6: Button
    private lateinit var btnJ1Mais9: Button
    private lateinit var btnJ1Mais12: Button

    private lateinit var btnJ2Mais1: Button
    private lateinit var btnJ2Mais3: Button
    private lateinit var btnJ2Mais6: Button
    private lateinit var btnJ2Mais9: Button
    private lateinit var btnJ2Mais12: Button

    private lateinit var btnHistorico: Button
    private lateinit var btnZerarHistorico: Button
    private lateinit var btnInformarNomes: Button

    companion object {
        var nomeJogador1: String = "Jogador 1"
        var nomeJogador2: String = "Jogador 2"
        var pontuacaoJogador1: Int = 0
        var pontuacaoJogador2: Int = 0
        var partidasJogador1: Int = 0
        var partidasJogador2: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentes()
        configurarListeners()
        atualizarTela()
    }

    override fun onResume() {
        super.onResume()
        atualizarTela()
    }

    private fun inicializarComponentes() {
        tvNomeJogador1      = findViewById(R.id.tvNomeJogador1)
        tvNomeJogador2      = findViewById(R.id.tvNomeJogador2)
        tvPontuacaoJogador1 = findViewById(R.id.tvPontuacaoJogador1)
        tvPontuacaoJogador2 = findViewById(R.id.tvPontuacaoJogador2)

        btnJ1Mais1  = findViewById(R.id.btnJ1Mais1)
        btnJ1Mais3  = findViewById(R.id.btnJ1Mais3)
        btnJ1Mais6  = findViewById(R.id.btnJ1Mais6)
        btnJ1Mais9  = findViewById(R.id.btnJ1Mais9)
        btnJ1Mais12 = findViewById(R.id.btnJ1Mais12)

        btnJ2Mais1  = findViewById(R.id.btnJ2Mais1)
        btnJ2Mais3  = findViewById(R.id.btnJ2Mais3)
        btnJ2Mais6  = findViewById(R.id.btnJ2Mais6)
        btnJ2Mais9  = findViewById(R.id.btnJ2Mais9)
        btnJ2Mais12 = findViewById(R.id.btnJ2Mais12)

        btnHistorico      = findViewById(R.id.btnHistorico)
        btnZerarHistorico = findViewById(R.id.btnZerarHistorico)
        btnInformarNomes  = findViewById(R.id.btnInformarNomes)
    }

    private fun configurarListeners() {
        btnJ1Mais1.setOnClickListener  { adicionarPontos(1, 1) }
        btnJ1Mais3.setOnClickListener  { adicionarPontos(1, 3) }
        btnJ1Mais6.setOnClickListener  { adicionarPontos(1, 6) }
        btnJ1Mais9.setOnClickListener  { adicionarPontos(1, 9) }
        btnJ1Mais12.setOnClickListener { adicionarPontos(1, 12) }

        btnJ2Mais1.setOnClickListener  { adicionarPontos(2, 1) }
        btnJ2Mais3.setOnClickListener  { adicionarPontos(2, 3) }
        btnJ2Mais6.setOnClickListener  { adicionarPontos(2, 6) }
        btnJ2Mais9.setOnClickListener  { adicionarPontos(2, 9) }
        btnJ2Mais12.setOnClickListener { adicionarPontos(2, 12) }

        btnHistorico.setOnClickListener {
            startActivity(Intent(this, HistoricoActivity::class.java))
        }

        btnZerarHistorico.setOnClickListener { zerarHistorico() }

        btnInformarNomes.setOnClickListener {
            startActivity(Intent(this, NomesActivity::class.java))
        }
    }

    private fun adicionarPontos(jogador: Int, pontos: Int) {
        if (jogador == 1) {
            pontuacaoJogador1 += pontos
            tvPontuacaoJogador1.text = pontuacaoJogador1.toString()
            if (pontuacaoJogador1 >= 12) {
                partidasJogador1++
                exibirVencedor(nomeJogador1)
            }
        } else {
            pontuacaoJogador2 += pontos
            tvPontuacaoJogador2.text = pontuacaoJogador2.toString()
            if (pontuacaoJogador2 >= 12) {
                partidasJogador2++
                exibirVencedor(nomeJogador2)
            }
        }
    }

    private fun exibirVencedor(nomeVencedor: String) {
        AlertDialog.Builder(this)
            .setTitle("Fim de Partida!")
            .setMessage("$nomeVencedor venceu esta partida!\n\nA pontuação será zerada.")
            .setPositiveButton("OK") { dialog, _ ->
                pontuacaoJogador1 = 0
                pontuacaoJogador2 = 0
                atualizarTela()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun zerarHistorico() {
        pontuacaoJogador1 = 0
        pontuacaoJogador2 = 0
        partidasJogador1  = 0
        partidasJogador2  = 0
        nomeJogador1      = "Jogador 1"
        nomeJogador2      = "Jogador 2"
        atualizarTela()
        Toast.makeText(this, "Histórico zerado com sucesso!", Toast.LENGTH_SHORT).show()
    }

    private fun atualizarTela() {
        tvNomeJogador1.text      = nomeJogador1
        tvNomeJogador2.text      = nomeJogador2
        tvPontuacaoJogador1.text = pontuacaoJogador1.toString()
        tvPontuacaoJogador2.text = pontuacaoJogador2.toString()
    }
}
