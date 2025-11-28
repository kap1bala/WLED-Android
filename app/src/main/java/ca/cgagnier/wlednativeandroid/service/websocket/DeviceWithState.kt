package ca.cgagnier.wlednativeandroid.service.websocket

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ca.cgagnier.wlednativeandroid.model.Device
import ca.cgagnier.wlednativeandroid.model.wledapi.DeviceStateInfo

const val AP_MODE_MAC_ADDRESS = "AP-MODE"

class DeviceWithState(initialDevice: Device) {
    var device: Device by mutableStateOf(initialDevice)
    val stateInfo: MutableState<DeviceStateInfo?> = mutableStateOf(null)
    val isWebsocketConnected: MutableState<Boolean> = mutableStateOf(false)
    // TODO: Add websocket connection status, like offline/online/connecting

    fun isAPMode(): Boolean {
        return device.macAddress == AP_MODE_MAC_ADDRESS
    }
}

/**
 * Get a DeviceWithState that can be used to represent a temporary WLED device in AP mode.
 */
fun getApModeDeviceWithState(): DeviceWithState {
    val device = DeviceWithState(
        Device(
            macAddress = AP_MODE_MAC_ADDRESS,
            address = "4.3.2.1",
        )
    )
    device.isWebsocketConnected.value = true

    return device
}