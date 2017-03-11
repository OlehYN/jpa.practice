package practice.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name = "subject_id")
	private Long subjectId;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "credits", nullable = false)
	private Integer credits;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "markSubject")
	private Set<Mark> marks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_teacher", joinColumns = {
			@JoinColumn(name = "teacher_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "subject_id",
					nullable = false, updatable = false) })
	private Set<Teacher> teachers;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", credits=" + credits + "]";
	}

}
