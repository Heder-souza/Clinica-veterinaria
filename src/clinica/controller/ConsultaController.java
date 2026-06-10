package clinica.controller;

import clinica.model.Consulta; // importa a "ficha modelo" de consulta
import clinica.model.Animal; // importa o modelo de animal pois a consulta precisa saber qual animal é
import java.util.ArrayList; // lista que cresce conforme adicionamos consultas
import java.util.List; // necessário para usar o ArrayList

public class ConsultaController {

    // lista que guarda todas as consultas registradas durante o uso do programa
    List<Consulta> consultas = new ArrayList<>();

    // recebe os dados da consulta, valida e salva
    // retorna true se salvou ou false se algum campo obrigatório estava vazio
    public boolean salvarConsulta(Animal animal, String tipo, String observacoes) {

        // animal não pode ser nulo e tipo não pode estar vazio
        if (animal == null || tipo.isEmpty()) {
            return false;
        }

        // cria o objeto consulta com os dados recebidos e adiciona na lista
        Consulta consulta = new Consulta(animal, tipo, observacoes);
        consultas.add(consulta);
        return true;
    }

    // retorna a lista completa de consultas para quem precisar ler
    public List<Consulta> getConsultas() {
        return consultas;
    }
}