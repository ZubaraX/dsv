package com.dsv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dsv.api.RetrofitInstance
import com.dsv.model.YourDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenSecondActivity: Button = findViewById(R.id.button_open_second_activity)
        buttonOpenSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        fetchData()
    }

    private fun fetchData() {
        val call = RetrofitInstance.api.getData()
        call.enqueue(object : Callback<YourDataModel> {
            override fun onResponse(call: Call<YourDataModel>, response: Response<YourDataModel>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    // обработка данных
                }
            }

            override fun onFailure(call: Call<YourDataModel>, t: Throwable) {
                // обработка ошибки
            }
        })
    }
}