package qintess.exercicio.classes.model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

public class Venda {
	private long id;
	private Date dataatual;
	private Cliente cliente;
	private Produto produto;
	private Double total;
	private List<Produto> produtos;
	private List<Cliente> clientes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataatual() {
		return dataatual;
	}
	public void setDataatual(Date dataatual) {
		this.dataatual = dataatual;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", DATA: " + this.getDataatual() + ", TOTAL: " +  NumberFormat.getCurrencyInstance().format(this.getTotal()) + "\n";
	}




	
}
