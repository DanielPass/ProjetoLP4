package WebService;

import android.util.Base64;

import com.steplab.projetolpiv.projetolpiv.NewProductActivity;

import Model.LoginAnswer;
import Model.NewItemAnswer;
import Utils.Database;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Alexsander on 02/12/2017.
 */

public interface IWebService {

    public final String URL_BASE = "http://apilp4-env.6sgg6raaea.sa-east-1.elasticbeanstalk.com/";

    @FormUrlEncoded
    @POST("login")
    Call<LoginAnswer> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("item")
    Call<NewItemAnswer> newProd(
            @Header("Authorization") String Authorization,
            @Field("name") String name,
            @Field("category") int category,
            @Field("description") String description,
            @Field("photos") String photos,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );

}
