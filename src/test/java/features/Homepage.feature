Feature: Funcionalidades de la página de inicio de Cines Imperial

  Background:
    Given el usuario ha abierto el navegador
    And el usuario está en la página principal de "https://www.cinesimperial.com/"

  Scenario: Navegación a las redes sociales desde la página de inicio
    When el usuario hace clic en el icono de "Facebook"
    Then el usuario debería ser dirigido a la página de Facebook de Cines Imperial
    When el usuario hace clic en el icono de "Twitter"
    Then el usuario debería ser dirigido a la página de Twitter de Cines Imperial
    When el usuario hace clic en el icono de "Instagram"
    Then el usuario debería ser dirigido a la página de Instagram de Cines Imperial

  Scenario: Funcionamiento de las flechas del carrusel de imágenes
    When el usuario hace clic en la flecha "derecha" del carrusel
    Then el carrusel debería desplazarse a la siguiente imagen
    When el usuario hace clic en la flecha "izquierda" del carrusel
    Then el carrusel debería desplazarse a la imagen anterior

  Scenario: Cambio entre vista de póster y lista de películas
    When el usuario selecciona la opción "Vista Póster"
    Then se deberían mostrar las películas en formato de póster
    When el usuario selecciona la opción "Vista Lista"
    Then se deberían mostrar las películas en formato de lista


  Scenario: Usuario visualiza detalles y realiza acciones para la película BEEKEEPER: EL PROTECTOR
    Given el usuario está en la sección "Cartellera" de la página principal
    When el usuario hace clic en la película "BEEKEEPER: EL PROTECTOR"
    Then se muestran los detalles de la película incluyendo "Durada", "Classificació" y horarios disponibles para el día actual
    When el usuario selecciona la hora "18:15"
    Then se activa la opción para seleccionar asientos para esa función
    When el usuario hace clic en "VEURE MÉS DIES"
    Then se muestran todos los días disponibles con sus respectivos horarios
    When el usuario hace clic en "TRAILER"
    Then se reproduce el tráiler de la película
    When el usuario hace clic en "COMPRAR"
    Then se inicia el proceso de compra de entradas para la película
