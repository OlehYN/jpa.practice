package practice.jpa;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.jpa.entity.Gradebook;
import practice.jpa.entity.Mark;
import practice.jpa.entity.ScaleType;
import practice.jpa.entity.Student;
import practice.jpa.entity.Subject;
import practice.jpa.entity.Teacher;
import practice.jpa.service.MarkService;
import practice.jpa.service.StudentService;
import practice.jpa.service.SubjectService;
import practice.jpa.service.TeacherService;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		StudentService studentService = (StudentService) context.getBean(StudentService.class);
		TeacherService teacherService = (TeacherService) context.getBean(TeacherService.class);
		SubjectService subjectService = (SubjectService) context.getBean(SubjectService.class);
		MarkService markService = (MarkService) context.getBean(MarkService.class);
		
		Student student = new Student();
		student.setEntryDate(new Date(System.currentTimeMillis()));
		student.setFirstName("Тест1");
		student.setLastName("Тест1");
		
		Gradebook gradebook = new Gradebook();
		gradebook.setIssueDate(new Date(System.currentTimeMillis()));
		gradebook.setExpirationDate(new Date(System.currentTimeMillis()));
		
		student.setGradebook(gradebook);
		gradebook.setStudent(student);
		studentService.create(student);
		
		Teacher teacher = new Teacher();
		teacher.setFirstName("Тест2");
		teacher.setLastName("Тест2");
		teacher.setEntryDate(new Date(System.currentTimeMillis()));
		
		Set<Teacher> teachers = new HashSet<>();
		teachers.add(teacherService.create(teacher));
		
		Subject subject = new Subject();
		subject.setCredits(3);
		subject.setName("Java EE");
		subject.setTeachers(teachers);
		
		subjectService.create(subject);
		
		Mark mark = new Mark();
		mark.setMark(100);
		mark.setMarkGradebook(gradebook);
		mark.setMarkSubject(subject);
		mark.setScale(ScaleType.A);
		
		markService.create(mark);
		
		context.close();
	}
}
