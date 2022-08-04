package qintess.exercicio.classes.model;

public class Cliente {
	private int id;
	private String nome;
	private long cpf;
	private long cep;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String uf;
//	private Venda venda;
//	private List<Venda> vendas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
//	public Venda getVenda() {
//		return venda;
//	}
//	public void setVenda(Venda venda) {
//		this.venda = venda;
//	}
//	public List<Venda> getVendas() {
//		return vendas;
//	}
//	public void setVendas(List<Venda> vendas) {
//		this.vendas = vendas;
//	}

	
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", Nome: " + this.getNome() + ", CPF: " +  String.format("%011d", this.getCpf()) + "\n";
	}
	
	
}
