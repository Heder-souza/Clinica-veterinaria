/**
 * Aqui é onde inicia a primeira tela do sistema
 */

package clinica.view;

import javax.swing.*;// chama a ferramenta Swing para que possa ser usada
import clinica.controller.CadastroController;// importa o controller que irá tratar os dados do cadastro

public class JanelaPrincipal extends JFrame {// aqui avisa pro java que a Janela principal sera um JFrame (exibivel)

    // campos declarados aqui para todos os métodos enxergarem
    CadastroController controller = new CadastroController();// cria o controller que será usado para salvar os dados

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

        JLabel tituloInformacaoAnimal = new JLabel("Dados do animal");
        tituloInformacaoAnimal.setAlignmentX(LEFT_ALIGNMENT);// alinha o titulo à esquerda
        painel.add(tituloInformacaoAnimal);

        JLabel nomeAnimalLabel = new JLabel("Nome");
        nomeAnimalLabel.setAlignmentX(LEFT_ALIGNMENT);// alinha o label à esquerda
        painel.add(nomeAnimalLabel);
        nomeAnimal = new JTextField(20);// 20 = tamanho do campo em colunas
        nomeAnimal.setAlignmentX(LEFT_ALIGNMENT);// alinha o campo à esquerda
        painel.add(nomeAnimal);

        JLabel especie = new JLabel("Especie");
        especie.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(especie);
        comboEspecie = new JComboBox<>(especies);
        comboEspecie.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(comboEspecie);

        JLabel raca = new JLabel("Raça");
        raca.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(raca);
        racaAnimal = new JTextField(20);
        racaAnimal.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(racaAnimal);

        JLabel idade = new JLabel("Idade");
        idade.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(idade);
        idadeAnimal = new JTextField(20);
        idadeAnimal.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(idadeAnimal);

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

        JLabel tituloInformacaoTutor = new JLabel("Tutor Responsável");
        tituloInformacaoTutor.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(tituloInformacaoTutor);

        JLabel nomeTutorLabel = new JLabel("Nome");
        nomeTutorLabel.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(nomeTutorLabel);
        nomeTutor = new JTextField(20);
        nomeTutor.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(nomeTutor);

        JLabel telefone = new JLabel("Telefone");
        telefone.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(telefone);
        telefoneTutor = new JTextField(20);
        telefoneTutor.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(telefoneTutor);

        JLabel cpf = new JLabel("CPF");
        cpf.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(cpf);
        cpfTutor = new JTextField(20);
        cpfTutor.setAlignmentX(LEFT_ALIGNMENT);
        painel.add(cpfTutor);

        // parte dos botões limpar e salvar
        JPanel painelBotoes = new JPanel();// painel interno para deixar os botões lado a lado, pois se colocassemos
                                           // direto no painel direito eles iriam ficar um em cima do outro

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

    private JPanel JanelaConsulta() {
        JPanel consulta = new JPanel();
        JButton teste = new JButton();
        consulta.add(teste);
        return consulta;
    }
}