package com.bruce3x.di.sample


interface ConfigLocalDataSource {
    fun getConfig(key: String): String?
    fun saveConfig(key: String, value: String)
}

interface ConfigRemoteDataSource {
    fun fetchConfig(key: String): String
}


class ConfigLocalDataSourceImpl : ConfigLocalDataSource {
    private val cache = hashMapOf<String, String>()
    override fun getConfig(key: String): String? = cache[key]
    override fun saveConfig(key: String, value: String) = cache.set(key, value)
}

class ConfigRemoteDataSourceImpl : ConfigRemoteDataSource {
    override fun fetchConfig(key: String): String {
        // simulate fetch data from remote
        return "config of $key"
    }
}

