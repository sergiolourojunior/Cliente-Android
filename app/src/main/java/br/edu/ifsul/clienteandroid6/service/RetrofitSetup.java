package br.edu.ifsul.clienteandroid6.service;

import android.util.Log;

import java.lang.reflect.GenericArrayType;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ubuntu on 04/05/18.
 */

public class RetrofitSetup {

    private final Retrofit retrofit;

    public RetrofitSetup()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder().baseUrl("http://192.168.15.11/webservice/").addConverterFactory(GsonConverterFactory.create()).client(client.build()).build();
    }
    public ProjetoService getProjetoService()
    {
        return retrofit.create(ProjetoService.class);
    }


}
