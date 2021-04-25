package hr.mosaicapps.notesy

import android.app.Application
import hr.mosaicapps.notesy.di.appModules
import hr.mosaicapps.notesy.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Notesy : Application() {

    companion object{
        lateinit var application: Notesy
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        startKoin {
            androidContext(this@Notesy)
            androidLogger()
            modules(appModules, viewModelModules)
        }
    }
}