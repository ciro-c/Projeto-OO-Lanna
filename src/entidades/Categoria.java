package entidades;


public class Categoria {

	private String descricaoCategoria;
	public Subcategoria sub;
	
	public Categoria(){
		
	}	
	
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



	public void cadastrarSubcategoria(String descricaoSubcategoria) {
		sub = new Subcategoria(descricaoSubcategoria);
	}
}
