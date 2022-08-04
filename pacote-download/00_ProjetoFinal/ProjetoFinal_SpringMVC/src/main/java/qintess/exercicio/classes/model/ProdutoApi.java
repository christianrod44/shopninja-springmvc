package qintess.exercicio.classes.model;

import java.text.NumberFormat;
import java.util.List;

public class ProdutoApi {

	private long id;
	private String nome;
	private String descricao;
	private Double valor;
//	private Venda venda;
	private List<Venda> vendas;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
//	public Venda getVenda() {
//		return venda;
//	}
//	public void setVenda(Venda venda) {
//		this.venda = venda;
//	}
	public List<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", Nome: " + this.getNome() + ", Valor: " + NumberFormat.getCurrencyInstance().format(this.getValor()) + "\n";
	}
	
	
	
}