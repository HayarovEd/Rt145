package com.timme.sports.qui.zisob.tsqz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.timme.sports.qui.zisob.tsqz.data.resitory.RemoteRepositoryRt145Impl
import com.timme.sports.qui.zisob.tsqz.domain.repository.RemoteRepositoryRt145
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RasdRtDiMmmoduleRt145 {

    @Binds
    @Singleton
    abstract fun fghbindRepositoryRt145(repositoryRt145: RemoteRepositoryRt145Impl): RemoteRepositoryRt145


}