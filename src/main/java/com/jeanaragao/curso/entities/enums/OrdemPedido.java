package com.jeanaragao.curso.entities.enums;



public enum OrdemPedido {

	AGUARDANDO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private OrdemPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static OrdemPedido valueOf(int codigo) {
		for(OrdemPedido value : OrdemPedido.values()) {
			if(value.getCodigo() == codigo){
				return value;
			}
		}
		throw new IllegalArgumentException("Código OrdemPedido inválido");
	}
	
}
