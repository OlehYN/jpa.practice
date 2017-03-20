package practice.jpa.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@NamedQueries({
    @NamedQuery(name="teacher.findAll",
                query="SELECT t FROM Teacher t"),
    @NamedQuery(name="teacher.findByName",
                query="SELECT t FROM Teacher t WHERE t.firstName = :name"),
}) 
public class Teacher {

	@Id
	@Column(name ="teached_id", unique = true, nullable = false)
	@GeneratedValue
	private Long teachedId;
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
	private Set<Subject> subjects;

	public Long getTeachedId() {
		return teachedId;
	}

	public void setTeachedId(Long teachedId) {
		this.teachedId = teachedId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teachedId == null) ? 0 : teachedId.hashCode());
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
		Teacher other = (Teacher) obj;
		if (teachedId == null) {
			if (other.teachedId != null)
				return false;
		} else if (!teachedId.equals(other.teachedId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teachedId=" + teachedId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", entryDate=" + entryDate + "]";
	}
	
}
