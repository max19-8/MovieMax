package com.example.moviemax.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(view: View, text: String) =
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()

fun showImage(context: Context, url:String,image:ImageView) =
    Glide.with(context)
    .load(url)
    .into(image)