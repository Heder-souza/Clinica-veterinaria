package clinica.model; // Avisa que o arquivo está na pasta "model" dentro da raiz "clinica".
// A pasta "model" serve para o modelo de classes do sitema

public class Tutor { // Declara a classe pública Tutor, que tera seus proprios atributos
// Toda pessoa que levar um pet na clínica vai ter seus dados gerados a partir deste bloco aqui

    private String nomeTutor;  // Atributo de texto privado para guardar o nome do dono com segurança, ele cria esses atributos na classe, esse é o nome
    private String telefone;   // Cria otributo texto(String) do telefone
    private String cpf;        // Cria o atributo cpf

    public Tutor(String nomeTutor, String telefone, String cpf) {  // É o construtor da classe. Ele exige que, ao criar o tutor, a gente passe o nome dele, o telefone e o CPF
        this.nomeTutor = nomeTutor; // O "this" significa "deste tutor", que pega o nome que o usuário digitou na tela e joga na variável.
        this.telefone = telefone; // Pega o telefone 
        this.cpf = cpf; // Pega o cpf
    } // Fecha o public tutor

    public String getNomeTutor() { return nomeTutor; } //Como o nome do tutor está privado, ele abre uma porta. Devolve o texto do nome do dono para as outras telas ou classes.
    public String getTelefone()  { return telefone; } // Pega e retorna o telefone, tudo na mesma linha
    public String getCpf()       { return cpf; } //pega e retorna o telefone
} // Fecha essa classe
