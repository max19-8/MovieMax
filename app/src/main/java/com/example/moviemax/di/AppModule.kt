package com.example.moviemax.di

import android.content.Context
import com.example.moviemax.model.api.MovieApi
import com.example.moviemax.utils.BASE_URL_MOVIE
import com.example.moviemax.view.provider.ResourceProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProvider.Base(context)

    @Provides
    @Singleton
    fun getRetrofitInstance(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_MOVIE)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}