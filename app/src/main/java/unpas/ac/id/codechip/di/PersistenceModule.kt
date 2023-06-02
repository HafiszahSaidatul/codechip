package unpas.ac.id.codechip.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import unpas.ac.id.codechip.networks.SepedaMotorApi
import unpas.ac.id.codechip.persistences.AppDatabase
import unpas.ac.id.codechip.persistences.MobilDao
import unpas.ac.id.codechip.persistences.PromoDao
import unpas.ac.id.codechip.persistences.SepedaMotorDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "perkuliahan"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
//    dosen
    @Provides
    @Singleton
    fun provideMobilDao(appDatabase: AppDatabase): MobilDao {
        return appDatabase.mobilDao()
    }

//    mahasiswa
    @Provides
    @Singleton
    fun providePromoDao(appDatabase: AppDatabase): PromoDao {
        return appDatabase.promoDao()
    }
//    matkul
    @Provides
    @Singleton
    fun provideSepedaMotorDao(appDatabase: AppDatabase): SepedaMotorDao {
        return appDatabase.sepedamotorDao()
    }
}