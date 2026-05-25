/**Representa um tutor cadastrado 
 * na clinica
 */

package clinica.model;

public class Tutor {
    String nomeTutor;
    String telefone;
    String cpf;

    public Tutor(String nomeTutor, String telefone, String cpf){
        this.nomeTutor = nomeTutor;
        this.telefone = telefone;
        this.cpf = cpf;
    }
}
