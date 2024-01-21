Feature: Registro en la Tarjeta Imperial Cinema

  Background:
    Given el usuario está en la página principal de Formulari d'alta

  Scenario: Completar el formulario con multiples errores
    When el no introduce ningun dato
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce su nombre
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce mal el DNI
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce un DNI valido
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce la fecha de nacimiento
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce mal el email
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce un email valido
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce el telefono
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce la direccion
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce mal el CP
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce un CP valido
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce la localidad
    And el usuario envia el formulario
    Then se muestra un mensaje de error
    When el usuario introduce la provincia
    And el usuario envia el formulario
    Then el formulario se envia correctamente

  Scenario: Completar el formulario sin ningun error
    When el usuario introduce su nombre
    When el usuario introduce un DNI valido
    When el usuario introduce la fecha de nacimiento
    When el usuario introduce un email valido
    When el usuario introduce el telefono
    When el usuario introduce la direccion
    When el usuario introduce un CP valido
    When el usuario introduce la localidad
    When el usuario introduce la provincia
    And el usuario envia el formulario
    Then el formulario se envia correctamente

  Scenario: Registrarse con un email duplicado
    When el usuario introduce su nombre
    When el usuario introduce un DNI valido reutilizado
    When el usuario introduce la fecha de nacimiento
    When el usuario introduce un email valido reutilizado
    When el usuario introduce el telefono
    When el usuario introduce la direccion
    When el usuario introduce un CP valido
    When el usuario introduce la localidad
    When el usuario introduce la provincia
    And el usuario envia el formulario
    Then el formulario indica duplicado
