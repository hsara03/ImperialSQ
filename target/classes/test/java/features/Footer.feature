Feature: Navegación en el Footer
  Para mejorar la experiencia del usuario
  Como un visitante del sitio web de Cines Imperial
  Quiero poder navegar a diferentes secciones desde el footer

  Scenario: El usuario navega a la sección "Avis legal"
    Given el usuario está en la página principal de cinesimperial
    When el usuario hace clic en el enlace "Avis legal" en el footer
    Then el usuario debería ser redirigido a la página de "Avis legal"

