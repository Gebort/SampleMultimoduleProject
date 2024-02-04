package com.gerbort.networking.domain.di

import com.gerbort.networking.BuildConfig
import com.gerbort.networking.data.BASE_URL
import com.gerbort.networking.data.RetrofitApi
import com.gerbort.networking.data.RetrofitDataSource
import com.gerbort.networking.domain.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkingModule {

    @Provides
    @Singleton
    internal fun provideNetworkDataSource(
        retrofitApi: RetrofitApi
    ): NetworkDataSource {
        return RetrofitDataSource(retrofitApi)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        if (BuildConfig.DEBUG) {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        } }
            )
            .writeTimeout(0, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS)
            .build()

    }

    @Provides
    @Singleton
    internal fun provideRetrofitApi(client: OkHttpClient): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()

    }

}