Feature: Visualización del mapa en la sección 'On som' de la página web de Cines Imperial

  Background:
    Given el usuario se encuentra en On Som

  Scenario: El mapa se inserta
    When el mapa se ha insertado
    Then el elemento canvas esta presente
    When el mapa ha cargado datos
    Then el canvas no muestra ningun error
