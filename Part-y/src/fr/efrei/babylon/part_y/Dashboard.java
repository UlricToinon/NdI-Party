package fr.efrei.babylon.part_y;

public class Dashboard {

	private String image;
	private String titre;
	private String date;
	private String description;
	private String prix;
	
	public Dashboard(String image, String titre, String date,
			String description, String prix) {
		super();
		this.image = image;
		this.titre = titre;
		this.date = date;
		this.description = description;
		this.prix = prix;
	}
	
	
	
	public Dashboard(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}



	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}

	
}
