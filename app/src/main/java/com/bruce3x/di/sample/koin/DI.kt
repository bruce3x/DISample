package com.bruce3x.di.sample.koin

import android.app.Application
import com.bruce3x.di.sample.ConfigLocalDataSource
import com.bruce3x.di.sample.ConfigLocalDataSourceImpl
import com.bruce3x.di.sample.ConfigRemoteDataSource
import com.bruce3x.di.sample.ConfigRemoteDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module


val configRepositoryModule = module {
    single<ConfigLocalDataSource> { ConfigLocalDataSourceImpl() }
    factory<ConfigRemoteDataSource> { ConfigRemoteDataSourceImpl() }

    factory { ConfigRepository(get(), get()) }
}


fun installKoin(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(configRepositoryModule)
    }
}