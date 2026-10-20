package com.nauz.dailyspark

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private data class Quote(val text: String, val author: String)

    private val quotes = listOf(
        Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
        Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill"),
        Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
        Quote("It always seems impossible until it's done.", "Nelson Mandela"),
        Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
        Quote("Do not wait for the perfect moment, take the moment and make it perfect.", "Zoey Sayward"),
        Quote("Your time is limited, so don't waste it living someone else's life.", "Steve Jobs"),
        Quote("The best way to predict the future is to create it.", "Peter Drucker"),
        Quote("Start where you are. Use what you have. Do what you can.", "Arthur Ashe"),
        Quote("Happiness is not something ready made. It comes from your own actions.", "Dalai Lama"),
        Quote("Dream big and dare to fail.", "Norman Vaughan"),
        Quote("Little by little, one travels far.", "J. R. R. Tolkien"),
        Quote("Arise, awake, and stop not till the goal is reached.", "Swami Vivekananda"),
        Quote("You have to dream before your dreams can come true.", "A. P. J. Abdul Kalam"),
        Quote("Action is the foundational key to all success.", "Pablo Picasso")
    )

    private var lastIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteText = findViewById<TextView>(R.id.quoteText)
        val authorText = findViewById<TextView>(R.id.authorText)
        val newQuoteBtn = findViewById<MaterialButton>(R.id.newQuoteBtn)

        showRandomQuote(quoteText, authorText)

        newQuoteBtn.setOnClickListener {
            showRandomQuote(quoteText, authorText)
            val anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
            anim.duration = 450
            quoteText.startAnimation(anim)
            authorText.startAnimation(anim)
        }
    }

    private fun showRandomQuote(quoteText: TextView, authorText: TextView) {
        var index: Int
        do {
            index = Random.nextInt(quotes.size)
        } while (quotes.size > 1 && index == lastIndex)
        lastIndex = index

        val q = quotes[index]
        quoteText.text = "\u201C" + q.text + "\u201D"
        authorText.text = "\u2014 " + q.author
    }
}
