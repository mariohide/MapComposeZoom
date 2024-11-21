package bug.report.mapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import bug.report.mapcompose.ui.theme.MapComposeZoomTheme
import com.amap.api.maps.MapsInitializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        MapsInitializer.updatePrivacyShow(this.applicationContext, true, true)
        MapsInitializer.updatePrivacyAgree(this.applicationContext, true)
        setContent {
            MapComposeZoomTheme {
                MapScreen()
            }
        }
    }
}