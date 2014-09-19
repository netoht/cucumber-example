#language:pt
#author:@netoht
Funcionalidade: Pesquisa na internet com o Google

  Esquema do Cenario: Usuário pesquisa sobre carros no google
    Dado que o usuário esteja no site "http://www.google.com.br"
    Quando o usuário pesquisar sobre o modelo de carro "<modelo_de_carro>"
    Então a página com os resultados da pesquisa terá o título "<titulo_pagina_pesquisa>"

    Exemplos:
      | modelo_de_carro | titulo_pagina_pesquisa        |
      | kadett          | kadett - Pesquisa Google      |
      | landaU          | landaU - Pesquisa Google      |
      | feRRari f12     | feRRari f12 - Pesquisa Google |
      | POlo            | POlo - Pesquisa Google        |
