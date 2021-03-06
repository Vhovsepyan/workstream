package org.behive.com.workstream_platform.http;

import org.behive.com.workstream_platform.utils.AppLog;
import org.behive.com.workstream_platform.utils.SharedPrefs;
import org.behive.com.workstream_platform.utils.UrlConstants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiFactory {
    private static final String TAG = RestApiFactory.class.getSimpleName();
    private static RestApi restApi;

    private static RestApi create() {
        String token = SharedPrefs.getInstance().getString(SharedPrefs.Constants.IS_USER_LOGGED_IN_KEY, "");
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", token)
                    .build();
            return chain.proceed(request);
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit.create(RestApi.class);
    }

    public static RestApi getRestApi() {
        if (restApi == null) {
            restApi = RestApiFactory.create();
            AppLog.i(TAG + " getRestApi API created ");
        }
        return restApi;
    }

    public static void recreateRestApi(){
        restApi = RestApiFactory.create();
        AppLog.i(TAG + " recreateRestApi API created ");
    }
}
