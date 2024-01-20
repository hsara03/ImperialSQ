Feature: Consulta de puntos y premios en la Tarjeta Imperial Cinema

  Scenario: Consulta de puntos del usuario
    Given el usuario está en la sección "Tarjeta Imperial Cinema"
    When el usuario selecciona "Punts i premis"
    And el usuario introduce su número de tarjeta y contraseña
    And el usuario hace clic en "Consultar Punts"
    Then se muestra el saldo de puntos del usuario

  Scenario: Visualización de premios disponibles
    Given  el usuario está en la sección "Tarjeta Imperial Cinema"
    When el usuario hace clic en "Consultar Premis"
    Then se muestra la lista de premios disponibles con su coste en puntos
