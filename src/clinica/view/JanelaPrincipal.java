/**
 * Aqui é onde inicia a primeira tela do sistema
 */

package clinica.view;

import javax.swing.*;// chama a ferramenta Swing para que possa ser usada
import clinica.controller.CadastroController;// importa o controller que irá tratar os dados do cadastro
import clinica.controller.ConsultaController;
import clinica.model.Animal;//importaçao feita para conseguir puxar os animais já cadastrados usando o getAnimais
import clinica.model.Consulta;

public class JanelaPrincipal extends JFrame {// aqui avisa pro java que a Janela principal sera um JFrame (exibivel)

    // campos declarados aqui para todos os métodos enxergarem
    CadastroController controller = new CadastroController();// cria o controller que será usado para salvar os dados do
                                                             // animal
    ConsultaController controllerConsulta = new ConsultaController();// cria o controller que será usado para salvar os
                                                                     // dados da consulta

    // campos do animal - declarados aqui fora pra que o qualquer metodo consiga ler
    // os
    // valores digitados
    JTextField nomeAnimal;
    JTextField racaAnimal;
    JTextField idadeAnimal;
    JComboBox<String> comboEspecie;
    JRadioButton masculino;
    JRadioButton feminino;
    ButtonGroup grupoSexo;
    JCheckBox checkV8;
    JCheckBox checkGripe;
    JCheckBox checkGiardia;
    JCheckBox checkAntirrabica;
    JCheckBox checkLeishmaniose;
    JTabbedPane abas;
    JComboBox<String> tipoAtendimento;
    JTextArea observacoesConsulta;
    JComboBox<String> comboAnimais;
    JToggleButton filtroSemConsulta;

    // campos de exibição da consulta
    JTextField nomeAnimalConsulta;
    JTextField especieAnimalConsulta;
    JTextField racaAnimalConsulta;
    JTextField idadeAnimalConsulta;
    JTextField nomeTutorConsulta;
    JTextField telefoneTutorConsulta;
    JTextArea areaConsultas;

    // campos do tutor - declarados aqui fora pelo mesmo motivo dos campos do animal
    JTextField nomeTutor;
    JTextField telefoneTutor;
    JTextField cpfTutor;

    public JanelaPrincipal() {// construtor (Base de toda a janela inicial)
        setTitle("Clínica Veterinária"); // título da janela(que aparece lá em cima)
        setSize(800, 600);// (largura e altura)
        setDefaultCloseOperation(EXIT_ON_CLOSE); // encerra o programa ao fechar
        criarMenu(); // usa o menu que criamos com o construtor

        abas = new JTabbedPane();
        abas.addTab("Cadastro", criarPainelCadastro());
        abas.addTab("Consulta", JanelaConsulta());
        add(abas);
        abas.addChangeListener(e -> {// feito para sempre que houver troca de paginas a parte de selecionar os
                                     // animais cadastrados se atualize automáticamente
            if (abas.getSelectedIndex() == 1) {
                atualizarComboAnimais();
            }
        });
        setVisible(true); // deixa a janela visível

    }

    private void criarMenu() {// metodo de criar o menu, usado pois o menu será reutilizado na tela da
                              // consulta

        // 1. cria a barra
        JMenuBar barraMenu = new JMenuBar();

        // 2. cria o menu
        JMenu menuSair = new JMenu("Sistema");

        // 3. adiciona o menu na BarraMenu
        JMenuItem itemSair = new JMenuItem("Sair do sistema");
        itemSair.addActionListener(e -> System.exit(0));// fecha o programa
        menuSair.add(itemSair);

        barraMenu.add(menuSair);
        setJMenuBar(barraMenu);
    }

