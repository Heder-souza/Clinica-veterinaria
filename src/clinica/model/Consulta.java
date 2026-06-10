package clinica.model; // Avisa que o arquivo está na pasta "model" dentro da raiz "clinica", que junta todo o padrão MVC.
// A pasta "model" serve especificamente para guardar as classes e as características dos dados do sistema.

public class Consulta { // Declara a classe pública Consulta.
    // Toda nova consulta que fizer na tela vai nascer a partir deste bloco aqui.
    
    private Animal animal; // Faz a associação direta da consulta com o objeto completo do "Animal" que está sendo atendido.
    // Assim o Java liga a consulta ao animal, consegundo puxar todos os dados dele.
    private String tipo; // Atributo de texto privado para guardar o tipo do atendimento
    private String observacoes; // Atributo de texto privado para armazenar os detalhes

    public Consulta(Animal animal, String tipo, String observacoes){  // É o construtor da classe, fnciona como o registro obrigatório do atendimento no sistema, que aqui é denominada consulta
    // Ele exige que, ao iniciar a consulta, a gente passe o animal que está ali, o tipo do atendimento e os detalhes, pro isso está (...)
        
        this.animal = animal;// Pega o bicho selecionado na tela e joga na variável.
        this.tipo = tipo; // Transfere o tipo de consulta que veio do formulário para o atributo
        this.observacoes = observacoes; // Grava as observaçoes
    } // Fecha Esse public

    public Animal getAnimal(){ // Método Getter (pegador de dados), pega os dados dos animais
        return animal; //retorna esses dsdaos
    } // fecha esse get

    public String getTipo(){ // pega o tipo
        return tipo; //retorna o tipo
    } // fecha o tipo

    public String getObservacoes(){ //pega as observacoes
        return observacoes; //retorna as observacoes
    } //fexha esse get
} // fecha toda essa classe consulta
