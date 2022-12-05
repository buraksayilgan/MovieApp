package com.mburaksayilgan.movieapp.utils

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation


open class NavigationManager (private val view: View) {

    fun navigate(action : Int, bundle: Bundle? = null){
        Navigation.findNavController(view).navigate(action, bundle)
    }

    fun navigateForActivity(fromActivity : AppCompatActivity, toActivity : AppCompatActivity) {
        val intent = Intent(fromActivity, toActivity::class.java)
        fromActivity.startActivity(intent)
        fromActivity.finish()
    }
}
