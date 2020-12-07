package entidades;


public class Categoria {

	private String descricaoCategoria;
	Subcategoria sub[];
	
	public Categoria(String descricaoCategoria) {
		super();
		this.descricaoCategoria = descricaoCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}



	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}



	public void cadastrarSubcategoria() {
		
	}
}
