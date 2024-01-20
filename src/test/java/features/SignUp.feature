Feature: Registro en la Tarjeta Imperial Cinema

  Background:
    Given el usuario ha abierto el navegador
    And el usuario está en la página principal de "https://www.cinesimperial.com/"

  Scenario: Completar el formulario de alta de la Tarjeta Imperial Cinema
    When el usuario navega a la sección "Tarjeta Imperial Cinema" y elige "Formulari d'alta"
    And el usuario completa el formulario de registro con sus datos personales
    And el usuario verifica que no es un robot
    And el usuario envía el formulario
    Then se muestra un mensaje de confirmación de que los datos se han guardado correctamente
    And se indica al usuario que puede recoger su tarjeta en las taquillas del cine
