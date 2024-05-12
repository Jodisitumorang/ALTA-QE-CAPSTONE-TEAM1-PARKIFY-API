Feature: Post Create Transaction
  Post transaction

  #  Background:
  @Project
  Scenario Outline: : Already login user
    Given   User operator login with email "<json>"
    When    Send request post login operator
    Then    Status code parking should be 200
    Examples:
      | json                   |
      | PostLoginOperator.json |


#  POSITIVE
  @Project
  Scenario Outline: Post create transaction with valid body json and valid token authorization user
    Given   Post create transaction with body json "<bodyJson>" and token user
    When    Send request post transaction
    Then    Status code transaction should be 200
       Examples:
         | bodyJson                              |  |  |
         | CreateTransactionValidJsonSchema.json |  |  |

#    NEGATIVE
  @Project
  Scenario Outline: Post create transaction with invalid body json and valid token authorization user
    Given   Post create transaction with invalid body json "<bodyJson>" and valid token user
    When    Send request post transaction
    Then    Status code transaction should be 400
    Examples:
      | bodyJson                              |  |
      | CreateTransactionInvalidBodyJson.json |  |

  @Project
  Scenario: Post create transaction with valid body json and invalid token authorization user
    Given Post create transaction with valid body json "CreateTransactionValidJsonSchema.json" and invalid token user
    When Send request post transaction
    Then Status code transaction should be 401