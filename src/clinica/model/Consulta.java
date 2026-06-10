package clinica.model;

public class Consulta {
    private Animal animal;
    private String tipo;
    private String observacoes;

    public Consulta(Animal animal, String tipo, String observacoes){
        this.animal = animal;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    public Animal getAnimal(){
        return animal;
    }

    public String getTipo(){
        return tipo;
    }

    public String getObservacoes(){
        return observacoes;
    }
}
