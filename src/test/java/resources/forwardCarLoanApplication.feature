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

  @CT002
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

  @CT006
  Scenario: Validar Acesso a página VIN Lookup
    Given Que o usuário está na página da ForwardCar acessando o ambiente virtual
    When Eu clicar no Botão "Vin Lookup" no cabeçalho da página
    Then Devo ser redirecionado para a página "Vin Lookup"

  @CT007
  Scenario: Validar cadastro do carro no Inventory
    Given Que o usuário está na página da ForwardCar acessando o ambiente virtual
    When Eu pressionar o botão "Search" no cabeçalho da página
    Then Devo ser redirecionado para a pagina search
    And Deve ser exibida a lista de carros cadastrados no Inventory da ForwardCar

  @%CT008
  Scenario Outline: Validar campo de VIN
    Given Que o usuario está na página VIN Lookup
    When inserir o codigo VIN "<VIN>" do carro "<NomeCarro>" no campo Vehicle History Report
    And Pressionar o botao "LookUp"
    Then O histórico do carro "<NomeCarro>" deve ser exibido

    Examples:
      |NomeCarro     |VIN              |
      |Audi A4-B     |2T1KR32E37C639014|
      |Acura RLX-AWD |1ZVBP8AM1D5256900|
      |Acura RLX-AWD |3N1CB51D35l458771|
      |Acura RLX-AWD |2T1KR32E37C639012|
      |Audi S4-S     |3N1CB51D35l458773|
      |BMW 7-Series-P|3N1CB51D35l458774|
      |Audi A4-B     |2T1KR32E37C639015|
      |Audi A4-B     |2T1KR32E37C639015|
      |BMW 7-Series-P|1ZVBP8AM1D5256907|
      |Acura RLX-B   |3N1CB51D35l458778|
      |Acura RLX-B   |3N1CB41D32l458778|
      |Audi A4-C     |3H1CB51D35l453773|
      |BMW 3-Series-S|1XCBP8AM1D5256909|
      |BMW 5-Series-S|7XCBP8AM1D5256910|
      |              |12345678910111213|

    @CT009
    Scenario: Validar exibição dos carros após a exclusão
      Given Que o usuário está na página Search como Admin
      When Eu clicar no botão 'Delete' debaixo de algum carro
      And Confirmar a ação de deletar o carro
      Then O carro deve ser deletado do banco de dados
      And O carro Audi A4-B não deve mais ser exibido no sistema

    @CT010
    Scenario: Consulta do carro por "View Details"
      Given Que o usuário está na página Search
      And Localizou um carro cadastrado no inventory e deseja acessar seu histórico
        |Carro         |
        |Audi A4-B     |
        |Acura RLX-AWD |
        |Acura RLX-AWD |
        |Acura RLX-AWD |
        |Audi S4-S     |
        |BMW 7-Series-P|
        |Audi A4-B     |
        |Audi A4-B     |
        |BMW 7-Series-P|
        |Acura RLX-B   |
        |Acura RLX-B   |
        |Audi A4-C     |
        |BMW 3-Series-S|
        |BMW 5-Series-S|
        |"            "|
        |BMW M5-S      |
        |BMW 3-Series-S|
      When Eu clicar no botão "View Details"
      And Pressionar o botão com o VIN do carro
      Then Devo ser redirecionado para a página VIN Lookup, com o código do veículo inserido no campo de busca
