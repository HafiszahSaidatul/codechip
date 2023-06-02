package unpas.ac.id.codechip.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import unpas.ac.id.codechip.model.Mobil


@Dao
interface MobilDao {
    @Query("SELECT * FROM Dosen ORDER BY nidn DESC")
    fun loadAll(): LiveData<List<Mobil>>
    @Query("SELECT * FROM Dosen ORDER BY nidn DESC")
    suspend fun getList(): List<Mobil>
    @Query("SELECT * FROM Dosen WHERE id = :id")
    suspend fun find(id: String): Mobil?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Mobil)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Mobil>)
    @Delete
    fun delete(item: Mobil)
    @Query("DELETE FROM Dosen WHERE id = :id")
    suspend fun delete(id: String)
}