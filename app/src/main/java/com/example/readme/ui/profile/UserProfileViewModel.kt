package com.example.readme.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.readme.data.remote.ProfileResponse
import com.example.readme.data.remote.ReadmeServerService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserProfileViewModel(private val userId: Int, private val apiService: ReadmeServerService) : ViewModel() {

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

    private val _profile = MutableLiveData<ProfileResponse>()
    val profile: LiveData<ProfileResponse> get() = _profile


    // 프로필 정보를 가져오는 함수
    fun fetchProfile(): MutableLiveData<ProfileResponse> {
        viewModelScope.launch {
            try {
                // Retrofit의 API 호출
                val response = apiService.getProfile(userId)

                // 응답이 성공적인 경우
                if (response.isSuccess) {
                    // 응답 본문을 ProfileResponse로 변환
                    val profileResponse = response

                    // profileResponse가 null이 아닌 경우에만 처리
                    profileResponse?.let {
                        // LiveData에 값을 설정
                        _profile.postValue(it)
                    } ?: run {
                        Log.e("UserProfileViewModel", "Profile response body is null")
                    }
                } else {
                    // 오류 발생 시 로그 출력
                    Log.e("UserProfileViewModel", "Error: ${response.code} - ${response.message}")
                }
            } catch (e: Exception) {
                // 예외 발생 시 로그 출력
                Log.e("UserProfileViewModel", "Exception: ${e.message}")
            }
        }
        return _profile
    }


    // 프로필 데이터 업데이트
    fun updateProfile(response: ProfileResponse) {
        _profile.value = response
    }

}
