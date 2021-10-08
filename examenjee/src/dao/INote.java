package dao;

import java.util.List;

import entities.Note;




public interface INote {
	public int add(Note note);
	public int delete(int idn);
	public int update(Note note);
	public List<Note> liste();
	public Note getServiceById(int idn);
}
