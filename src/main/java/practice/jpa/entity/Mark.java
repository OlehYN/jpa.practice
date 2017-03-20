package practice.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark {
	
	@Id
	@Column(name = "mark_id")
	@GeneratedValue
	private Long markId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gradebook_id", nullable = false)
	private Gradebook markGradebook;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject markSubject;
	
	@Column(name = "mark", nullable = false)
	private Integer mark;
	
	@Column(name = "scale")
	@Enumerated(EnumType.STRING)
	private ScaleType scale;

	public Long getMarkId() {
		return markId;
	}

	public void setMarkId(Long markId) {
		this.markId = markId;
	}

	public Gradebook getMarkGradebook() {
		return markGradebook;
	}

	public void setMarkGradebook(Gradebook markGradebook) {
		this.markGradebook = markGradebook;
	}

	public Subject getMarkSubject() {
		return markSubject;
	}

	public void setMarkSubject(Subject markSubject) {
		this.markSubject = markSubject;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public ScaleType getScale() {
		return scale;
	}

	public void setScale(ScaleType scale) {
		this.scale = scale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((markId == null) ? 0 : markId.hashCode());
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
		Mark other = (Mark) obj;
		if (markId == null) {
			if (other.markId != null)
				return false;
		} else if (!markId.equals(other.markId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [markId=" + markId + ", markSubject=" + markSubject
				+ ", mark=" + mark + "]";
	}
	
}
