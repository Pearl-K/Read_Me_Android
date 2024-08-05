package com.example.readme.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyPageViewModel : ViewModel() {
    //private val profileRepository = ProfileRepository()

    private val _profileName = MutableLiveData("Username")
    val profileName: LiveData<String> get() = _profileName

    private val _profileId = MutableLiveData("@testUserId")
    val profileId: LiveData<String> get() = _profileId

    private val _profileBio = MutableLiveData("This is the bio")
    val profileBio: LiveData<String> get() = _profileBio

    private val _followersCount = MutableLiveData(700)
    val followersCount: LiveData<Int> get() = _followersCount

    private val _followingCount = MutableLiveData(777)
    val followingCount: LiveData<Int> get() = _followingCount

    private val _profileImg = MutableLiveData<String>()
    val profileImg: LiveData<String> get() = _profileImg

    fun fetchProfile() {
        viewModelScope.launch {
            //val response = profileRepository.getProfile()
            /*if (response.isSuccess) {
                response.result?.let { profile ->
                    _profileName.value = profile.nickname
                    _profileId.value = "@${profile.account}"
                    _profileBio.value = profile.comment
                    _followersCount.value = profile.followerNum
                    _followingCount.value = profile.followingNum
                    _profileImg.value = profile.profileImg
                }
            }*/
        }
    }
}
