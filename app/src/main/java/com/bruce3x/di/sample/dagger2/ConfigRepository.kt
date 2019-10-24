package com.bruce3x.di.sample.dagger2

import com.bruce3x.di.sample.ConfigLocalDataSource
import com.bruce3x.di.sample.ConfigRemoteDataSource
import javax.inject.Inject

class ConfigRepository @Inject constructor(
    private val local: ConfigLocalDataSource,
    private val remote: ConfigRemoteDataSource
) {
    fun getConfig(key: String): String {
        val cache = local.getConfig(key)
        if (cache != null) return cache

        val value = remote.fetchConfig(key)
        local.saveConfig(key, value)
        return value
    }
}