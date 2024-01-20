Feature: Verificación de las opciones y su ubicación en las secciones de Cines Imperial

  Background:
    Given el usuario esta en la pagina principal de cinesimperial

  Scenario: Las opciones se muestran en Index
    When el usuario navega a la sección Index
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones se muestran en promocions
    When el usuario navega a la sección Promocions
    Then las opciones pertinentes se muestran en la parte derecha
    And las opciones pueden ser alternadas

  Scenario: Las opciones se muestran en esdeveniments
    When el usuario navega a la sección Esdeveniments
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones pertinentes se muestran correctamente en Avantatges Club
    When el usuario navega a la sección Avantatges Club
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones pertinentes se muestran correctamente en Punts i Premis
    When el usuario navega a la sección Punts i Premis
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones pertinentes se muestran correctamente en Formulari d'Alta
    When el usuario navega a la sección Formulari d'Alta
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones pertinentes se muestran correctamente en Preus i descomptes
    When el usuario navega a la sección Preus i descomptes
    Then las opciones pertinentes se muestran en la parte inferior
    And las opciones pueden ser alternadas

  Scenario: Las opciones no se muestran en Avis legal
    When el usuario navega a la sección Avis legal
    Then las opciones no se muestran
