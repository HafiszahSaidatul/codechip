package unpas.ac.id.codechip.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import unpas.ac.id.codechip.model.Promo


@Dao
interface PromoDao {
    @Query("SELECT * FROM Mahasiswa ORDER BY npm DESC")
    fun loadAll(): LiveData<List<Promo>>
    @Query("SELECT * FROM Mahasiswa ORDER BY npm DESC")
    suspend fun getList(): List<Promo>
    @Query("SELECT * FROM Mahasiswa WHERE id = :id")
    suspend fun find(id: String): Promo?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Promo)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Promo>)
    @Delete
    fun delete(item: Promo)
    @Query("DELETE FROM Mahasiswa WHERE id = :id")
    suspend fun delete(id: String)
}