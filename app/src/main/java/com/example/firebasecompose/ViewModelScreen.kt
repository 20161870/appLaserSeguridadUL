package com.example.firebasecompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage

class ViewModelScreen : ViewModel(){
    private val _link : MutableLiveData<String> = MutableLiveData("")
    val link : LiveData<String> = _link

    fun downloadPhoto(){
        FirebaseStorage.getInstance().getReference("Photo").downloadUrl.addOnSuccessListener {
            _link.value = it.toString()
        }.addOnFailureListener {
            //
        }
    }
}