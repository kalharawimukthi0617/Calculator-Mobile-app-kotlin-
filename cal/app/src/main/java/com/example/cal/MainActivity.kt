package com.example.cal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var pressEqual=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        delBtn.setOnClickListener{
            textView.text=textView.text.substring(0,textView.length()-1)
        }

        clearBtn.setOnClickListener{
            textView.text=""
        }

        calculate.setOnClickListener{
            if(textView.text.contains("*")){
                val numbers=textView.text.split("*")
                if(numbers.size<3){
                    if(textView.text.contains("."))
                        textView.text=(numbers[0].toFloat() * numbers[1].toFloat()).toString()
                    else
                        textView.text=(numbers[0].toInt() * numbers[1].toInt()).toString()
                }
                else
                    Toast.makeText(this,"This calculator can not calculate more than 2 numbers.",Toast.LENGTH_LONG).show()

            }
            else if(textView.text.contains("/")){
                val numbers=textView.text.split("/")
                if(numbers.size<3){
                    textView.text=(numbers[0].toFloat() / numbers[1].toFloat()).toString()
                }
                else
                    Toast.makeText(this,"This calculator can not calculate more than 2 numbers.",Toast.LENGTH_LONG).show()
            }
            else if(textView.text.contains("+")){
                val numbers=textView.text.split("+")

                if(numbers.size<3){
                    if(textView.text.contains("."))
                        textView.text=(numbers[0].toFloat() + numbers[1].toFloat()).toString()
                    else
                        textView.text=(numbers[0].toInt() + numbers[1].toInt()).toString()
                }else
                    Toast.makeText(this,"This calculator can not calculate more than 2 numbers.",Toast.LENGTH_LONG).show()


            }
            else if(textView.text.contains("-")){
                var isfistNumMinus=false

                if(textView.text.startsWith("-")){
                    textView.text=textView.text.substring(1)
                    isfistNumMinus=true
                }

                val numbers = textView.text.split("-").toMutableList()

                if(isfistNumMinus)
                    numbers[0]="-${numbers[0]}"

                if(numbers.size<3){
                    if(textView.text.contains("."))
                        textView.text=(numbers[0].toFloat() - numbers[1].toFloat()).toString()
                    else
                        textView.text=(numbers[0].toInt() - numbers[1].toInt()).toString()
                }else
                    Toast.makeText(this,"This calculator can not calculate more than 2 numbers.",Toast.LENGTH_LONG).show()


            }
            else
                Toast.makeText(this,"Can not calculate with out any operator",Toast.LENGTH_SHORT).show()

            pressEqual=true
        }

    }

    fun type(view: View){

            if(pressEqual){
                textView.text=""
                pressEqual=false
            }

        textView.append((view as Button).text)

    }
}