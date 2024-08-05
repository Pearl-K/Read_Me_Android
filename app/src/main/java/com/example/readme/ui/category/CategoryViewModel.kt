package com.example.readme.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {
    private  val _selectedCount = MutableLiveData(0)
    private val _selectedToggleIds = MutableLiveData<MutableList<Int>>(mutableListOf())
    val selectedToggleIds : LiveData<MutableList<Int>> get() = _selectedToggleIds

    val selectedCount : LiveData<Int> get() = _selectedCount
    private val maxSelections = 8



    fun toggleSelection(isSelected : Boolean, id: Int){
        val currentList = _selectedToggleIds.value ?: mutableListOf()
        val count = _selectedCount.value ?: 0
        if (isSelected){
            _selectedCount.value = count + 1
            if (!currentList.contains(id)){
                currentList.add(id)
            }
            else{
                currentList.remove(id)
            }
        }
        else{
            _selectedCount.value = count - 1
            currentList.sort()
            _selectedToggleIds.value = currentList

            Log.d("CategoryViewModel", "Selected Toggle IDs: $currentList")

        }
    }
    fun canSelectMore(): Boolean{
        val count = _selectedCount.value ?:0
        return  count < maxSelections
    }

}