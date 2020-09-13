# OliotaGithub
Projeto mobile de exemplo, desenvolvido em Java no Android Studio

<img src="https://avatars1.githubusercontent.com/u/6345052?s=460&amp;v=4" width="128px" height="128px">

Esse projeto tem o objetivo de listar os repositórios publicos com base na busca por palavras-chave

Ao selecionar um item da lista é possível visualizar os detalhes do repositório

## Passos

>Baixe o projeto

>Abra o projeto no android studio

>Compile para instalar o aplicativo

>Na tela inicial selecione a Lupa no canto superior direito

>Informe a palavra chave da busca

>Aguarde a busca finalizar

>Selecione um item da lista para ver os detalhes do repositório


<img src="https://media3.giphy.com/media/f3uY5ao37nt1RmCDDS/giphy.gif"   width="300" height="500">

## Testes
- Os testes foram realizados no emulador

>Todos os modelos possuem testes unitários

>As telas possuem testes de inferface

- Cenario 1: Testar a mudança do actionBar com as ações possíveis
  - Ao abrir a busca executar o botão de voltar para que apenas a busca seja finalizada permanecendo na tela
  - Ao abrir a busca sem texto o botão X deve fechar a busca e restaurar a visibilidade inicial do actionBar
  - Ao abrir a busca e após informar o texto o botão X deve limpar o texto antes de fechar a busca e restaurar a visibilidade inicial do actionBar
  - Ao abrir a busca sem texto o botão voltar (na action bar ou no menu inferior) deve fechar a busca e restaurar a visibilidade inicial do actionBar
  - Ao abrir a busca e após informar o botão voltar (na action bar ou no menu inferior) deve limpar o texto antes de fechar a busca e restaurar a visibilidade inicial do actionBar
  - Se a busca estiver fechada  o botão voltar (no menu inferior) deve finalizar o aplicativo
  
- Cenario 2: Informar uma busca que retorne resultados e visualizar os detalhes do repositório selecionado na lista
  
- Cenario 3: Não há internet para realizar a busca inicial de repositórios publicos do github e a busca também será impactada pela falta de conexão
  - Esse evento é tratado com uma mensagem

- Cenario 4: Informar uma busca que não retorne resultados
  - Esse evento é tratado com uma mensagem




 
