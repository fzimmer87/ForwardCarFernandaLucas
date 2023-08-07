Feature: Casos de Teste escolhidos que envolvem a página LoanApplication

  #Uma opção para o loop for seria utilizar um Scenario Outline, que facilita esse processo
  @CT001
  Scenario: Validar acesso autenticado a página Loan Application
    Given Que o usuário está na página da ForwardCar acessando o ambiente virtual
    When Eu clicar no botão "Loan Application" no cabeçalho da página
    And For solicitado Login e Senha
    And eu inserir os dados em Username e Password e os enviar
      | Username | Password | isValido  |
      |   123    |   321    | False     |
      | l.morais |  morais  | True      |
    Then Devo ser autenticado e redirecionado para a página "Loan Application"

  @%CT002
  Scenario: Validar restrições de entrada nos campos de Finance Application
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher cada campo do formulário de Finance Application com os seguintes valores:
      |    Campo                | Valor                 | Aceitacao |
      | First Name              | Lucas                 |  True     |
      | Last Name               | 1213                  |  False    |
      | Adress Line 1           | 5641 Rua Joao Ramalho |  True     |
      | City / Town             | $%¨&                  |  False    |
      | State/Providence/Region | SP                    |  True     |
      | Zip / Postal Code       | 93295-770             |  True     |
      | Date of Birth           | Testando              |  False    |
      | SSN#                    | Testando              |  False    |
      | Employer                | ABC                   |  True     |
      | Phone                   | (11)94868-5609        |  True     |
      | Length time at a Job    | 5 Years               |  True     |
      | Yearly Income           | Testando              |  False    |
      | Loan Amount             | $47.871.00            |  True     |
    Then A inserção desses valores nos campos respectivos deve ser aceita
      |    Campo                | Valor                 | Aceitacao |
      | First Name              | Lucas                 |  True     |
      | Last Name               | 1213                  |  False    |
      | Adress Line 1           | 5641 Rua Joao Ramalho |  True     |
      | City / Town             | $%¨&                  |  False    |
      | State/Providence/Region | SP                    |  True     |
      | Zip / Postal Code       | 93295-770             |  True     |
      | Date of Birth           | Testando              |  False    |
      | SSN#                    | Testando              |  False    |
      | Employer                | ABC                   |  True     |
      | Phone                   | (11)94868-5609        |  True     |
      | Length time at a Job    | 5 Years               |  True     |
      | Yearly Income           | Testando              |  False    |
      | Loan Amount             | $47.871.00            |  True     |



  @CT003
  Scenario: Validar campos em branco em Finance Application
    Given Que o usuário está autenticado na página Loan Application
    When Eu não preencher nenhum campo com nenhum valor na página Loan Application
      |    Campo                | Valor |
      | First Name              | N/A   |
      | Last Name               | N/A   |
      | Adress Line 1           | N/A   |
      | City / Town             | N/A   |
      | State/Providence/Region | N/A   |
      | Zip / Postal Code       | N/A   |
      | Date of Birth           | N/A   |
      | SSN#                    | N/A   |
      | Employer                | N/A   |
      | Phone                   | N/A   |
      | Length time at a Job    | N/A   |
      | Yearly Income           | N/A   |
      | Loan Amount             | N/A   |
    And Clicar no botão "Apply"
    Then Deve ocorrer uma falha no envio do formulário e a solicitação de empréstimo não deve ser enviada

  @CT004
  Scenario: Validar aprovação do empréstimo
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher cada campo do formulário com valores válidos
      |    Campo                | Valor          |
      | First Name              | Joao           |
      | Last Name               | Silva          |
      | Adress Line 1           | 123 Main Street|
      | City / Town             | New York City  |
      | State/Providence/Region | New York       |
      | Zip / Postal Code       | 10001          |
      | Date of Birth           | 01/01/1990     |
      | SSN#                    | 123-45-6789    |
      | Employer                | XYZ Corporation|
      | Phone                   | (555)123-4567  |
      | Length time at a Job    | 5 years        |
      | Yearly Income           | 50000          |
      | Loan Amount             | 10000          |
    And Clicar no botão "Apply"
    Then O envio do formulário deve ser feito com sucesso, sendo exibida a mensagem "Application Submitted!"

  @CT005
  Scenario: Validar recusa de empréstimo
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher cada campo do formulário com valores inválidos
      |    Campo                | Valor            |
      | First Name              | ""               |
      | Last Name               | 123              |
      | Adress Line 1           | ""               |
      | City / Town             | 12@City          |
      | State/Providence/Region | New York City    |
      | Zip / Postal Code       | AEIOU            |
      | Date of Birth           | 31/02/2000       |
      | SSN#                    | 123-45           |
      | Employer                | ""               |
      | Phone                   | 159753           |
      | Length time at a Job    | Ten years        |
      | Yearly Income           | -50000           |
      | Loan Amount             |10000000000000000 |
    And Clicar no botão "Apply"
    Then Deve ocorrer uma falha no envio do formulário e a mensagem de "Application Submitted não deve ser exibida"
