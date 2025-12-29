const PubNub = require("pubnub");

// Chaves do PubNub
const pubnub = new PubNub({
  publishKey: "pub-c-39c2c14f-2155-4d57-98e9-d5fda77f775d",
  subscribeKey: "sub-c-3e6d12b8-bdf2-4b25-8db9-c57e728a2b2e",
  uuid: "fog-gateway-001",
});

// Canais
const SENSOR_CHANNEL = "sensor-temperature";
const CONTROL_CHANNEL = "device-control";

// Escutar comandos vindos do Android
pubnub.subscribe({
  channels: [CONTROL_CHANNEL],
});

pubnub.addListener({
  message: function (event) {
    const msg = event.message;

    console.log("📥 Comando recebido:", msg.command);

    if (msg.command === "LED_ON") {
      console.log("🔴 LED LIGADO (simulado)");
    }

    if (msg.command === "LED_OFF") {
      console.log("⚫ LED DESLIGADO (simulado)");
    }
  },
});

// Simular leitura do sensor
function simulateTemperature() {
  const temperature = (20 + Math.random() * 10).toFixed(2);

  const payload = {
    deviceId: "arduino-001",
    temperature: Number(temperature),
    timestamp: new Date().toISOString(),
  };

  pubnub.publish(
    {
      channel: SENSOR_CHANNEL,
      message: payload,
    },
    () => {
      console.log("📤 Temperatura enviada:", payload.temperature);
    }
  );
}

// Enviar temperatura a cada 3 segundos
setInterval(simulateTemperature, 3000);
