# language: pt

Funcionalidade: Testar página da ForwardCar

  @%CT001
  Cenario: Validar o campo Nome com Nomes dos respectivos carros
    Dado que estou na página da Forward Car
    Quando clico em search
    E digito "Acura"
    Entao aparecem modelos de carro acura

  @CT002
  Cenario: Validar o campo Search como Cor
    Dado que estou na página da Forward Car
    Quando clico em search
    E digito RED,BLUE,GREEN,BLACK,SILVER

      | RED    |
      | BLUE   |
      | GREEN  |
      | BLACK  |
      | SILVER |

    Entao aparecem modelos de carro da cor digitada

  @CT003
  Cenario: Acesso ao sistema como admin
    Dado que estou na página da Forward Car
    Quando clico em search
    E clico no cadeado
    Entao cadeado não abre sem pedir login e senha como admin

  @CT004
  Cenario: Excluir carros no site
    Dado que estou na página da Forward Car
    E clico em search
    E clico no cadeado
    E clico em delete
    Quando clico em ok
    Entao sistema exclui o carro do sistema

  @CT005
  Cenario: Validar restrições de entrada nos campos obrigatórios ("Add a Car")
    Dado que estou na página da Forward Car
    E clico em search
    E clico no cadeado
    E clico em Add Car
    Quando clico em Population From
    E modifico o campo preco para "0"
    E clico em Create
    Entao sistema nao inclui um modelo novo
