Feature: Visualización de películas en cartelera en Cines Imperial

  Como un usuario de la web de Cines Imperial
  Quiero poder ver las películas que están actualmente en cartelera
  Para decidir qué película me gustaría ver

  Scenario: Usuario visualiza las películas en cartelera
    Given el usuario está en la página principal de cinesimperial
    When el usuario hace clic en el botón 'En Cartell'
    Then se debe mostrar el listado de películas disponibles

  # Puedes agregar más escenarios aquí si necesitas probar más funcionalidades
