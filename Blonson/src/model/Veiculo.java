package model; // Declara que a classe pertence ao pacote 'model'.
              // Isso ajuda a organizar o código por responsabilidade.

// A classe 'Veiculo' representa um veículo na sua aplicação.
public class Veiculo {
    
    // Atributos (campos) da classe. Eles definem as características de um veículo.
    // O modificador 'private' garante que esses atributos só podem ser acessados
    // por métodos dentro desta própria classe, protegendo os dados.
    private String marca; // Armazena a marca do veículo (ex: "Ford").
    private String modelo; // Armazena o modelo do veículo (ex: "Ka").
    private int ano; // Armazena o ano de fabricação do veículo.
    private String placa; // Armazena a placa de identificação do veículo.

    // Construtor da classe.
    // Ele é usado para criar uma nova instância de 'Veiculo' e inicializar seus atributos.
    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca; // 'this.marca' refere-se ao atributo da classe.
                         // 'marca' refere-se ao parâmetro do construtor.
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    // Métodos de acesso (Getters).
    // Eles permitem que outras classes obtenham o valor de um atributo privado.
    // 'public' significa que o método pode ser chamado de qualquer lugar.
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    // Métodos (Comportamentos).
    // Eles definem o que um objeto 'Veiculo' pode fazer.
    public void exibirInformacoesVeiculo() {
        // Exibe todos os detalhes do veículo no console.
        System.out.println("Informações do Veículo:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
    }
}