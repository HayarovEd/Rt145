package one.win.casino.rt145.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.win.casino.rt145.data.resitory.RemoteRepositoryRt145Impl
import one.win.casino.rt145.domain.repository.RemoteRepositoryRt145
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModuleRt145 {

    @Binds
    @Singleton
    abstract fun bindRepositoryRt145(repositoryRt145: RemoteRepositoryRt145Impl): RemoteRepositoryRt145


}