package co.com.meli.mobile.pruebameli

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.com.meli.mobile.pruebameli.ui.welcome.WelcomeActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@BaseApplication)
            modules(

                )
        }

    }
}