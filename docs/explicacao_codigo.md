# Explicação Detalhada do Código

Este documento apresenta a análise técnica e o detalhamento do código do Sistema de Clínica Veterinária, é importate ressaltar, que boa parte da explicacao já está incluida como comentario no proprio codigo, pórem nesse arquivo veremos isso linha por linha e de uma forma muito mais detalhada.

---

Todos os arquivos apresentados estão nesse caminho: src --> clínica

## Main.java
```text
/**
 * Main - É aqui que o sistema começa a rodar,
 * serve exclusivamente para inicializar a janela principal.
 */

package clinica;

import clinica.view.JanelaPrincipal;
   
public class Main {
    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}
```
 /**
 * Main - É aqui que o sistema começa a rodar,
 * serve exclusivamente para inicializar a janela principal.
 */
