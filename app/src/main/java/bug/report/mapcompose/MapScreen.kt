package bug.report.mapcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.amap.api.maps.model.CameraPosition
import com.amap.api.maps.model.LatLng
import com.melody.map.gd_compose.GDMap
import com.melody.map.gd_compose.poperties.MapUiSettings
import com.melody.map.gd_compose.position.rememberCameraPositionState


@Composable
fun MapScreen() {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(22.5429, 114.0596), 12f)
    }

    // TODO: 这里设置了 isZoomEnabled 为 false（其实默认就是 false，不知道为什么没生效）。
    var mapUiSettings by remember {
        mutableStateOf(MapUiSettings(isZoomEnabled = false, myLocationButtonEnabled = true))
    }


    Box(Modifier.fillMaxSize()) {
        GDMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = mapUiSettings
        )
        Column(
            Modifier
                .background(Color.White)
                .systemBarsPadding()
        ) {
            Button(onClick = {
                mapUiSettings = mapUiSettings.copy(isZoomEnabled = !mapUiSettings.isZoomEnabled)
            }) {
                Text("change")
            }
            // TODO: 这里在屏幕上展示了 isZoomEnabled 的当前值
            Text(text = "isZoomEnabled: ${mapUiSettings.isZoomEnabled}")
        }
    }
}