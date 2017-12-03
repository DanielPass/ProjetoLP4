package WebService;

import android.util.Base64;

import Model.LoginAnswer;
import Model.NewItemAnswer;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Alexsander on 02/12/2017.
 */

public interface IWebService {

    public static final String URL_BASE = "http://apilp4-env.6sgg6raaea.sa-east-1.elasticbeanstalk.com/";

    @FormUrlEncoded
    @POST("login")
    Call<LoginAnswer> login(@Field("email") String email, @Field("password") String password);

    @POST("item")
    Call<NewItemAnswer> newProd(
            @Field("name") String name,
            @Field("category") int category,
            @Field("description") String description,
            @Field("photos") Base64 photos,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );

}
