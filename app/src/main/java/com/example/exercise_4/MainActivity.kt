package com.example.exercise_4

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calender= Calendar.getInstance()
        val currentYear =calender.get(Calendar.YEAR)
        val currentMonth =calender.get(Calendar.MONTH)
        val currentDay =calender.get(Calendar.DAY_OF_MONTH)

        btnBirthDate.setOnClickListener{

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    birthdayTextView.text = day.toString() + "/" +
                            (month + 1).toString() + "/" +
                            year.toString()

                    val age = currentYear - year
                    calculate(age)
                }, currentYear, currentMonth, currentDay
            )
            dpd.show()
        }
        btnReset.setOnClickListener{
            reset()
        }

    }

    private fun calculate(age : Int){

        val saving = when (age) {
            in 16..20 -> 5000
            in 21..25 -> 14000
            in 26..30 -> 29000
            in 31..35 -> 50000
            in 36..40 -> 78000
            in 41..45 -> 116000
            in 46..50 -> 165000
            in 51..55 -> 228000
            else -> 0
        }

        ageTextView.text = String.format("%d",age)
        minSaving.text = String.format("RM%d.00",saving)
        allowTransfer.text = String.format("RM%.2f",saving * 1.3)
    }

    private fun reset(){
        birthdayTextView.text = "DD/MM/YYYY "
        minSaving.text = ""
        allowTransfer.text= ""
        ageTextView.text=""
    }
}
