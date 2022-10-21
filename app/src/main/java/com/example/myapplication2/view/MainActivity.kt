package com.example.myapplication2
import androidx.lifecycle.Observer

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication2.repository.MainActivityRepository.serviceSetterGetter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.json.JSONObject
import com.example.myapplication2.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnrefresh = findViewById<TextView>(R.id.btnrefresh)
        val textView = findViewById<TextView>(R.id.fact11)
        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getFact()!!.observe(this, Observer { serviceSetterGetter ->
            val fact = serviceSetterGetter.fact
            textView.text = fact
        })



        btnrefresh.setOnClickListener {
            mainActivityViewModel.getFact()!!.observe(this, Observer { serviceSetterGetter ->
                val fact = serviceSetterGetter.fact
                textView.text = fact

            })

        }




    }

    override fun onBackPressed()
    {
        Log.d("backpressed","backpressed")
        MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
            .setMessage(
                "Are you sure that you want to exit the App?")
            .setPositiveButton("Yes") {
                dialog , which ->
                super.onBackPressed()

            }
            .show()
            }
    }
