Feature: Proceso de checkout completo en la web de Cines Imperial

  Background:
    Given el usuario ha abierto el navegador
    And el usuario está en la página principal de "https://www.cinesimperial.com/"

  Scenario: Usuario realiza una compra completa con tarjeta de fidelidad
    When el usuario selecciona la película "BEEKEEPER: EL PROTECTOR"
    And el usuario escoge la sesión del "miércoles" a las "18:15"
    And el usuario indica "2" entradas
    And el usuario selecciona que tiene tarjeta de fidelidad
    And el usuario introduce su correo electrónico y contraseña de fidelidad
    And el usuario completa los datos de contacto
    And el usuario acepta las condiciones de compra
    And el usuario introduce la información de la tarjeta de pago
    And el usuario confirma la compra
    Then se muestra un mensaje de confirmación de compra
    And se presenta la opción de descargar el PDF de la entrada
    When el usuario selecciona la opción de descargar el PDF
    Then el archivo PDF de la entrada se descarga en el sistema del usuario

  Scenario: Usuario realiza una compra para una sesión del miércoles sin tarjeta de fidelidad
    When el usuario selecciona la película "VALLE DE SOMBRAS"
    And el usuario escoge la sesión del "miércoles" a las "20:00"
    And el usuario indica "1" entradas
    And el usuario selecciona que no tiene tarjeta de fidelidad
    And el usuario completa los datos de contacto
    And el usuario acepta las condiciones de compra
    And el usuario introduce la información de la tarjeta de pago
    And el usuario confirma la compra
    Then se muestra un mensaje de confirmación de compra
    And se presenta la opción de descargar el PDF de la entrada
    When el usuario selecciona la opción de descargar el PDF
    Then el archivo PDF de la entrada se descarga en el sistema del usuario

  Scenario: Usuario vuelve atrás durante el proceso de compra en la selección de sesión para el miércoles
    When el usuario selecciona la película "BEEKEEPER: EL PROTECTOR"
    And el usuario elige "miércoles" como el día para ver la película
    And el usuario escoge la sesión de las "22:45"
    And el usuario indica "1" entrada
    And el usuario llega a la pantalla de selección de asientos
    And el usuario selecciona la opción de "Tornar"
    Then el usuario regresa a la página anterior en el proceso de compra



