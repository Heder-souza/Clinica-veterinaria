package clinica.model; // Define que este arquivo pertence ao pacote "model", que por sua vez fica dentro da pasta principal "clinica".
// Na arquitetura do sistema, a pasta model guarda as classes e seus atributos.
// No nosso projeto, a pasta "clinica" é a raiz que junta todo o padrão MVC. 

public class Animal { // Declara a classe pública chamada Animal
// Os "animais" de verdade que vão aparecer no nosso sistema são os objetos do código, que estão começando aqui. 
// Então, avisamos ao Java que vamos listar todas as características que um animal precisa ter para existir dentro do programa da clínica.
// Todo bicho que o usuário cadastrar na tela vai nascer a partir desse bloco de código aqui.

    // String é o padrão java para guardar textos
    // O "private" impede que qualquer outra tela ou arquivo de fora mexa nesse nome direto.
    private String nome; // Atributo de texto privado para guardar o nome do amnimal.
    private String especie; // Atributo de texto privado para salvar se o pet é um cachorro, gato, ave, etc, para guardar a especie do bicho.
    private String raca; // Atributo de texto privado para armazenar a raça específica do bicho.
    private String idade; // Atributo de texto privado para a idade..
    private String sexo; // Atributo de texto privado para salvar se o sexo do animal é Masculino ou Feminino.
    private Tutor tutor; // Aqui, liga o animal ao seu respectivo tutor, que tem um arquivo proprio nesse codigo, por iso nao se utiliza string.

    public Animal(String nome, String especie, String raca, String idade, String sexo, Tutor tutor) { 
    // É o construtor da classe, QUe Funciona como criação obrigatória do bicho no sistema.
    // Ele exige que, ao criar o bicho, a gente passe todos os dados dele.
        
        this.nome = nome; // O "this" significa "deste objeto", ele pega o nome digitado na tela e joga na variável, que nesse caso é o nome.
        this.especie = especie; // Pega a espécie enviada pelo formulário e salva
        this.raca = raca; // Guarda a raça que veio da tela
        this.idade = idade; // Pega a idade
        this.sexo = sexo; // Pega o sexo do animal
        this.tutor = tutor; // Pega o tutor do animal
    } //Ele fecha

    public String getNome() { // Método Getter Como o nome é privado, ele serve para abrir os dados. 
    // Pega o dado nome
        return nome; // Devolve o texto que está guardado no atributo privado "nome" para quem pediu.
    } // Fecha esse Get

    public String getEspecie() { // Método Getter libera a leitura da especie do animal
        return especie; // Ele retorna a especie do animal
    } //fecha o getEspecie

    public String getRaca() { // Método Getter deixa os outros arquivos lerem a raça do bicho com segurança.
        return raca; // Dvolve essa String
    } // Fecha o getRaca

    public String getIdade() { // Pega a idade
        return idade; // Devolve a idade
    } // Fecha o getIdade

    public String getSexo() { //Pega o sexo do animal
        return sexo; //Retorna o sexo do animal
    } //Fecha o getSexo

    public Tutor getTutor() { //Pega a classe Tutor
        return tutor; // Retorna a classe tutor
    } //Fecha o getTutor
    
} //Fecha

