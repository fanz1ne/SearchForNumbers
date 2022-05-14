package com.example.firstapp
//привет
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    var a : Int = Random.nextInt(0,100) //создание рандомного числа 1
    var b : Int = Random.nextInt(1,100) //создание рандомного числа 2
    var count : Int = 0 //счетчик для игрока

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        //обновление всего поля , но не меняем числа
        bindingClass.buttonReset.setOnClickListener{
            bindingClass.Result.text = " ";
            resetAll()
        }

        //region Обычные действия над числами
        bindingClass.buttonAdd.setOnClickListener{
            val result:Int = (a + b)
            bindingClass.Result.text = result.toString()
        }
        bindingClass.buttonDiv.setOnClickListener{
            val result:Double = Math.round(((a.toDouble()/b.toDouble()) * 100.0)) / 100.0
            bindingClass.Result.text = result.toString()
        }
        bindingClass.buttonMulty.setOnClickListener{
            val result: Int = (a * b)
            bindingClass.Result.text = result.toString()
        }
        bindingClass.buttonSubstract.setOnClickListener{
            val result: Int = (a - b)
            bindingClass.Result.text = result.toString()
        }
        //endregion

        //проверка угадал ли игрок цифры(-у) + добавляем очки
        bindingClass.buttonCheck.setOnClickListener{
            if(bindingClass.quesesNumbwer1.text.toString() == a.toString()
                && bindingClass.quesesNumbwer2.text.toString() == b.toString())
            {
                bindingClass.textQuestion.text = "True"
                bindingClass.textQuestion.setBackgroundColor(Color.GREEN);
                count+=2
                bindingClass.count.text = count.toString()
            }
            else if(bindingClass.quesesNumbwer1.text.toString() == a.toString())
            {
                bindingClass.textQuestion.text = "U've found 1 number"
                bindingClass.textQuestion.setBackgroundColor(Color.GREEN);
                count+=1
                bindingClass.count.text = count.toString()

            }
            else if(bindingClass.quesesNumbwer2.text.toString() == b.toString())
            {
                bindingClass.textQuestion.text = "U've found 2 number"
                bindingClass.textQuestion.setBackgroundColor(Color.GREEN);
                count+=1
                bindingClass.count.text = count.toString()

            }
            else {
                bindingClass.textQuestion.text = "False"
                bindingClass.textQuestion.setBackgroundColor(Color.RED);
            }
        }
        //обновление всего поля и меняем числа
        bindingClass.buttonChenge.setOnClickListener{
            a = Random.nextInt(0,100)
            b = Random.nextInt(1,100)
            resetAll()
        }
    }
    //refresh all fields
    private fun resetAll(){
        bindingClass.textQuestion.text = "Do you know numbers?"
        bindingClass.textQuestion.setTextColor(Color.BLACK)
        bindingClass.textQuestion.setBackgroundColor(Color.WHITE)

        bindingClass.Result.text = " "

        bindingClass.quesesNumbwer1.setText(" ")
        bindingClass.quesesNumbwer2.setText(" ")
    }

}