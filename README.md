# 💧 AiguaApp
### Gestión sostenible del agua en Cataluña – Hackathon 2025  

---

## 🌍 Contexto

**AiguaApp** es una aplicación web orientada a la **monitorización y concienciación sobre el consumo de agua** en barrios de Cataluña.  
Forma parte del **Reto 3 – Gestión sostenible de los recursos hídricos**, alineado con los **ODS 6 (Agua limpia y saneamiento)** y **ODS 13 (Acción por el clima)**.

> *“El agua también tiene un ritmo.”*  
> La aplicación muestra el ritmo de consumo por barrio y detecta cuándo ese ritmo se altera.

---

## ⚙️ Arquitectura general

| Capa | Tecnología | Descripción |
|------|-------------|-------------|
| **Frontend** | React + Leaflet | Visualización de datos (mapa, gráficas, alertas) |
| **Backend** | Spring Boot (Java 17) | API REST que expone los datos de consumo y anomalías |
| **Data Layer** | JSON mock / H2 temporal | Simulación de datos por barrios |
| **Service Layer** | Lógica de negocio | Cálculo de totales, porcentajes y tipos de uso |
| **Controller Layer** | Endpoints REST | Exposición de `/api/consumption`, `/api/anomalies`, `/api/summary` |

---

##  Estructura del backend

```
src/main/java/com/aigua/aiguaapp/
 ├── controller/
 │     ├── WaterConsumptionController.java
 │     ├── AnomalyController.java
 │     └── SummaryController.java
 │
 ├── service/
 │     ├── WaterConsumptionService.java
 │     └── AnomalyService.java
 │
 ├── repository/
 │     ├── JsonWaterConsumptionRepository.java
 │     └── JsonAnomalyRepository.java
 │
 ├── model/
 │     ├── WaterConsumption.java
 │     └── Anomaly.java
 │
 ├── dto/
 │     └── SummaryDTO.java
 │
 └── util/
       └── JsonDataLoader.java
```

---

## 📊 Endpoints REST

| Método | Endpoint | Descripción | Devuelve |
|--------|-----------|-------------|-----------|
| `GET` | `/api/consumption` | Lista todos los consumos registrados | JSON con consumos |
| `GET` | `/api/anomalies` | Lista todas las anomalías detectadas | JSON con alertas |
| `GET` | `/api/summary` | Calcula resumen dinámico (litros, porcentajes, tipo de uso) | JSON con resumen |

---

## 💾 Datos simulados (JSON)

Los archivos JSON se encuentran en:

```
src/main/resources/
 ├── consumption.json
 └── anomalies.json
```

Cada vez que se hace una petición, el backend **lee los JSON directamente** y genera las respuestas sin necesidad de base de datos.

---

## 🚀 Ejecución local

### 🔧 Requisitos
- Java 17+
- Maven 3.9+
- IntelliJ IDEA o VSCode con soporte Spring Boot

### ▶️ Ejecutar la aplicación

Desde la terminal del proyecto:
```bash
./mvnw spring-boot:run
```

o desde IntelliJ, ejecutando la clase:
```
AiguaAppApplication.java
```

El servidor se levanta por defecto en:
```
http://localhost:8080
```

### 🌐 Probar con Postman o navegador

- [http://localhost:8080/api/consumption](http://localhost:8080/api/consumption)  
- [http://localhost:8080/api/anomalies](http://localhost:8080/api/anomalies)  
- [http://localhost:8080/api/summary](http://localhost:8080/api/summary)

---

## 🧮 Ejemplo de respuesta `/api/summary`

```json
[
  {
    "neighborhood": "Eixample",
    "totalLiters": 2100.0,
    "percentageOfCity": 18.5,
    "mainUsageType": "industrial"
  }
]
```

---

## 📦 Dependencias principales

- Spring Boot Starter Web  
- Jackson Datatype JSR310  
- Lombok *(opcional)*  
- H2 Database *(opcional para pruebas)*  

---

## 🧠 Lógica de negocio

El servicio `WaterConsumptionService`:
1. Lee los consumos desde `consumption.json`.
2. Agrupa los datos por barrio.
3. Calcula el total global y los porcentajes.
4. Detecta el tipo de uso predominante.
5. Devuelve una lista de `SummaryDTO`.

---

## 👥 Equipo y créditos

---

## 🧾 Licencia
Este proyecto se distribuye bajo licencia **MIT**.  
Podés usarlo y modificarlo libremente citando la fuente.

```
