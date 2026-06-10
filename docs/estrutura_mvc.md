# Estrutura do Projeto e Padrão Arquitetural

Este documento detalha as tecnologias de base utilizadas no desenvolvimento do Sistema de Clínica Veterinária e explica como o padrão **MVC (Model-View-Controller)** foi aplicado, além de mostrar a organização e distribuição das nossas pastas.


# O esqueleto do projeto

Para compreender a arquitetura do sistema, é necessário entender o papel de cada tecnologia utilizada na construção da aplicação:

* **Java (Linguagem e Plataforma):** É a base de todo o projeto, a linguagem de programação e o motor da clinica veterinariw.
* **AWT (Abstract Window Toolkit):** É a biblioteca gráfica nativa e mais antiga do Java. No nosso projeto, fornece a base de infraestrutura essencial, capturar o clique do mouse, teclado...
* **Java Swing:** É a biblioteca que de fato constrói a nossa interface gráfica (GUI). O Swing roda, oferecendo componentes muito mais modernos, leves e customizáveis 


# Conceito do Padrão MVC

O padrão **MVC (Model-View-Controller)** é um padrão de arquitetura de software que divide a aplicação em três camadas, que é o Model, View e Controller. 

### Mas por que esse padrão?
Em sistemas simples, é muito comum que iniciantes coloquem todo o código (o desenho do botão, a validação do texto e o salvamento dos dados) dentro de um único arquivo ou em varios aquivos sem o menor rigor organizacional. Isso torna o código confuso e praticamente impossível a manutenção, porém ao aplicar o padrão MVC em nosso projeto da clinica veterinaria, nos garantimos que:

1.  Se o pedir para mudar o visual da tela (Java Swing), as regras continuam intactas.
2.  Se mudarmos a forma como os dados são guardados, a interface gráfica não sofre nenhum impacto.
3.  O trabalho em grupo fica mais fácil.


# Organização de arquivos

A organização de arquivos e pastas foi pensada para atender a uma facilidade visual clara, organizada e simples. Veja a seguir:
---
* src/ (Essa é a pasta que entrará para os codigos)
|
  * clinica/ (Pasta principal do projeto)
  |  
    * Main.java (Arquivo principal que inicia o sistema)
    |
    * model/ (Pasta com as classes)
      * Animal.java
      * Tutor.java
      * Consulta.java
    | 
    * view/ (Pasta com as telas)
      * TelaPrincipal.java
      * PainelCadastro.java
      * PainelConsultas.java
    |     
    * controller/ (Pasta com a lógica de controle)
      * ClinicaController.java
---


Veja também:

-  **[Visão Geral do Projeto](visão_geral.md)**

