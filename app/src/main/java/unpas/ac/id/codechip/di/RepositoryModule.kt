package unpas.ac.id.codechip.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import unpas.ac.id.codechip.model.SepedaMotor
import unpas.ac.id.codechip.networks.MobilApi
import unpas.ac.id.codechip.networks.PromoApi
import unpas.ac.id.codechip.networks.SepedaMotorApi
import unpas.ac.id.codechip.persistences.MobilDao
import unpas.ac.id.codechip.persistences.PromoDao
import unpas.ac.id.codechip.persistences.SepedaMotorDao
import unpas.ac.id.codechip.repositories.MobilRepository
import unpas.ac.id.codechip.repositories.PromoRepository
import unpas.ac.id.codechip.repositories.SepedaMotorRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
//    dosen
    @Provides
    @ViewModelScoped
    fun provideMobilRepository(
    api: MobilApi,
    dao: MobilDao
    ): MobilRepository {
        return MobilRepository(api, dao)
    }

//    mahasiswa
    @Provides
    @ViewModelScoped
    fun providePromoRepository(
    api: PromoApi,
    dao: PromoDao
    ): PromoRepository {
        return PromoRepository(api, dao)
    }

//    matkul
    @Provides
    @ViewModelScoped
    fun provideSepedaMotorRepository(
    api: SepedaMotorApi,
    dao: SepedaMotorDao
    ): SepedaMotorRepository {
        return SepedaMotorRepository(api, dao)
    }
}