package unpas.ac.id.codechip.networks

import unpas.ac.id.codechip.model.SepedaMotor
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import unpas.ac.id.codechip.model.Promo

interface PromoApi {
    @GET("api/dosen")
    suspend fun all(): ApiResponse<PromoGetResponse>

    @GET("api/dosen/{id}")
    suspend fun find(@Path("id") id: String): ApiResponse<PromoSingleGetResponse>

    @POST("api/dosen")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Promo): ApiResponse<PromoSingleGetResponse>

    @PUT("api/dosen/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: Promo
    ): ApiResponse<PromoSingleGetResponse>

    @DELETE("api/dosen/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<PromoSingleGetResponse>
}