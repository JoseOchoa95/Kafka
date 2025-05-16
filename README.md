# Comunicación Kafka entre Microservicios (Spring Boot 3.4.5 + Java 21)

![Java](https://img.shields.io/badge/Java-21-red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-green)
![Kafka](https://img.shields.io/badge/Apache_Kafka-2.8.0-blue)

Ejemplo mínimo de comunicación entre microservicios usando Apache Kafka como broker de mensajería.

## Diagrama de Arquitectura

```ascii
┌─────────────────┐       ┌─────────────┐       ┌─────────────────┐
│                 │       │             │       │                 │
│   Provider      │───────▶   Kafka     │───────▶   Consumer      │
│   (Publisher)   │       │   Broker    │       │   (Subscriber)  │
│                 │       │             │       │                 │
└─────────────────┘       └─────────────┘       └─────────────────┘
      │                                           ▲
      │                                           │
      └───────────Publica mensaje─────────────────┘
                  al arranque                  Escucha continuamente