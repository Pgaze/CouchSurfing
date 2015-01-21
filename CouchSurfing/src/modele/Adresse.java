package modele;

public class Adresse {
	
	private String ville;
	private int codePostal;
	private String rue;
	private String numeroRue;
	private String numBatiment;
	private String numeroAppart;
	private int etage;
	/**
	 * @param ville
	 * @param codePostal
	 * @param rue
	 * @param numeroRue
	 * @param numBatiment
	 * @param numeroAppart
	 * @param etage
	 */
	private Adresse(String ville, int codePostal, String rue, String numeroRue,
			String numBatiment, String numeroAppart, int etage) {
		this.ville = ville;
		this.codePostal = codePostal;
		this.rue = rue;
		this.numeroRue = numeroRue;
		this.numBatiment = numBatiment;
		this.numeroAppart = numeroAppart;
		this.etage = etage;
	}
	
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the numeroRue
	 */
	public String getNumeroRue() {
		return numeroRue;
	}
	/**
	 * @param numeroRue the numeroRue to set
	 */
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}
	/**
	 * @return the numBatiment
	 */
	public String getNumBatiment() {
		return numBatiment;
	}
	/**
	 * @param numBatiment the numBatiment to set
	 */
	public void setNumBatiment(String numBatiment) {
		this.numBatiment = numBatiment;
	}
	/**
	 * @return the numeroAppart
	 */
	public String getNumeroAppart() {
		return numeroAppart;
	}
	/**
	 * @param numeroAppart the numeroAppart to set
	 */
	public void setNumeroAppart(String numeroAppart) {
		this.numeroAppart = numeroAppart;
	}
	/**
	 * @return the etage
	 */
	public int getEtage() {
		return etage;
	}
	/**
	 * @param etage the etage to set
	 */
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	

}
