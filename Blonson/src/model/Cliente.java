package model; // Declara que a classe pertence ao pacote 'model'.
              // Isso organiza o código por responsabilidade, separando modelos, controladores, etc.

// A classe 'Cliente' representa um cliente na sua aplicação.
public class Cliente {
    
    // Atributos (campos) da classe. Eles definem as características de um cliente.
    // O modificador 'private' garante que esses atributos só podem ser acessados
    // por métodos dentro desta própria classe.
    private String nome; // Armazena o nome completo do cliente.
    private String telefone; // Armazena o número de telefone.
    private String email; // Armazena o endereço de e-mail.
    private int idCliente; // Armazena um identificador único para o cliente.

    // Construtor da classe.
    // Ele é usado para criar uma nova instância de 'Cliente' e inicializar seus atributos.
    public Cliente(String nome, String telefone, String email, int idCliente) {
        this.nome = nome; // 'this.nome' refere-se ao atributo da classe.
                         // 'nome' refere-se ao parâmetro do construtor.
        this.telefone = telefone;
        this.email = email;
        this.idCliente = idCliente;
    }

    // Métodos de acesso (Getters).
    // Eles permitem que outras classes obtenham o valor de um atributo privado.
    // 'public' significa que o método pode ser chamado de qualquer lugar.
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    // Métodos (Comportamentos).
    // Eles definem o que um objeto 'Cliente' pode fazer.
    public void exibirDetalhesCliente() {
        // Exibe todos os detalhes do cliente no console.
        System.out.println("Detalhes do Cliente:");
        System.out.println("ID: " + idCliente);
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }

    // Método para atualizar o telefone do cliente.
    // Ele recebe o novo telefone como parâmetro.
    public void atualizarTelefone(String novoTelefone) {
        this.telefone = novoTelefone; // Atribui o novo valor ao atributo 'telefone'.
        System.out.println("Telefone de " + nome + " atualizado para " + novoTelefone);
    }
}