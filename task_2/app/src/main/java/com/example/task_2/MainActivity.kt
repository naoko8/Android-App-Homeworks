package com.example.task_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val reqCode = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        d("method","onCreate")
        init()
    }
//
//    override fun onStart() {
//        super.onStart()
//        d("method","onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        d("method","onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        d("method","onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        d("method","onStop")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        d("method","onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        d("method","onDestroy")
//    }
    private fun init(){
        changeButton.setOnClickListener {
        openSecondPage()
        }
    }

    private fun openSecondPage() {
        val userModel = UserModel(enterName.text.toString(),enterSurname.toString(),enterMail.toString(),enterDateOfBirth.toString().toInt(),enterSex.toString())
        val myObj = Intent(this, Main2Activity::class.java)
        myObj.putExtra("user",userModel)
        startActivityForResult(myObj,reqCode)
        startActivity(intent)

}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode== Activity.RESULT_OK && requestCode==reqCode){
            val changedInfo = data!!.extras!!.getString("idk","")
            d("idk",changedInfo)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}
