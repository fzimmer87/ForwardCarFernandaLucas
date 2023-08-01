Feature: Casos de Teste escolhidos que envolvem a página LoanApplication

  #Uma opção para o loop for seria utilizar um Scenario Outline, que facilita esse processo
  @%CT001
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
  Scenario Outline: Validar restrições de entrada nos campos de Finance Application
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher o campo <Campo> do formulário de Finance Application com <Valor>
    Then A inserção desses valores nos campos respectivos deve ser <Aceitacao>

  #Pensar em como usar o for (poderia tentar utilizar validando o caso de teste 3 por meio da coluna de Aceitação)
    Examples:
      |    Campo                | Valor                 | Aceitacao |
      | First Name              | Lucas                 |  Sim      |
      | Last Name               | 1213                  |  Nao      |
      | Adress Line 1           | 5641 Rua Joao Ramalho |  Sim      |
      | City / Town             | $%¨&                  |  Nao      |
      | State/Providence/Region | SP                    |  Sim      |
      | Zip / Postal Code       | 93295-770             |  Sim      |
      | Country                 | Brasil                |  Sim      |
      | Date of Birth           | Testando              |  Nao      |
      | SSN#                    | Testando              |  Nao      |
      | Employer                | ABC                   |  Sim      |
      | Phone                   | (11)94868-5609        |  Sim      |
      | Length time at a Job    | 5 Years               |  Sim      |
      | Yearly Income           | Testando              |  Nao      |
      | Loan Amount             | $47.871.00            |  Sim      |


  @CT003
  Scenario Outline: Validar campos em branco em Finance Application
    Given Que o usuário está autenticado na página Loan Application
    When Eu não preencher nenhum <Campo> com nenhum <Valor> na página Loan Application
    And Clicar no botão "Apply"
    Then Deve ocorrer uma falha no envio do formulário e a solicitação de empréstimo não deve ser enviada
    And Não deve ser exibida a mensagem de "Application Submitted!"

    Examples:
      |    Campo                | Valor                 |
      | First Name              |                       |
      | Last Name               |                       |
      | Adress Line 1           |                       |
      | City / Town             |                       |
      | State/Providence/Region |                       |
      | Zip / Postal Code       |                       |
      | Country                 |                       |
      | Date of Birth           |                       |
      | SSN#                    |                       |
      | Employer                |                       |
      | Phone                   |                       |
      | Length time at a Job    |                       |
      | Yearly Income           |                       |
      | Loan Amount             |                       |

  @CT004
  Scenario: Validar aprovação do empréstimo
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher cada campo do formulário com valores válidos
    And Clicar no botão "Apply"
    Then O envio do formulário deve ser feito com sucesso, bem como a solicitação de empréstimo
    And Deve ser exibida a mensagem "Application Submitted!"

  @CT005
  Scenario: Validar recusa de empréstimo
    Given Que o usuário está autenticado na página Loan Application
    When Eu preencher cada campo do formulário com valores inválidos
    And Clicar no botão "Apply"
    Then Deve ocorrer uma falha no envio do formulário e a solicitação de empréstimo não deve ser enviada
    And Não deve ser exibida a mensagem de "Application Submitted!"
