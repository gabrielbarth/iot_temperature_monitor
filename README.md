## 📡 Projeto IoT – Integração Edge, Fog e Cloud com Android, PubNub e Arduino (Simulado)

### 📌 Visão Geral

Este projeto apresenta uma solução completa de Internet das Coisas (IoT), desenvolvida como trabalho individual de pós-graduação, contemplando as três camadas clássicas de IoT: Edge Computing, Fog Computing e Cloud Computing.

A solução demonstra a integração entre sensores, atuadores e um aplicativo Android, utilizando comunicação em tempo real via internet. Todo o sistema foi desenvolvido de forma funcional e didática, com parte da infraestrutura simulada, conforme permitido pelo escopo do trabalho.

### 🏗️ Arquitetura da Solução

A arquitetura do sistema está dividida da seguinte forma:

### 🔹 Edge Computing (Dispositivo IoT)

Representado por um Arduino UNO simulado no Tinkercad

Contém um LED (atuador)

O Arduino executa a lógica de acionamento do LED a partir de comandos recebidos

A simulação utiliza o Monitor Serial para representar a entrada de comandos externos

### 🔹 Fog Computing (Gateway)

Representado por um Fog Gateway lógico

Responsável por:

Receber comandos vindos da nuvem

Interpretar e encaminhar esses comandos ao dispositivo Edge

No ambiente simulado, o Fog Gateway é abstraído para simplificar a solução, mantendo o foco no fluxo de dados

### 🔹 Cloud Computing

Utiliza a plataforma PubNub

Responsável pela mensageria em tempo real

Gerencia canais de comunicação para:

Envio de comandos

Recebimento de status

Permite comunicação assíncrona e escalável entre dispositivos

### 📱 Aplicativo Android

Desenvolvido em Kotlin

Interface construída com Jetpack Compose

Funções principais:

Enviar comandos (ligar/desligar LED)

Comunicar-se com a nuvem via PubNub

O aplicativo representa o controle remoto do dispositivo IoT, simulando um cenário real de automação

### 🔁 Fluxo de Comunicação

```
Usuário
  ↓
Aplicativo Android (Compose)
  ↓
PubNub (Cloud)
  ↓
Fog Gateway (lógico)
  ↓
Arduino (Edge - Tinkercad)
  ↓
LED (Atuador)
```

No ambiente de simulação, o comando final é inserido manualmente no Monitor Serial do Tinkercad, representando a ação que seria realizada automaticamente pelo Fog Gateway em um ambiente real.

### 🧪 Simulação com Tinkercad

O Arduino e o LED são simulados no Tinkercad

O LED é acionado a partir de comandos simples:

1 → LED ligado

0 → LED desligado

Esses comandos representam mensagens vindas do Fog Gateway

Essa abordagem permite validar a lógica do sistema sem necessidade de hardware físico, mantendo fidelidade ao funcionamento real.

### 🎯 Objetivos Atendidos
✔️ Uso das três camadas de IoT (Edge, Fog e Cloud)

✔️ Integração com a internet

✔️ Comunicação em tempo real

✔️ Uso de sensores/atuadores (simulados)

✔️ Projeto funcional e didático

✔️ Aplicação prática de conceitos de IoT

### 📽️ Demonstração

O projeto conta com um vídeo não listado no YouTube, demonstrando:

O funcionamento do aplicativo Android

A comunicação via PubNub

A simulação do acionamento do LED no Arduino

### 🚀 Considerações Finais

Este projeto demonstra, de forma clara e objetiva, como uma solução IoT pode ser estruturada utilizando tecnologias modernas, boas práticas de arquitetura e simulação de hardware, sendo totalmente aderente aos requisitos propostos para o trabalho acadêmico.
