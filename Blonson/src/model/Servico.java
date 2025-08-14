package model; // Declara que a classe pertence ao pacote 'model'.
              // Isso ajuda a organizar o código por responsabilidade (separando modelos, controladores, etc.).

// A classe 'Servico' representa um serviço oferecido pela oficina.
public class Servico {
    
    // Atributos (campos) da classe. Eles definem as características de um serviço.
    // O modificador 'private' garante que esses atributos só podem ser acessados
    // por métodos dentro desta própria classe, protegendo os dados.
    private String descricao; // Armazena a descrição detalhada do serviço.
    private double custo; // Armazena o custo do serviço.
    private double tempoEstimadoEmHoras; // Armazena o tempo estimado de duração do serviço, em horas.
    private boolean concluido; // Armazena o status do serviço (true se concluído, false se pendente).

    // Construtor da classe.
    // Ele é usado para criar uma nova instância de 'Servico' e inicializar seus atributos.
    public Servico(String descricao, double custo, double tempoEstimadoEmHoras) {
        this.descricao = descricao; // 'this.descricao' refere-se ao atributo da classe.
                                   // 'descricao' refere-se ao parâmetro do construtor.
        this.custo = custo;
        this.tempoEstimadoEmHoras = tempoEstimadoEmHoras;
        this.concluido = false; // Por padrão, o serviço é criado como não concluído.
    }

    // Métodos de acesso (Getters).
    // Eles permitem que outras classes obtenham o valor de um atributo privado.
    // 'public' significa que o método pode ser chamado de qualquer lugar.
    public String getDescricao() {
        return descricao;
    }

    public double getCusto() {
        return custo;
    }

    public double getTempoEstimadoEmHoras() {
        return tempoEstimadoEmHoras;
    }

    // O getter para um booleano é geralmente chamado de 'isConcluido'.
    public boolean isConcluido() {
        return concluido;
    }

    // Métodos (Comportamentos).
    // Eles definem o que um objeto 'Servico' pode fazer.
    public void mostrarDetalhesServico() {
        // Exibe todos os detalhes do serviço no console.
        System.out.println("Detalhes do Serviço:");
        System.out.println("Descrição: " + descricao);
        System.out.println("Custo: R$" + custo);
        System.out.println("Tempo Estimado: " + tempoEstimadoEmHoras + " horas");
        // O operador ternário '?' verifica se 'concluido' é true ou false para exibir a mensagem correta.
        System.out.println("Status: " + (concluido ? "Concluído" : "Pendente"));
    }

    // Método para marcar o serviço como concluído.
    public void marcarConcluido() {
        this.concluido = true; // Altera o valor do atributo 'concluido' para true.
        System.out.println("Serviço '" + descricao + "' marcado como concluído.");
    }
}