Feature: Visualizar eventos

  Background:
    Given el usuario esta en la pagina principal de eventos

  Scenario: El usuario visualiza los eventos
    Then si hay un evento disponible, se comprueban los detalles
    Then si hay un evento disponible, es escoge una hora
