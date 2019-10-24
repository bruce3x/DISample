package com.bruce3x.di.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bruce3x.di.sample.dagger2.DaggerConfigRepositoryComponent
import org.koin.android.ext.android.inject
import javax.inject.Inject
import com.bruce3x.di.sample.dagger2.ConfigRepository as DaggerRepository
import com.bruce3x.di.sample.koin.ConfigRepository as KoinRepository
import com.bruce3x.di.sample.manual.ConfigRepository as ManualRepository

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var daggerRepo: DaggerRepository

    private val koinRepo: KoinRepository by inject()

    private val manualRepo: ManualRepository by lazy {
        ManualRepository(
            local = ConfigLocalDataSourceImpl(),
            remote = ConfigRemoteDataSourceImpl()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerConfigRepositoryComponent.create().inject(this)
        setContentView(R.layout.activity_main)

        println("[manual] ping => " + manualRepo.getConfig("ping"))
        println("[dagger] ping => " + daggerRepo.getConfig("ping"))
        println("[ koin ] ping => " + koinRepo.getConfig("ping"))
    }
}
