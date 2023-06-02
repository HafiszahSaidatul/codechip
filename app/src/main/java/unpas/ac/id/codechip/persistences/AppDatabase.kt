package unpas.ac.id.codechip.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import unpas.ac.id.codechip.model.Mobil
import unpas.ac.id.codechip.model.SepedaMotor
import unpas.ac.id.codechip.model.Promo

@Database(entities = [Promo::class, Mobil::class, SepedaMotor::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    Mobil
    abstract fun mobilDao(): MobilDao
//    Promo
    abstract fun promoDao(): PromoDao
//    SepedaMotor
    abstract fun sepedamotorDao(): SepedaMotorDao

}