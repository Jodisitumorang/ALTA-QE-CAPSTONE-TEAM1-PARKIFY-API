Feature: Create Login
  Post create login

#  POSITIVE
  @Project
  Scenario Outline: Post create login with valid body json
    Given    Create login user with valid body json "<bodyJson>"
    When     Send request post login user
    Then     Status code Login should be 200
    And      Response body name should be "<message>"
    And      Validate login user json schema "<jsonSchema>"
    Examples:
      | bodyJson     | message        | jsonSchema         |
      | LoginOP.json | berhasil login | LoginOPSchema.json |
      | LoginUS.json | berhasil login | LoginUSSchema.json |

#  NEGATIVE
  @Project
  Scenario Outline: Post create login user invalid data body json
    Given   Create login user with invalid data body json "<bodyJson>"
    When    Send request post login user
    Then    Status code Login should be 400
    And     Response body name should be "<message>"
    Examples:
      | bodyJson                  | message                                               |
      | LoginInvalidEmail.json    | mohon cek kembali email atau password yang diinputkan |
      | LoginInvalidPassword.json | mohon cek kembali email atau password yang diinputkan |