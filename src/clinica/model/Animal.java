/**Representa um animal cadastrado 
 * na clinica
 */

package clinica.model;

public class Animal {//aqui é a "gaveta" que é onde o dado vai ficar guardado
    String nome;
    String especie;
    String raca;
    String idade;
    String sexo;
    Tutor tutor;

    public Animal(String nome, String especie, String raca, String idade, String sexo, Tutor tutor){//aqui ele recebe onde ele irá guardar cada coisa
        this.nome = nome;// aqui ele guarda o que for o nome na gaveta animal xxx e assim sucessivamente
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.tutor = tutor;
    }
}


