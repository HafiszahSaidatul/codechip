package unpas.ac.id.codechip.networks

import unpas.ac.id.codechip.model.Promo
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import unpas.ac.id.codechip.model.SepedaMotor

interface SepedaMotorApi {
    @GET("api/matakuliah")
    suspend fun all(): ApiResponse<SepedaMotorGetResponse>
    @GET("api/matakuliah/{id}")
    suspend fun find(@Path("id") id: String):
            ApiResponse<SepedaMotorSingleGetResponse>
    @POST("api/matakuliah")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: SepedaMotor):
            ApiResponse<SepedaMotorSingleGetResponse>
    @PUT("api/matakuliah/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: SepedaMotor):
            ApiResponse<SepedaMotorSingleGetResponse>
    @DELETE("api/matakuliah/{id}")
    suspend fun delete(@Path("id") id: String):
            ApiResponse<SepedaMotorSingleGetResponse>
}