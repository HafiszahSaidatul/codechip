package unpas.ac.id.codechip.networks

import unpas.ac.id.codechip.model.Mobil
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.*

interface MobilApi {
    @GET("api/dosen")
    suspend fun all(): ApiResponse<MobilGetResponse>

    @GET("api/dosen/{id}")
    suspend fun find(@Path("id") id: String): ApiResponse<MobilSingleGetResponse>

    @POST("api/dosen")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Mobil): ApiResponse<MobilSingleGetResponse>

    @PUT("api/dosen/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: Mobil): ApiResponse<MobilSingleGetResponse>

    @DELETE("api/dosen/{id}")
    suspend fun delete(@Path("id") id: String): ApiResponse<MobilSingleGetResponse>
}