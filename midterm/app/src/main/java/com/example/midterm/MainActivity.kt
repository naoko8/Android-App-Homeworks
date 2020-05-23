package com.example.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signuplayout.*

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        doNotHaveAccButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
            //init();
        }
        onButtonClick.setOnClickListener{
            doLogin()
        }
    }

    private fun doLogin() {
        if (usernameInput.text.toString().isEmpty()) {
            usernameInput.error = "Please enter email"
            usernameInput.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(usernameInput.text.toString()).matches()) {
            usernameInput.error = "Please enter valid email"
            usernameInput.requestFocus()
            return
        }
        if (passwordInput.text.toString().isEmpty()) {
            passwordInput.error = "please enter password"
            passwordInput.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(usernameInput.text.toString(), passwordInput.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Log in failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }

    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser!=null){
            startActivity(Intent(this,DashboardActivity::class.java))
        }
        else{
            Toast.makeText(baseContext,"Log in failed.",Toast.LENGTH_SHORT).show()
        }
    }


}
