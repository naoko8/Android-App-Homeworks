package com.example.task_2

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
}
    private fun init(){
        val mySecondObject = intent
        val user = mySecondObject.getParcelableExtra("user") as UserModel
        editName.setText(user.name)
        editSurname.setText(user.surname)
        editMail.setText(user.mail)
        editDateOfBirth.setText(user.dateBirth)
        editSex.setText(user.sex)

       buttonForSave.setOnClickListener {

            backToMainActivity()

        }
    }
    private fun backToMainActivity (){
       val intent = intent
        intent.putExtra("idk",editName.text.toString())
        setResult(Activity.RESULT_OK,intent)
        finish()
   }


}
