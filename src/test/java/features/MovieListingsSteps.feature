Feature: Visualización de películas en cartelera en Cines Imperial

  Background:
    Given el usuario está en la página principal de cinesimperial

  Scenario: Usuario visualiza las películas en cartelera
    When el usuario hace clic en el botón 'En Cartell'
    Then se debe mostrar el listado de películas disponibles

  Scenario: Usuario filtra las peliculas por genero
    When el usuario hace clic en el dropdown todos los generos
    Then se deben mostrar los generos
    And se deben filtrar las peliculas que coincidan con ese genero
