# **Project Game: Servicio de Construcción 🏗️🎮**

Este proyecto es un juego de simulación en Java utilizando JavaFX, donde el jugador administra un presupuesto 💰 para construir diferentes servicios 🏢 en un mapa. El jugador puede elegir entre varias opciones de servicios y colocarlos en un mapa interactivo. El juego cuenta con un sistema de presupuesto que se reduce cada vez que el jugador construye un nuevo servicio, y el tiempo pasa mientras se juega ⏳.

## **Características del Proyecto 🚀**

- **Mapa Interactivo 🗺️:** El jugador puede colocar y demoler diferentes tipos de servicios en un mapa representado por un `GridPane`. El mapa contiene tiles que el jugador puede modificar al hacer clic.

- **Servicios Personalizados 🏗️:** Los servicios disponibles en el juego se cargan desde un archivo externo (`servicios.txt`). Cada servicio tiene una imagen 🖼️ y un costo asociado tanto para su construcción como para su mantenimiento mensual.

- **Presupuesto Dinámico 💸:** El jugador comienza con un presupuesto que depende de la dificultad elegida (Fácil, Medio, Difícil). El presupuesto se va reduciendo cada vez que el jugador construye un servicio, y se muestra en tiempo real.

- **Tiempo ⏰:** El tiempo pasa continuamente mientras se juega, lo que puede afectar el desarrollo del juego o el estado de los servicios.

- **Guardar Progreso 💾:** El juego permite guardar el progreso de la partida en un archivo binario, lo que permite retomar el juego más tarde.

- **Alertas y Confirmaciones ⚠️:** Se utilizan alertas para confirmar las acciones del jugador, como la construcción o demolición de un servicio.

## **Tecnologías Utilizadas 💻**

- **Java 8:** El proyecto está desarrollado en Java, utilizando clases y funcionalidades estándar del lenguaje.
  
- **JavaFX:** Para la interfaz gráfica de usuario (GUI), se utilizan componentes de JavaFX, como `AnchorPane`, `GridPane`, `Button`, `Label`, `ComboBox`, y más.
  
- **Serialización 🔄:** Se utiliza la serialización de objetos en Java para guardar el estado del mapa y los servicios en un archivo binario.

## **Instrucciones de Instalación ⚙️**

1. **Instalar Java 8 o superior ☕:**  
   Asegúrate de tener instalado Java 8 o una versión superior. Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).

2. **Clonar el repositorio 📂:**  
   Clona el repositorio para obtener todos los archivos necesarios para ejecutar el juego.  
   ```bash
   git clone https://github.com/tuusuario/ProjectGame.git
