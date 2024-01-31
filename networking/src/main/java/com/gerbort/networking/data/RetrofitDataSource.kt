package com.gerbort.networking.data

import com.gerbort.networking.domain.NetworkDataSource
import com.gerbort.networking.domain.model.UserInfoNetwork
import com.gerbort.common.logging.log
import retrofit2.Response
import retrofit2.http.GET

internal const val BASE_URL = "http://test.com"

interface RetrofitApi {

    @GET
    suspend fun getUserInfo(): Response<UserInfoNetwork>

}

class RetrofitDataSource(
    private val retrofitApi: RetrofitApi
): NetworkDataSource {

    override suspend fun getUserInfo(): UserInfoNetwork? {
        return executeRequest("getUserInfo") {
            retrofitApi.getUserInfo()
        }.getOrNull()
    }

}

private suspend fun <T> executeRequest(label: String, request: suspend () -> Response<T>): Result<T> {
    try {
        val res = request()
        when {
            res.isSuccessful && res.body() != null -> {
                res.log("$label запрос, успех")
                return Result.success(res.body()!!)
            }
            else -> {
                res.log("$label запрос, ошибка код ${res.code()}")
                return Result.failure(Exception())
            }
        }
    } catch (e: Exception) {
        e.log("$label запрос, ошибка ${e.localizedMessage} ")
        return Result.failure(e)
    }


}