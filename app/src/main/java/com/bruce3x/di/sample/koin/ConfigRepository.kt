package com.bruce3x.di.sample.koin

import com.bruce3x.di.sample.ConfigLocalDataSource
import com.bruce3x.di.sample.ConfigRemoteDataSource

class ConfigRepository(
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