package fr.eni.encheres.bo;

public class Retrait {

	private Integer noArticle;
	private String rue;
	private String codePostal;
	private String ville;

	public Retrait() {
	}

	public Retrait(Integer noArticle, String rue, String codePostal, String ville) {
		this.setNoArticle(noArticle);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [noArticle=" + noArticle + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
}
