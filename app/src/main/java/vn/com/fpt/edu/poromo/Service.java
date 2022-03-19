package vn.com.fpt.edu.poromo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;
import vn.com.fpt.edu.poromo.login.model.*;

public interface Service {
    @GET("/prm/api/v1.0/product/images/")
    Call<List<ProductDAO>> getOneProduct(@Query("product_id") String id);

    @POST("prm/api/v1.0/customer/login")
    Call<User> logIn(@Query("username") String username, @Query("password") String password);
}
