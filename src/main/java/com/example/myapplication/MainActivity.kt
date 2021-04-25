package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private enum class Option(selected : Int){
        ROCK(1),
        PAPER(2),
        SCISSOR(3)
    }

    private var yourSelection = Option.ROCK

    private var compSelection = Option.ROCK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)


        binding.rock.setOnClickListener{
            randomizer()
            binding.playerMove.setImageResource(R.drawable.sheriffrock)
            yourSelection=Option.ROCK

            Compare()
        }

        binding.paper.setOnClickListener{
            randomizer()
            binding.playerMove.setImageResource(R.drawable.sheriffpaper)
            yourSelection=Option.PAPER
        }

        binding.scissor.setOnClickListener{
            randomizer()
            binding.playerMove.setImageResource(R.drawable.sheriffscissors)
            yourSelection=Option.SCISSOR
        }
    }

    private fun Compare() : Int{
        if (yourSelection == compSelection){
            binding.result.text = "Draw"
        }else if (yourSelection == Option.ROCK){
            if (compSelection == Option.PAPER){
                binding.result.text = "Computer Wins"
                return 1
            }
        }else if (yourSelection == Option.PAPER){
            if (compSelection == Option.SCISSOR){
                binding.result.text = "Computer Wins"
                return 1
            }
        }else if (yourSelection == Option.SCISSOR){
            if (compSelection == Option.ROCK){
                binding.result.text = "Computer Wins"
                return 1
            }
        }

        binding.result.text = "You Win"
        return 1
    }


    private fun randomizer() {

        when((1..3).shuffled().last()){
            1->{
                compSelection=Option.ROCK
                binding.compMove.setImageDrawable(getDrawable(R.drawable.outlawrock))
            }

            2->{
                compSelection=Option.PAPER
                binding.compMove.setImageDrawable(getDrawable(R.drawable.outlawpaper))
            }

            3->{
                compSelection=Option.SCISSOR
                binding.compMove.setImageDrawable(getDrawable(R.drawable.outlawscissors))
            }
        }
    }
}