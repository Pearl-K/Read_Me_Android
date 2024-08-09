package com.example.readme.data.remote

import com.example.readme.data.entities.User
import com.example.readme.ui.community.Chat
import com.google.android.gms.common.api.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

//임시 ApiService
interface ReadmeServerService {
    @POST("yourEndpoint")
    fun postData(@Body data: YourDataClass): Call<ReadmeResponse>

    @GET("yourEndpoint")
    fun getData(): Call<ReadmeResponse>


    @GET("/users/my")
    suspend fun getMyProfile(
        @Header("Authorization") token: String
    ): Call<ProfileResponse>

    @GET("/users/my/shorts")
    suspend fun getMyShorts(): ProfileShortsResponse

    // userId를 경로 매개변수로 받아서 요청
    @GET("/users/{userId}")
    suspend fun getProfile(
        @Path("userId") userId: Int
    ): ProfileResponse


    @GET("/users/{userId}/shorts")
    suspend fun getShorts(
        @Path("userId") userId: String
    ): ProfileShortsResponse

    @POST("communities/{communityId}/messages")
    fun postMessage(@Path("communityId") communityId: String, @Body chat: Chat): Call<Chat>

    @GET("communities/{communityId}/messages")
    fun getMessages(@Path("communityId") communityId: String): Call<List<Chat>>

    companion object {

        //나중에 서버 URL 추가
        const val BASE_URL ="https://api.umcreadme11.shop/"
    }
}