/**Aqui ele recebera a ficha modelo do Animal e do Tutor que é o construtor de cada um,
 * ira receber tambem os dados que o usuários digitou no view,
 * após isso ele irá tratar os dados e criar o objeto que será o animal x
*/
package clinica.controller;

import clinica.model.Animal;//pegamos a "ficha modelo" de cadastro do animal
import clinica.model.Tutor;//pegamos a "ficha modelo" de cadastro do dono
import java.util.ArrayList;// aqui importamos o array list pq diferente do array normal, nele não precisamos definir um tamanho fixo, nós vamos adicionando os dados e ele vai crescendo conforme necessário
import java.util.List;

public class CadastroController {

    List<Animal> animais = new ArrayList<>();

    public boolean salvarAnimal(String nome, String especie, String raca, String idade, String sexo) {
        if (nome.isEmpty() || especie.isEmpty() || raca.isEmpty() || idade.isEmpty() || sexo.isEmpty()) {
            return false;
        } else {
            Animal animal = new Animal(nome, especie, raca, idade, sexo);
            animais.add(animal);
            return true;
        }

    }
}
