package clinica.model;

public class Tutor {

    private String nomeTutor;  
    private String telefone;   
    private String cpf;        

    public Tutor(String nomeTutor, String telefone, String cpf) {
        this.nomeTutor = nomeTutor;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNomeTutor() { return nomeTutor; }
    public String getTelefone()  { return telefone; }
    public String getCpf()       { return cpf; }
}