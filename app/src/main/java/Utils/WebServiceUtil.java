package Utils;

import WebService.IWebService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexsander on 03/12/2017.
 */

public class WebServiceUtil {

    public IWebService getiWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IWebService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IWebService.class);
    }
}
