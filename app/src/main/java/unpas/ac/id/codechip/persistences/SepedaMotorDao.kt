package unpas.ac.id.codechip.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import unpas.ac.id.codechip.model.SepedaMotor

@Dao
interface SepedaMotorDao {
    @Query("SELECT * FROM Matkul ORDER BY kode DESC")
    fun loadAll(): LiveData<List<SepedaMotor>>
    @Query("SELECT * FROM Matkul ORDER BY kode DESC")
    suspend fun getList(): List<SepedaMotor>
    @Query("SELECT * FROM Matkul WHERE id = :id")
    suspend fun find(id: String): SepedaMotor?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: SepedaMotor)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<SepedaMotor>)
    @Delete
    fun delete(item: SepedaMotor)
    @Query("DELETE FROM Matkul WHERE id = :id")
    suspend fun delete(id: String)
}