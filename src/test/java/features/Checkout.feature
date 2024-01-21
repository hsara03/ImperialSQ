Feature: Proceso de checkout completo en la web de Cines Imperial

  Background:
    Given el usuario está en la página principal de Imperial

  Scenario: Usuario realiza una compra completa con multiples errores
    When el usuario selecciona la primera película disponible
    And el usuario escoge la primera sesión disponible
    And el usuario indica "2" entradas
    And el usuario inicia el proceso de compra
    And el usuario selecciona que tiene tarjeta de fidelidad
    And el usuario introduce su correo electrónico y contraseña de fidelidad incorrecta
    Then sale error "contraseña incorrecta"
    And salir del error
    And el usuario clica directamente Accepta
    Then sale error "contraseña incorrecta"
    And salir del error
    And clica no gracias
    And el usuario clica a entrar vals
    And clica Validar
    Then sale error "vale invalido"
    And salir del error
    Then introduce datos vale
    And clica Validar
    Then sale error "vale invalido"
    And salir del error
    And cancela introduccion de vales
    Then clica seguent
    And el usuario clica pagar
    Then sale error "falta nombre"
    And salir del error
    And el usuario completa los datos de contacto
    And el usuario clica pagar
    And sale error "faltan condiciones"
    And salir del error
    Then el usuario lee las condiciones de compra
    And el usuario clica a tornar
    And el usuario acepta las condiciones de compra
    Then el usuario clica pagar
    And el usuario se redirige a la pagina de pago

  Scenario: Usuario vuelve atrás durante el proceso de compra
    When el usuario selecciona la primera película disponible
    And el usuario escoge la primera sesión disponible
    And el usuario indica "5" entradas
    And el usuario selecciona la opción de Tornar
    Then el usuario regresa a la página anterior en el proceso de compra
