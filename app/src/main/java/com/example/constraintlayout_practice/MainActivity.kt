package com.example.constraintlayout_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener{
            if (ed_name.length() < 1) {
                tv_text.text = "請輸入名字，已開始遊戲"
                return@setOnClickListener
            }
            val playerName = ed_name.text
            tv_name.text = "名字\n${playerName}"
            val randomNumber = (Math.random() * 3).toInt()

            val computerMora = when (randomNumber) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            tv_cmora.text = "電腦出拳\n${computerMora}"

            val myMora = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            tv_mmora.text = "我方出拳\n${myMora}"

            when {
                (btn_scissor.isChecked && (randomNumber == 2)) || (btn_stone.isChecked && (randomNumber == 0)) || (btn_paper.isChecked && (randomNumber == 1))
                -> {
                    tv_winner.text = "勝利者\n${playerName}"
                    tv_text.text = "${playerName}出${myMora}贏了電腦"
                }
                (btn_scissor.isChecked && (randomNumber == 1)) || (btn_stone.isChecked && (randomNumber == 2)) || (btn_paper.isChecked && (randomNumber == 0))
                -> {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "電腦出${computerMora}贏了我"
                }
                else
                -> {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平手... 繼續加油"
                }
            }
        }

        findViewById<RadioGroup>(R.id.group_radio_button).setOnCheckedChangeListener { radioGroup, btnId ->
            when (btnId) {
                R.id.btn_scissor -> println("我選擇出剪刀")
                R.id.btn_stone -> println("我選擇出石頭")
                R.id.btn_paper -> println("我選擇出布")
            }
        }

    }
}