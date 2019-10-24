package com.bruce3x.di.sample.dagger2

import com.bruce3x.di.sample.*
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConfigRepositoryModule {

    @Provides
    @Singleton
    fun local(): ConfigLocalDataSource = ConfigLocalDataSourceImpl()

    @Provides
    fun remote(): ConfigRemoteDataSource = ConfigRemoteDataSourceImpl()
}


@Component(modules = [ConfigRepositoryModule::class])
@Singleton
interface ConfigRepositoryComponent {
    fun inject(activity: MainActivity)
}

