package co.uk.happyapper.rotaspacex.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import co.uk.happyapper.rotaspacex.Models.Rocket;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;



public interface RocketAPI {

    String base_url = "https://api.spacexdata.com/v3/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OKClient.getInstance())
            .build();

    @GET("rockets")
    Call<ArrayList<Rocket>> getRockets();

}