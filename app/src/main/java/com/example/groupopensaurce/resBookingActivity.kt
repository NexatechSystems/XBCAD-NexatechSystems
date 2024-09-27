package com.example.groupopensaurce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class ResBookingActivity : AppCompatActivity() {

    private lateinit var restaurantNameTextView: TextView
    private lateinit var numPeopleEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_booking)

        // Initialize UI components
        restaurantNameTextView = findViewById(R.id.resturantName)
        numPeopleEditText = findViewById(R.id.txtNumPeople)
        nameEditText = findViewById(R.id.txtName)
        phoneEditText = findViewById(R.id.txtPhoneNo)
        submitButton = findViewById(R.id.btnSubmit)

        // Get the restaurant name from intent extras
        val restaurantName = intent.getStringExtra("RESTAURANT_NAME")
        restaurantNameTextView.text = restaurantName

        // Handle submit button click
        submitButton.setOnClickListener {
            val numberOfPeople = numPeopleEditText.text.toString()
            val userName = nameEditText.text.toString()
            val phoneNumber = phoneEditText.text.toString()

            // Validate inputs
            if (numberOfPeople.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Process booking
                // TODO: Add your booking logic here (e.g., save to database, send to server)

                // For now, display a confirmation message
                Toast.makeText(this, "Restaurant booking successful!", Toast.LENGTH_LONG).show()

                // Optionally, navigate back to the home screen or clear the form
                finish()
            }
        }
    }
}
