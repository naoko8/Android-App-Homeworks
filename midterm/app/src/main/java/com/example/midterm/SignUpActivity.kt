package com.example.midterm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signuplayout.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.signuplayout)
        auth = FirebaseAuth.getInstance()
        signUpButton.setOnClickListener {
            signUpUser()
        }
    }

         fun signUpUser() {
            if (getEmail.text.toString().isEmpty()) {
                getEmail.error = "Please enter email"
                getEmail.requestFocus()
                return
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(getEmail.text.toString()).matches()) {
                getEmail.error = "Please enter valid email"
                getEmail.requestFocus()
                return
            }
            if (getPassword.text.toString().isEmpty()) {
                getPassword.error = "please enter password"
                getPassword.requestFocus()
                return
            }
             auth.createUserWithEmailAndPassword(getEmail.text.toString(), getPassword.text.toString())
                 .addOnCompleteListener(this) { task ->
                     if (task.isSuccessful) {
                         startActivity(Intent(this,MainActivity::class.java))
                         finish()
                     } else {
                         Toast.makeText(baseContext, "Authentication failed.",
                             Toast.LENGTH_SHORT).show()
                     }


                 }
        }
}


