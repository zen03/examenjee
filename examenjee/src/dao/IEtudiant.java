package dao;

import java.util.List;

import entities.Etudiant;



public interface IEtudiant {
	public int add(Etudiant etudiant);
	public int delete(int mat);
	public int update(Etudiant etudiant);
	public List<Etudiant> liste();
	public Etudiant getServeurById(int mat);
}
