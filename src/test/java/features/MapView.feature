Feature: Visualización del mapa en la sección 'On som' de la página web de Cines Imperial

  Background:
    Given el usuario ha abierto el navegador
    And el usuario está en la página principal de "https://www.cinesimperial.com/"

  Scenario: El mapa no se carga correctamente en la sección 'On som'
    When el usuario hace clic en el enlace "On som"
    Then el usuario debería ver la sección del mapa
    But se muestra un mensaje de error indicando que el mapa no se ha cargado //klk tete nose
