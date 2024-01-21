Feature: Consulta de puntos y premios en la Tarjeta Imperial Cinema

  Background:
    Given el usuario está en la sección "Tarjeta Imperial Cinema"

  Scenario: Error al consultar puntos sin introducir datos
    When el usuario hace clic en Consultar Punts
    Then se muestra un mensaje de error solicitando datos numéricos para el número de tarjeta y contraseña

  Scenario: Error al consultar puntos solo con número de tarjeta
    When el usuario introduce solo su número de tarjeta
    And el usuario hace clic en Consultar Punts
    Then se muestra un mensaje de error solicitando una contraseña

  Scenario: Error al consultar puntos solo con contraseña
    When el usuario introduce solo su contraseña
    And el usuario hace clic en Consultar Punts
    Then se muestra un mensaje de error solicitando un número de tarjeta numérico

  Scenario: Error al consultar puntos con datos incorrectos
    When el usuario introduce un número de tarjeta y contraseña incorrectos
    And el usuario hace clic en Consultar Punts
    Then se muestra un mensaje de error indicando datos incorrectos

  Scenario: Visualización de premios disponibles
    When el usuario hace clic en Consultar Premis
    Then se muestra la lista de premios disponibles con su coste en puntos
