# language: pt

Funcionalidade: Testar página da ForwardCar

  @CT001
  Cenario: Validar o campo Search com nome Acura
    Dado que estou na página da Forward Car
    Quando clico em search
    E digito "Acura"
    Entao aparecem modelos de carro acura

  @CT002
  Cenario: Validar o campo Search como Cor
    Dado que estou na página da Forward Car
    Quando clico em search
    E digito as respectivas cores

      | Red    |
      | Blue   |
      | Green  |
      | Black  |
      | Silver |

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
    Entao sistema mostra mensagem Car Deleted

  @CT005
  Cenario: Validar restrições de entrada nos campos obrigatórios ("Add a Car")
    Dado que estou na página da Forward Car
    E clico em search
    E clico no cadeado
    E clico em Add Car
    Quando clico em Population From
    E modifico o campo preco para "0"
    E clico em Create
    Entao sistema nao inclui um modelo novo e nao mostra mensagem car created

  @CT006
  Cenario: Validar campo Resgister com First Name, Last Name, Username e Password
    Dado que estou na página da Forward Car
    E clico no botao Guest
    E clico em Register
    Quando digito campo FIRST NAME, LAST NAME, USARNAME, PASSWORD com dados
      | first name |last name|username |password|
      | Fernanda   | Zimmer  | zimmerf | 852456 |
    Entao só consigo realizar o Registro com todos os campos preenchidos


  @CT007
  Cenario: Validar Botão Login
    Dado que estou na página da Forward Car
    E clico em Guest
    E clico em Login
    Quando preencho usarname e passoword com dados já cadastrado no Register
    Entao sistema me encaminha para pagina principal da Forward Car

  @CT008
  Cenario: Validar o campo Make e seus filtro.
    Dado que estou na pagina inventory da Forward Car
    E clico no botao Make Acura
    Quando clico no botao Model RLX-AWD
    Entao aparecem modelos de carro Acura RLX-AWD


  @CT009
  Cenario: Validar o campo Search como Ano
    Dado que estou na pagina inventory da Forward Car
    E clico campo busca search
    Quando digito o ano de algum modelo de carro

      | 2008 |
      | 2009 |
      | 2010 |
      | 2011 |
      | 2012 |
      | 2013 |
    Entao aparecem modelos do ano que digitei

  @CT010
  Cenario: Validar o Botao Loan Aplication tela Inicial
    Dado que estou na página da Forward Car
    E clico em Guest
    E clico em Login
    E realizo meu login com Usarname e Senha
    E clico onde esta meu nome Guest
    Quando clico em Loan Status
    Então sou encaminhado para pagina onde verifico meus emprestimos e financiamentos

