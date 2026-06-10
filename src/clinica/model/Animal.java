package clinica.model;

public class Animal {

    private String nome;
    private String especie;
    private String raca;
    private String idade;
    private String sexo;
    private Tutor tutor;

    public Animal(String nome, String especie, String raca, String idade, String sexo, Tutor tutor) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.tutor = tutor;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public Tutor getTutor() {
        return tutor;
    }
    
}