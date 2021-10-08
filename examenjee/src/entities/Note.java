package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="note")
@NamedQueries({
	@NamedQuery(name="Note.findByValeur", query="SELECT n FROM Note n WHERE n.valeur = :valeur"),
	@NamedQuery(name="Note.findByAnnee", query="SELECT n FROM Note n WHERE n.annee = :annee"),
	@NamedQuery(name="Note.findBySemestre", query="SELECT n FROM Note n WHERE n.semestre = :semestre"),
	@NamedQuery(name="Note.findByMatiere", query="SELECT n FROM Note n WHERE n.matiere = :matiere"),
	@NamedQuery(name="Note.findByType", query="SELECT n FROM Note n WHERE n.type = :type"),
	@NamedQuery(name="Note.findByEtudiant", query="SELECT n FROM Note n WHERE n.etudiant.mat = :mat"),
	@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
})
public class Note implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idN;
	@Column(length=75)
	private Double valeur;
	@Column(length=20)
	private Integer annee;
	@Column(length=20)
	private Integer semestre;
	@Column(length=100)
	private String matiere;
	@Column(length=100)
	private String type;
	@ManyToOne
	@JoinColumn(name="etudiant_ID")
	private Etudiant etudiant;
	public Note () {
		super();
	}
	public Integer getIdN() {
		return idN;
	}
	public void setIdN(Integer idN) {
		this.idN = idN;
	}
	public Double getValeur() {
		return valeur;
	}
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
}
