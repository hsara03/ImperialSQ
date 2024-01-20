Feature: Navegación por las secciones principales de la página web Cines Imperial

  Background:
    Given el usuario esta en la pagina principal de cinesimperial

  Scenario: El usuario navega a la página principal haciendo clic en el logo
    When el usuario hace clic en el logo de Cines Imperial
    Then el usuario debería ser redirigido a la página principal de https://www.cinesimperial.com/

  Scenario: El usuario navega a la sección Cartellera
    When el usuario hace clic en el enlace Cartellera
    Then el usuario debería ser redirigido a la página de Cartellera

  Scenario: El usuario navega a la sección Promocions
    When el usuario hace clic en el enlace Promocions
    Then el usuario debería ser redirigido a la página de Promocions

  Scenario: El usuario navega a la sección Esdeveniments
    When el usuario hace clic en el enlace Esdeveniments
    Then el usuario debería ser redirigido a la página de Esdeveniments

  Scenario: El usuario navega a la sección Tarjeta Imperial Cinema
    When el usuario hace clic en el enlace Tarjeta Imperial Cinema
    Then el usuario debería ver las opciones del menú Tarjeta Imperial Cinema

  Scenario: El usuario navega a Avantatges Club desde Tarjeta Imperial Cinema
    When el usuario hace clic en el enlace Tarjeta Imperial Cinema
    And el usuario hace clic en Avantatges Club
    Then el usuario debería ser redirigido a la página de Avantatges Club

  Scenario: El usuario navega a Punts i premis desde Tarjeta Imperial Cinema
    When el usuario hace clic en el enlace Tarjeta Imperial Cinema
    And el usuario hace clic en Punts i premis
    Then el usuario debería ser redirigido a la página de Punts i premis

  Scenario: El usuario navega a Formulari d'alta desde Tarjeta Imperial Cinema
    When el usuario hace clic en el enlace Tarjeta Imperial Cinema
    And el usuario hace clic en Formulari d'alta
    Then el usuario debería ser redirigido a la página de Formulari d'alta

  Scenario: El usuario navega a la sección Preus i Descomptes
    When el usuario hace clic en el enlace Preus i Descomptes
    Then el usuario debería ser redirigido a la página de Preus i Descomptes

  Scenario: El usuario navega a la sección On som
    When el usuario hace clic en el enlace On som
    Then el usuario debería ser redirigido a la página de On som
