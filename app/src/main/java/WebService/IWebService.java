package WebService;

import Model.LoginAnswer;
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
}
