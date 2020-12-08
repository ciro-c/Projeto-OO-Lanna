package entidades;


public class Subcategoria extends Categoria {

	
	private String descricaoSubcategoria;

	public Subcategoria(String descricaoSubcategoria) {
		
		this.descricaoSubcategoria = descricaoSubcategoria;
	}

	public String getDescricaoSubcategoria() {
		return descricaoSubcategoria;
	}

	public void setDescricaoSubcategoria(String descricaoSubcategoria) {
		this.descricaoSubcategoria = descricaoSubcategoria;
	}
	
	
}
