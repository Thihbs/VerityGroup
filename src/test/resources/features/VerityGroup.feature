#language : pt

Funcionalidade: Testar o site da verity

  @Verity
  Esquema do Cenario: Acessar e Preencher o Contato da pagina da verity.
    Dado que eu acessei a home page da Verity Group
    Quando eu clicar na opção de menu “Contato”
    E preencher os campos <Empresa>,<Nome>,<Email>,<Telefone>,Assunto e Mensagem 
    E clicar no botão “Enviar”
    Então o site irá registrar o envio apresentando uma mensagem de que a <mensagem> foi enviada com sucesso.

    
    Exemplos:
    
    |Empresa          |Nome        |Email               |Telefone |mensagem                                    |
    |Thiago Testes    |Thiago silva|tionooah@gmail.com  |973346931|Enviar Sua mensagem foi enviado com sucesso!| 
    |Testes integrados|Fernando fab|Fernandfab@gmail.com|973346931|Sua mensagem foi enviado com sucesso!       |