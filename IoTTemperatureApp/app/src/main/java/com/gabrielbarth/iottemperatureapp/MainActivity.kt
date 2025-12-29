package com.gabrielbarth.iottemperatureapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.pubnub.api.PNConfiguration
import com.pubnub.api.PubNub
import com.pubnub.api.callbacks.SubscribeCallback
import com.pubnub.api.models.consumer.PNStatus
import com.pubnub.api.models.consumer.pubsub.PNMessageResult

class MainActivity : ComponentActivity() {


    private val pubnub: PubNub by lazy {
        val config = PNConfiguration(
            uuid = "android-compose-001"
        ).apply {
            publishKey = "pub-c-39c2c14f-2155-4d57-98e9-d5fda77f775d"
            subscribeKey = "sub-c-3e6d12b8-bdf2-4b25-8db9-c57e728a2b2e"
        }
        PubNub(config)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temperatureState = mutableStateOf("--")

        // Subscribe temperatura
        pubnub.subscribe(
            channels = listOf("sensor-temperature")
        )

        pubnub.addListener(object : SubscribeCallback() {

            override fun status(pubnub: PubNub, status: PNStatus) {
                Log.d("PUBNUB_STATUS", status.category.name)
            }

            override fun message(pubnub: PubNub, message: PNMessageResult) {
                val temp = message.message
                    .asJsonObject["temperature"]
                    .asDouble
                temperatureState.value = temp.toString()
            }
        })

//        pubnub.addListener(object : SubscribeCallback() {
//            override fun message(pubnub: PubNub, message: PNMessageResult) {
//                val temp = message.message
//                    .asJsonObject["temperature"]
//                    .asDouble
//                temperatureState.value = temp.toString()
//            }
//
//            override fun status(pubnub: PubNub, status: PNStatus) {}
//        })

        setContent {
            MaterialTheme {
                IoTScreen(
                    temperature = temperatureState.value,
                    onLedOn = { sendCommand("LED_ON") },
                    onLedOff = { sendCommand("LED_OFF") }
                )
            }
        }
    }

    private fun sendCommand(command: String) {
        Log.d("PUBNUB_PUBLISH", "Tentando enviar: $command")

        pubnub.publish(
            channel = "device-control",
            message = mapOf("command" to command)
        ).async { _, status ->
            if (status.error) {
                Log.e("PUBNUB_PUBLISH", "Erro ao enviar")
            } else {
                Log.d("PUBNUB_PUBLISH", "ENVIADO COM SUCESSO")
            }
        }
    }
}
