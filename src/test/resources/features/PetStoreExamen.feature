Feature: Examen Validación de la API de PetStore
@Consulta
  Scenario Outline: Creación de un order en PetStore
    Given la url es "https://petstore.swagger.io/v2"
    When envío una solicitud POST para crear order con los siguientes datos:
      | id   | petId   | quantity   | shipDate  | status   | complete   |
      | <id> | <petId> | <quantity> | <shipDate> | <status> | <complete> |
    Then valido el código de respuesta como 200
    And valido que el estado del order sea "<status>"

  Examples:
    | id                  | petId | quantity | shipDate                     | status  | complete |
    | 9222968140497181000 | 0     | 0        | 2024-12-18T02:17:41.640+0000 | placed  | true     |
    | 9222968140497181001 | 0     | 2        | 2024-12-19T02:18:41.640+0000 | shipped | false    |

 @Consulta2
  Scenario: Consulta de order
    Given la url es "https://petstore.swagger.io/v2"
    When consulto order ID "9222968140497181000"
    Then valido el código de respuesta como 200
    And valido que el ID del order "9222968140497181000"
