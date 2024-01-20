Feature: Verificación de las opciones y su ubicación en las secciones de Cines Imperial

  Background:
    Given el usuario ha abierto el navegador
    And el usuario está en la página principal de "https://www.cinesimperial.com/"

  Scenario: Las opciones "Dolby Digital", "e-Entrada", y "Festes d'aniversari i lloguer de sales" se muestran correctamente en "Cartellera"
    When el usuario navega a la sección "Cartellera"
    Then las opciones pertinentes se muestran en la parte inferior
    And se muestra información relevante para cada opción seleccionada

  Scenario: Las opciones pertinentes se muestran correctamente en "Esdeveniments"
    When el usuario navega a la sección "Esdeveniments"
    Then las opciones pertinentes se muestran en la parte inferior
    And se muestra información relevante para cada opción seleccionada

  Scenario: Las opciones pertinentes se muestran correctamente en "Tarjeta Imperial Cinema"
    When el usuario navega a la sección "Tarjeta Imperial Cinema"
    Then las opciones pertinentes se muestran en la parte inferior
    And se muestra información relevante para cada opción seleccionada

  Scenario: Las opciones pertinentes se muestran correctamente en "Preus i Descomptes"
    When el usuario navega a la sección "Preus i Descomptes"
    Then las opciones pertinentes se muestran en la parte inferior
    And se muestra información relevante para cada opción seleccionada

  Scenario: Las opciones pertinentes se muestran en la parte derecha en "Promocions"
    When el usuario navega a la sección "Promocions"
    Then las opciones pertinentes se muestran en la parte derecha
    And se muestra información relevante para "Dolby Digital" cuando es seleccionado
    And se muestra información relevante para "e-Entrada" cuando es seleccionado
    And se muestra información relevante para "Festes d'aniversari i lloguer de sales" cuando es seleccionado
