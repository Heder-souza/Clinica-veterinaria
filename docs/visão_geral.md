# Visão Geral do Projeto
Este documento apresentará uma leitura geral sobre o projeto, que é uma aplicação desktop visando o controle e gerenciamento de dados de uma clínica veterinária. 

# Objetivo Geral
* Produzir uma aplicação desktop funcional para cadastros e gerenciamento de dados de clínica veterinária, aplicando conceitos de programação em Java

# Obetivos Especificos

* Dominar o padrão MVC: Compreender as funçoes "Modelo" (dados), "Visão" (telas) e o "Controle" (Interaçoes), organizando o codigo para a facilidade de futuras alteraçoes.

* Explorar componemtes essenciais: Aprender componentes como JFrame, JLabel, JTextField, JTextArea, JScrollPane, JButton, JRadioButton, ButtonGroup, JComboBox, JCheckBox, JTabbedPane, JToggleButton, JPanel, JMenuBar, JOptionPane.

* Produzir um sistema simples e funcional, que facilite processos veterinarios ao cadastrar animais e seus tutores.

# Público-Alvo
O sistema foi produzido para atender às necessidades de dois perfis principais na clínica veterinaria:

* Atendentes e Recepcionistas: Usuários que operam o sistema para cadastrar novos clientes e animais de forma rápida, tendo um total controle sobre todas as informaçoes necessarias para o cadastro.
* Médicos Veterinários: Usuários que consultam os dados na tela para identificar o pet e localizar o contato do dono durante o atendimento, analisando o perfil do animal e lendo o seu caso em especifico.
  
# Funcionalidades

Cadastro (Pets e Tutores)
* Guarda de dados essenciais do animal, como nome, raça, especie, idade , sexo e tutor.
* Guarda de dados essenciais do tutor, como nome, telefone e cpf.


Atendimento Clínico 
* Abas, com separação visual clara entre a aba de Cadastros e a aba de Consultas Médicas.

Navegação, Filtros e Alertas
* Menu do Sistema, com barra superior de navegação com acesso rápido para as opções de "Cadastro", "Consultas" e "Sair".
* Filtro, com botão de seleção rápida para filtrar e exibir na tela apenas os animais que possuem uma consulta agendada.

# Avisos importantes
Para alinhar as expectativas do funcionamento do projeto, o sistema tem as seguintes caracteristicas:

* O armazenamento de dados de tutores, animais e consultas ocorre temporariamente na memória RAM, já que o sistema ainda não realiza a escrita em bancos de dados relacionais externos (como MySQL ou PostgreSQL).

* A aplicação funciona exclusivamente de forma local na máquina onde está sendo executada, não possuindo ainda nenhuma forma de acessos simultâneos em rede.

Veja também:
-  **[Estrutura e Padrão MVC](docs/estrutura_mvc.md)**
-  **[Explicação detalhada do Código](docs/explicacao_codigo.md)**
