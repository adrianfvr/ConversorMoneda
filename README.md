
# Conversor de Monedas - Consola Java

Proyecto simple en Java que permite convertir monedas y consultar tasas de cambio utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## Descripción

Esta aplicación de consola permite al usuario:

- Convertir una cantidad de una moneda origen a una moneda destino.
- Consultar las tasas de cambio actuales para una moneda base.

La interacción se realiza a través de un menú en consola. La app se conecta a la API externa para obtener información en tiempo real.

---

## Tecnologías y Librerías

- **Java 11+** (usa `java.net.http.HttpClient` para llamadas HTTP)
- [Gson](https://github.com/google/gson) para parsear JSON
- [dotenv-java](https://github.com/cdimascio/dotenv-java) para cargar variables de entorno desde un archivo `.env`

---

## Estructura del Proyecto

- `src/Principal.java` — Clase principal con método `main`, inicia el menú.
- `src/Menu.java` — Maneja la interacción con el usuario (menú, validación de entrada).
- `src/ConsultaAPI.java` — Contiene la lógica para consultar la API externa, realizar conversiones y obtener tasas.
- `.env.example` — Ejemplo de archivo de configuración para la API Key.
- `.gitignore` — Ignora archivos sensibles como `.env`.

---

## Configuración

1. Clona el repositorio:

   ```bash
   git clone https://github.com/adrianfvr/ConversorMoneda.git
   cd ConversorMoneda
   ```

2. Crea un archivo `.env` en la raíz del proyecto basado en `.env.example`:

   ```
   API_KEY=tu_api_key_aqui
   ```

3. Añade tu API Key de [ExchangeRate-API](https://www.exchangerate-api.com/) en el `.env`.

---

## Cómo ejecutar

Puedes compilar y correr el proyecto con tu IDE (IntelliJ IDEA) o desde consola:

```bash
javac -cp ".;libs/gson.jar;libs/dotenv.jar" src/*.java -d out/
java -cp "out/;libs/gson.jar;libs/dotenv.jar" Principal
```

> Nota: Ajusta las rutas de las librerías `.jar` según donde las tengas.

---

## Uso

Al ejecutar, verás un menú con opciones:

```
***** BIENVENIDO AL CONVERTIDOR DE MONEDAS *****
1. Convertir Moneda
2. Obtener Tasas de Cambio
3. Salir
Seleccione una opción:
```

- **Convertir Moneda**: Solicita código de moneda origen, destino y cantidad, y muestra el resultado.
- **Obtener Tasas de Cambio**: Muestra todas las tasas actuales para la moneda base ingresada.
- **Salir**: Finaliza el programa.

---

## Buenas prácticas

- No subas tu archivo `.env` con la API key a repositorios públicos.
- Usa `.gitignore` para ignorar `.env`.
- Si por accidente subes tu API key, revoca la clave y genera una nueva en el proveedor de la API.

---

## Contacto

Si tienes preguntas o sugerencias, no dudes en abrir un issue o contactarme.

---

¡Gracias por usar el Conversor de Monedas!
