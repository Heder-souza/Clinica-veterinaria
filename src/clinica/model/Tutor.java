/**Representa um tutor cadastrado 
 * na clinica
 */

package clinica.model;

public class Tutor {
    String nome;
    String telefone;
    String cpf;

    public Tutor(String nome, String telefone, String cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }
}
