package gal.teis.model;

import java.util.ArrayList;

public class Module {

	public static final int STUDENT_LIMIT = 30;
	
	private String code;
	private String name;
	private Professor professor;
	private ArrayList<Student> students = new ArrayList<>();
	
	public Module(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public Module(String code, String name, Professor professor) {
		this(code, name);
		this.professor = professor;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	@Deprecated
	public void setStudents(ArrayList<Student> students) {
		throw new UnsupportedOperationException("Use registerStudents(Stundent... newStudents)");
	}

	public boolean registerStudents(Student... newStudents) {
		boolean success = false;
		if (students.size() + newStudents.length <= STUDENT_LIMIT) {
			for (Student s : newStudents) {
				this.students.add(s);
			}
			success = true;
		}
		return success;
	}
	
	public void removeStudents(Student... studentsToRemove) {
		for (Student s : studentsToRemove) {
			this.students.remove(s);
		}
	}
}