    private JPanel criarPainelCadastro() {

        // 1. cria o painel principal (containerzão que vai ter o container da esquerda
        // e o da direita)
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.X_AXIS));// X_AXIS é o eixo horizontal - essa
                                                                                    // linha diz (organize tudo lado a
                                                                                    // lado da esquerda pra direita)

        // 2. chama o metodo que monta o painel esquerdo (dados do animal)
        JPanel painelEsquerdo = criarPainelEsquerdo();

        // 3. chama o metodo que monta o painel direito (dados do tutor + botões)
        JPanel painelDireito = criarPainelDireito();

        // 4. adiciona os dois paineis dentro do painel principal lado a lado
        painelPrincipal.add(painelEsquerdo);
        painelPrincipal.add(painelDireito);

        // 5. adiciona o painel principal na janela
        return painelPrincipal;
    }

    private JPanel criarPainelEsquerdo() {
        // opções que vão aparecer na lista suspensa de espécie
        String[] especies = { "cachorro", "gato", "ave", "coelho", "reptil", "outro" };

        // cria o painel e define que os componentes serão empilhados de cima pra baixo
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));// Y_AXIS é o eixo vertical - organiza os componentes
                                                                  // um abaixo do outro

        // define uma borda com título e uma margem interna de 10 pixels para não colar os componentes nas pontas
        painel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Dados do Animal"),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel nomeAnimalLabel = new JLabel("Nome");
        nomeAnimalLabel.setAlignmentX(LEFT_ALIGNMENT);// alinha o label à esquerda
        painel.add(nomeAnimalLabel);
        nomeAnimal = new JTextField(20);// 20 = tamanho do campo em colunas
        nomeAnimal.setAlignmentX(LEFT_ALIGNMENT);// alinha o campo à esquerda
        nomeAnimal.setMaximumSize(nomeAnimal.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(nomeAnimal);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel especie = new JLabel("Especie");
        especie.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(especie);
        comboEspecie = new JComboBox<>(especies);
        comboEspecie.setAlignmentX(LEFT_ALIGNMENT);
        comboEspecie.setMaximumSize(comboEspecie.getPreferredSize());// impede que a lista suspensa estique verticalmente
        painel.add(comboEspecie);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel raca = new JLabel("Raça");
        raca.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(raca);
        racaAnimal = new JTextField(20);
        racaAnimal.setAlignmentX(LEFT_ALIGNMENT);
        racaAnimal.setMaximumSize(racaAnimal.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(racaAnimal);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel idade = new JLabel("Idade");
        idade.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(idade);
        idadeAnimal = new JTextField(20);
        idadeAnimal.setAlignmentX(LEFT_ALIGNMENT);
        idadeAnimal.setMaximumSize(idadeAnimal.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(idadeAnimal);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel sexo = new JLabel("Sexo");
        sexo.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(sexo);

        // 1. cria os dois botões de seleção de sexo
        masculino = new JRadioButton("Masculino");
        feminino = new JRadioButton("Feminino");
        masculino.setAlignmentX(LEFT_ALIGNMENT);
        feminino.setAlignmentX(LEFT_ALIGNMENT);

        // 2. junta os dois no ButtonGroup pra que só um possa ser selecionado
        grupoSexo = new ButtonGroup();
        grupoSexo.add(masculino);
        grupoSexo.add(feminino);

        painel.add(masculino);
        painel.add(feminino);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel vacinasJLabel = new JLabel("Vacinas");
        vacinasJLabel.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(vacinasJLabel);

        // cada checkbox é uma vacina e como são JCheckBox, podem ser marcadas várias ao
        // mesmo tempo
        checkV8 = new JCheckBox("v8, v10, v12");
        checkGripe = new JCheckBox("Gripe Canina");
        checkGiardia = new JCheckBox("Giárdia");
        checkAntirrabica = new JCheckBox("Antirrábica");
        checkLeishmaniose = new JCheckBox("Leishmaniose");

        checkV8.setAlignmentX(LEFT_ALIGNMENT);
        checkGripe.setAlignmentX(LEFT_ALIGNMENT);
        checkGiardia.setAlignmentX(LEFT_ALIGNMENT);
        checkAntirrabica.setAlignmentX(LEFT_ALIGNMENT);
        checkLeishmaniose.setAlignmentX(LEFT_ALIGNMENT);

        painel.add(checkV8);
        painel.add(checkGripe);
        painel.add(checkGiardia);
        painel.add(checkAntirrabica);
        painel.add(checkLeishmaniose);

        return painel;
    }

    private JPanel criarPainelDireito() {

        // cria o painel e define que os componentes serão empilhados de cima pra baixo
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));// aqui define que serão um abaixo do outro por conta
                                                                  // do eixo Y (vertical)

        // define uma borda com título e uma margem interna de 10 pixels para não colar os componentes nas pontas
        painel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Tutor Responsável"),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel nomeTutorLabel = new JLabel("Nome");
        nomeTutorLabel.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(nomeTutorLabel);
        nomeTutor = new JTextField(20);
        nomeTutor.setAlignmentX(LEFT_ALIGNMENT);
        nomeTutor.setMaximumSize(nomeTutor.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(nomeTutor);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel telefone = new JLabel("Telefone");
        telefone.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(telefone);
        telefoneTutor = new JTextField(20);
        telefoneTutor.setAlignmentX(LEFT_ALIGNMENT);
        telefoneTutor.setMaximumSize(telefoneTutor.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(telefoneTutor);
        painel.add(Box.createVerticalStrut(10)); // adiciona um espaço vertical de 10 pixels entre os campos

        JLabel cpf = new JLabel("CPF");
        cpf.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(cpf);
        cpfTutor = new JTextField(20);
        cpfTutor.setAlignmentX(LEFT_ALIGNMENT);
        cpfTutor.setMaximumSize(cpfTutor.getPreferredSize());// impede que o campo estique verticalmente
        painel.add(cpfTutor);
        painel.add(Box.createVerticalStrut(20)); // adiciona um espaço vertical maior antes dos botões

        // parte dos botões limpar e salvar
        JPanel painelBotoes = new JPanel();// painel interno para deixar os botões lado a lado, pois se colocassemos
                                           // direto no painel direito eles iriam ficar um em cima do outro
        painelBotoes.setAlignmentX(LEFT_ALIGNMENT); // alinha o painel de botões à esquerda

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(e -> {
            limparCampos();
        });

        JButton botaoSalvar = new JButton("Salvar");

        // define o que acontece quando o botão salvar é clicado
        botaoSalvar.addActionListener(e -> {
            String nome = nomeAnimal.getText();
            String especieSelecionada = (String) comboEspecie.getSelectedItem();
            String raca = racaAnimal.getText();
            String idadeTexto = idadeAnimal.getText();
            String sexo = masculino.isSelected() ? "Masculino" : "Feminino";// se masculino estiver marcado retorna
                                                                            // "Masculino", senão retorna "Feminino"

            // dados do tutor
            String nomeDoTutor = nomeTutor.getText();
            String telefoneDoTutor = telefoneTutor.getText();
            String cpfDoTutor = cpfTutor.getText();

            // recebe todos os dados e envia para o controller fazer a verificação e
            // retornar false(algum campo vazio) ou true(todos completos)
            boolean salvou = controller.salvarCadastro(nome, especieSelecionada, raca, idadeTexto, sexo, nomeDoTutor,
                    telefoneDoTutor, cpfDoTutor);

            if (salvou) {
                JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }
        });

        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoSalvar);

        painel.add(painelBotoes);

        return painel;
    }

    private void limparCampos() {
        // limpa os campos do animal
        nomeAnimal.setText("");
        racaAnimal.setText("");
        idadeAnimal.setText("");
        comboEspecie.setSelectedIndex(0);// volta para a primeira opção da lista
        grupoSexo.clearSelection();// desmarca todos os radio buttons do grupo

        // limpa todos os checks das vacinas
        checkV8.setSelected(false);
        checkGripe.setSelected(false);
        checkGiardia.setSelected(false);
        checkAntirrabica.setSelected(false);
        checkLeishmaniose.setSelected(false);

        // limpa os campos do tutor
        nomeTutor.setText("");
        telefoneTutor.setText("");
        cpfTutor.setText("");
    }

    private void atualizarComboAnimais() {

        comboAnimais.removeAllItems();//remove todos para não duplicar

        for (Animal animal : controller.getAnimais()) {//pega o primeiro animal ex. Bob(e dps vai continuando até o final)

            boolean possuiConsulta = false;//começa como falso ,logo, aqui bob não tem consulta

            for (Consulta consulta : controllerConsulta.getConsultas()) {//aqui ele começa a procurar o nome do bob na lista das consultas agendadas

                if (consulta.getAnimal() == animal) {
                    possuiConsulta = true;//se achar o nome dele na lista das consultas, marca como true falando que ele tem consulta marcada
                    break;
                }
            }

            if (filtroSemConsulta.isSelected()) {//se o filtro estiver ativo cai aqui

                if (!possuiConsulta) {
                    comboAnimais.addItem(animal.getNome());//aqui diz, se o animal não tiver consulta(possuiConsulta == false) ele mostra o animal no Combo
                }

            } else {//senao

                comboAnimais.addItem(animal.getNome());//se caiu aqui significa que o animal tem uma ou mais consultas marcadas e por conta disso ele n ira aparecer

            }
        }
    }

    private void atualizarListaConsultas() {

        areaConsultas.setText("");

        for (Consulta consulta : controllerConsulta.getConsultas()) {

            areaConsultas.append(
                    consulta.getAnimal().getNome()
                            + " - "
                            + consulta.getTipo()
                            + "\n"
                            + "Obs: "
                            + consulta.getObservacoes()
                            + "\n\n");
        }
    }

    private JPanel JanelaConsulta() {
        String[] atendimentos = { "Consulta", "Retorno", "Emergência", "Vacinação" };
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margem geral da aba de consultas

        // painel esquerdo - formulário da consulta
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        painelEsquerdo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Agendar Atendimento"),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel labelAnimal = new JLabel("Selecionar Animal");
        labelAnimal.setAlignmentX(LEFT_ALIGNMENT);
        painelEsquerdo.add(labelAnimal);

        comboAnimais = new JComboBox<>();
        comboAnimais.setAlignmentX(LEFT_ALIGNMENT);
        comboAnimais.setMaximumSize(comboAnimais.getPreferredSize());// impede de esticar verticalmente
        comboAnimais.addActionListener(e -> {
            // aqui ele pega o nome do animal selecionado. ex: bob
            String nomeSelecionado = (String) comboAnimais.getSelectedItem();// retorna o item em String e n em object
                                                                             // por isso o (String)

            // percorre a lista procurando o animal chamado bob
            for (Animal animal : controller.getAnimais()) {
                if (animal.getNome().equals(nomeSelecionado)) {// se passar por um animal com nome bob
                    // ele pega todas as informações dele e coloca nos JTextField;
                    nomeAnimalConsulta.setText(animal.getNome());
                    especieAnimalConsulta.setText(animal.getEspecie());
                    racaAnimalConsulta.setText(animal.getRaca());
                    idadeAnimalConsulta.setText(animal.getIdade());
                    nomeTutorConsulta.setText(animal.getTutor().getNomeTutor());
                    telefoneTutorConsulta.setText(animal.getTutor().getTelefone());
                }
            }
        });
        painelEsquerdo.add(comboAnimais);
        painelEsquerdo.add(Box.createVerticalStrut(5)); // espaçamento curto

        filtroSemConsulta = new JToggleButton("Mostrar apenas sem consulta");
        filtroSemConsulta.setAlignmentX(LEFT_ALIGNMENT);
        filtroSemConsulta.setMaximumSize(filtroSemConsulta.getPreferredSize());// mantém o botão no tamanho ideal
        painelEsquerdo.add(filtroSemConsulta);

        filtroSemConsulta.addActionListener(e -> {
            atualizarComboAnimais();// ao clicar desligar ou ligar o filtro ele irá atualizar os animais disponiveis
                                    // para aplicar o filtro e tirar os animais com consultas agendadas
        });
        painelEsquerdo.add(Box.createVerticalStrut(15)); // espaçamento entre blocos

        JLabel labelTipo = new JLabel("Tipo de Atendimento");
        labelTipo.setAlignmentX(LEFT_ALIGNMENT);
        painelEsquerdo.add(labelTipo);
        tipoAtendimento = new JComboBox<>(atendimentos);
        tipoAtendimento.setAlignmentX(LEFT_ALIGNMENT);
        tipoAtendimento.setMaximumSize(tipoAtendimento.getPreferredSize());// impede de esticar verticalmente
        painelEsquerdo.add(tipoAtendimento);
        painelEsquerdo.add(Box.createVerticalStrut(15)); // espaçamento entre blocos

        JLabel labelObs = new JLabel("Observações");
        labelObs.setAlignmentX(LEFT_ALIGNMENT);
        painelEsquerdo.add(labelObs);
        observacoesConsulta = new JTextArea(5, 20);
        JScrollPane scroll = new JScrollPane(observacoesConsulta);
        scroll.setAlignmentX(LEFT_ALIGNMENT);
        scroll.setMaximumSize(scroll.getPreferredSize()); // limita o tamanho do scroll da observação
        painelEsquerdo.add(scroll);
        painelEsquerdo.add(Box.createVerticalStrut(20)); // espaço antes do botão salvar

        JButton botaoSalvarConsulta = new JButton("Salvar Consulta");
        botaoSalvarConsulta.setAlignmentX(LEFT_ALIGNMENT);
        botaoSalvarConsulta.addActionListener(e -> {
            String nomeSelecionado = (String) comboAnimais.getSelectedItem();// retorna o item em String e n em object
                                                                             // por isso o (String)
            String tipo = (String) tipoAtendimento.getSelectedItem();
            String observacoes = observacoesConsulta.getText();

            // dados do animal

            // recebe todos os dados e envia para o controller fazer a verificação e
            // retornar false(algum campo vazio) ou true(todos completos)
            Animal animalSelecionado = null;// aqui é uma variavel para guardar o objeto animal, agora ela esta vazia

            for (Animal animal : controller.getAnimais()) {
                if (animal.getNome().equals(nomeSelecionado)) {// verfica se o animal nesta posição bate com o animal
                                                               // desejado
                    animalSelecionado = animal;// se sim a variavel recebe todo o objeto com todas as informações do
                                               // animal
                    break;
                }
            }

            boolean salvou = controllerConsulta.salvarConsulta(animalSelecionado, tipo, observacoes);

            if (salvou) {
                JOptionPane.showMessageDialog(null, "consulta agendada com sucesso!");
                atualizarListaConsultas();
                atualizarComboAnimais();//fica aqui para que se vc fizer uma consulta para o animal ele já ira sumir assim que a consulta for feita
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }
        });
        painelEsquerdo.add(botaoSalvarConsulta);

        painel.add(painelEsquerdo);

        // painel direito - mostra as informações
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // separa o painel direito do esquerdo

        //painel menor para os Dados de Visualização
        JPanel painelDadosVisualizacao = new JPanel();
        painelDadosVisualizacao.setLayout(new BoxLayout(painelDadosVisualizacao, BoxLayout.Y_AXIS));
        painelDadosVisualizacao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Dados do Animal / Tutor Selecionado"),
            BorderFactory.createEmptyBorder(5, 10, 10, 10)
        ));
        painelDadosVisualizacao.setAlignmentX(LEFT_ALIGNMENT);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelNome);
        nomeAnimalConsulta = new JTextField(20);
        nomeAnimalConsulta.setEditable(false);
        nomeAnimalConsulta.setAlignmentX(LEFT_ALIGNMENT);
        nomeAnimalConsulta.setMaximumSize(nomeAnimalConsulta.getPreferredSize());
        painelDadosVisualizacao.add(nomeAnimalConsulta);

        JLabel labelEspecie = new JLabel("Espécie");
        labelEspecie.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelEspecie);
        especieAnimalConsulta = new JTextField(20);
        especieAnimalConsulta.setEditable(false);
        especieAnimalConsulta.setAlignmentX(LEFT_ALIGNMENT);
        especieAnimalConsulta.setMaximumSize(especieAnimalConsulta.getPreferredSize());
        painelDadosVisualizacao.add(especieAnimalConsulta);

        JLabel labelRaca = new JLabel("Raça");
        labelRaca.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelRaca);
        racaAnimalConsulta = new JTextField(20);
        racaAnimalConsulta.setEditable(false);
        racaAnimalConsulta.setAlignmentX(LEFT_ALIGNMENT);
        racaAnimalConsulta.setMaximumSize(racaAnimalConsulta.getPreferredSize());
        painelDadosVisualizacao.add(racaAnimalConsulta);

        JLabel labelIdade = new JLabel("Idade");
        labelIdade.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelIdade);
        idadeAnimalConsulta = new JTextField(20);
        idadeAnimalConsulta.setEditable(false);
        idadeAnimalConsulta.setAlignmentX(LEFT_ALIGNMENT);
        idadeAnimalConsulta.setMaximumSize(idadeAnimalConsulta.getPreferredSize());
        painelDadosVisualizacao.add(idadeAnimalConsulta);

        JLabel labelNomeTutor = new JLabel("Tutor");
        labelNomeTutor.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelNomeTutor);
        nomeTutorConsulta = new JTextField(20);
        nomeTutorConsulta.setEditable(false);
        nomeTutorConsulta.setAlignmentX(LEFT_ALIGNMENT);
        nomeTutorConsulta.setMaximumSize(nomeTutorConsulta.getPreferredSize());
        painelDadosVisualizacao.add(nomeTutorConsulta);

        JLabel labelTelefone = new JLabel("Telefone");
        labelTelefone.setAlignmentX(LEFT_ALIGNMENT);
        painelDadosVisualizacao.add(labelTelefone);
        telefoneTutorConsulta = new JTextField(20);
        telefoneTutorConsulta.setEditable(false);
        telefoneTutorConsulta.setAlignmentX(LEFT_ALIGNMENT);
        telefoneTutorConsulta.setMaximumSize(telefoneTutorConsulta.getPreferredSize());
        painelDadosVisualizacao.add(telefoneTutorConsulta);

        painelDireito.add(painelDadosVisualizacao);
        painelDireito.add(Box.createVerticalStrut(10)); // separa o bloco de cima do bloco de baixo

        // outra painel menor para a Lista de Consultas Agendadas
        JPanel painelListaConsultas = new JPanel();
        painelListaConsultas.setLayout(new BoxLayout(painelListaConsultas, BoxLayout.Y_AXIS));
        painelListaConsultas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Consultas Agendadas"),
            BorderFactory.createEmptyBorder(5, 10, 10, 10)
        ));
        painelListaConsultas.setAlignmentX(LEFT_ALIGNMENT);

        areaConsultas = new JTextArea(6, 25);
        areaConsultas.setEditable(false);

        JScrollPane scrollConsultas = new JScrollPane(areaConsultas);
        scrollConsultas.setAlignmentX(LEFT_ALIGNMENT);

        painelListaConsultas.add(scrollConsultas);
        painelDireito.add(painelListaConsultas);

        painel.add(painelDireito);
        return painel;
    }
}