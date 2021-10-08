package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements  Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mat;
	@Column(length=100)
	private String nom;
	@Column(length=100)
	private String prenom;
	@Column(length=20)
	private int tel;

	@OneToMany(mappedBy="etudiant", fetch=FetchType.LAZY)
	private List<Note> notes = new ArrayList<Note>();
public Etudiant() {
	
}
public int getMat() {
	return mat;
}
public void setMat(int mat) {
	this.mat = mat;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public int getTel() {
	return tel;
}
public void setTel(int tel) {
	this.tel = tel;
}
public List<Note> getNotes() {
	return notes;
}
public void setNotes(List<Note> notes) {
	this.notes = notes;
}

}
