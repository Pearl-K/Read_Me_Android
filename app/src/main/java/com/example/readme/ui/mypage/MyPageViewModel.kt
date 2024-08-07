package com.example.readme.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.readme.data.remote.ReadmeServerService
import com.example.readme.utils.RetrofitClient.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyPageViewModel(private val token: String, private val apiService: ReadmeServerService) : ViewModel() {

    private val _profileName = MutableLiveData("Username")
    val profileName: LiveData<String> get() = _profileName

    private val _profileId = MutableLiveData("@testUserId")
    val profileId: LiveData<String> get() = _profileId

    private val _profileBio = MutableLiveData("This is the bio")
    val profileBio: LiveData<String> get() = _profileBio

    private val _readCount = MutableLiveData(17)
    val readCount: LiveData<Int> get() = _readCount

    private val _followersCount = MutableLiveData(700)
    val followersCount: LiveData<Int> get() = _followersCount

    private val _followingCount = MutableLiveData(777)
    val followingCount: LiveData<Int> get() = _followingCount

    private val _profileImg = MutableLiveData<String>()
    val profileImg: LiveData<String> get() = _profileImg

    fun getProfile(token: String) = liveData(Dispatchers.IO) {
        val response = apiService.getProfile("Bearer $token")
        emit(response)
    }
}
