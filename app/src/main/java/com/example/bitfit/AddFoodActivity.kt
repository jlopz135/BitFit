package com.example.bitfit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food)

        val button = findViewById<Button>(R.id.btnAddNewFood)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(findViewById<EditText>(R.id.etAddFood).text)
               ) {

                setResult(Activity.RESULT_CANCELED, replyIntent)

            } else {
                val food = findViewById<EditText>(R.id.etAddFood).text.toString()
                val calories = findViewById<EditText>(R.id.etAddCal).text.toString()

                replyIntent.putExtra(EXTRA_FOOD, food)
                replyIntent.putExtra(EXTRA_CALORIES,calories)
                setResult(Activity.RESULT_OK, replyIntent)

            }
            finish()
        }
    }


    companion object {
        const val EXTRA_FOOD = "FOOD_EXTRA"
        const val EXTRA_CALORIES = "CALORIES_EXTRA"
    }

}