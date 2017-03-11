package practice.jpa.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gradebook")
public class Gradebook {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "student_id", unique = true, nullable = false)
	private Long studentId;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Student student;
	
	@Column(name = "issue_date", nullable = false)
	private Date issueDate;
	
	@Column(name = "expiration_date", nullable = false)
	private Date expirationDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "markGradebook")
	private Set<Mark> marks;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
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
		Gradebook other = (Gradebook) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gradebook [studentId=" + studentId + ", student=" + student + ", issueDate=" + issueDate
				+ ", expirationDate=" + expirationDate + "]";
	}
	
}
