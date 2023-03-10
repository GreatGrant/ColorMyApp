package com.gralliams.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gralliams.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                binding.redButton, binding.greenButton, binding.yellowButton)

        for (view in clickableViews){
            view.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.red)
            R.id.yellow_button -> binding.boxFiveText.setBackgroundResource(R.color.green)
            R.id.green_button -> binding.boxFourText.setBackgroundResource(R.color.yellow)


            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}