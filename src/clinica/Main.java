/**
 * Main - É aqui que o sistema começa a rodar,
 * serve exclusivamente para inicializar a janela principal.
 */

package clinica; // // Avisa que este arquivo está na pasta raiz do projeto, chamada "clinica"

import clinica.view.JanelaPrincipal; // Importa a classe JanelaPrincipal
// O Java precisa dessa linha para saber onde encontrar a tela que vai ser aberta
   
public class Main { // Declara a classe pública Main, que funciona como o inicializador
    public static void main(String[] args) { // Este é o método principal (main) Ele é o primeiro bloco de código executado quando o programa liga.
    
        new JanelaPrincipal();// A palavra "new" cria e joga na memória RAM o objeto da tela principal do sistema.
        // Ela abre a janela principal
    } //fecha  o void main
}//fecha o main
