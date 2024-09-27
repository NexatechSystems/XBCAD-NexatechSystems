package com.example.groupopensaurce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class HotelBookingActivity : AppCompatActivity() {

    private lateinit var hotelNameTextView: TextView
    private lateinit var nightsEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var paymentEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelbooking)

        // Initialize UI components
        hotelNameTextView = findViewById(R.id.hotelNameTextView)
        nightsEditText = findViewById(R.id.txtNights)
        nameEditText = findViewById(R.id.txtNights)
        phoneEditText = findViewById(R.id.txtPhoneNo)
        paymentEditText = findViewById(R.id.txtPayment)
        submitButton = findViewById(R.id.btnSubmit)

        // Get the hotel name from intent extras
        val hotelName = intent.getStringExtra("HOTEL_NAME")
        hotelNameTextView.text = hotelName

        // Handle submit button click
        submitButton.setOnClickListener {
            val numberOfNights = nightsEditText.text.toString()
            val userName = nameEditText.text.toString()
            val phoneNumber = phoneEditText.text.toString()
            val paymentDetails = paymentEditText.text.toString()

            // Validate inputs
            if (numberOfNights.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty() || paymentDetails.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Process booking
                // TODO: Add your booking logic here (e.g., save to database, send to server)

                // For now, display a confirmation message
                Toast.makeText(this, "Booking successful!", Toast.LENGTH_LONG).show()

                // Optionally, navigate back to the home screen or clear the form
                finish()
            }
        }
    }
}
