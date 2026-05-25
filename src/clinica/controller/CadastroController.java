/**Aqui ele recebera a ficha modelo do Animal e do Tutor que é o construtor de cada um,
 * ira receber tambem os dados que o usuários digitou no view,
 * após isso ele irá tratar os dados e criar o objeto que será o animal x
*/
package clinica.controller;

import clinica.model.Animal;// pegamos a "ficha modelo" de cadastro do animal
import clinica.model.Tutor;// pegamos a "ficha modelo" de cadastro do dono
import java.util.ArrayList;// aqui importamos o array list pq diferente do array normal, nele não precisamos definir um tamanho fixo, nós vamos adicionando os dados e ele vai crescendo conforme necessário
import java.util.List;// necessário para usarmos o array list

public class CadastroController {

    // lista que guarda todos os animais cadastrados durante o uso do programa
    // funciona como um arquivo que vai crescendo conforme novos animais são
    // cadastrados
    List<Animal> animais = new ArrayList<>();

    // metodo que recebe os dados digitados na tela, valida se estão preenchidos e
    // salva o animal
    // retorna true se salvou com sucesso ou false se algum campo estava vazio
    public boolean salvarCadastro(String nome, String especie, String raca, String idade, String sexo, String nomeTutor,
            String telefone, String cpf) {

        // verifica se algum campo está vazio - se estiver, para aqui e retorna false
        // o || significa (ou), se qualquer um estiver vazio já retorna false
        if (nome.isEmpty() || especie.isEmpty() || raca.isEmpty() || idade.isEmpty() || sexo.isEmpty()) {
            return false;
        }

        if (nomeTutor.isEmpty() || cpf.isEmpty() || telefone.isEmpty()) {
            return false;
        }
        Tutor tutor = new Tutor(nomeTutor, telefone, cpf);
        Animal animal = new Animal(nome, especie, raca, idade, sexo, tutor);
        animais.add(animal);
        return true;
    }
}