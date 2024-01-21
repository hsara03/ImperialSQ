Feature: Visualizar detalles de una pelicula

  Background:
    Given el usuario esta en la pagina principal de cinesimperial
    And el usuario accede a una pelicula

  Scenario: El usuario interactua con el trailer
    When el usuario hace clic en el boton Trailer
    Then el usuario cierra el trailer

  Scenario: El usuario selecciona una hora
    When el usuario hace click en una de las horas
    Then el usuario debe empezar el proceso de checkout
