Feature: Visualización de películas en cartelera en Cines Imperial

  Background:
    Given el usuario está en la página principal de cinesimperial

  Scenario: Usuario visualiza las películas en cartelera
    When el usuario hace clic en el botón 'En Cartell'
    Then se debe mostrar el listado de películas disponibles
