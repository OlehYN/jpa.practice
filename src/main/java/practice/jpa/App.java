package practice.jpa;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
		
		Student student2 = new Student();
		student2.setEntryDate(new Date(System.currentTimeMillis()));
		student2.setFirstName("Тест4");
		student2.setLastName("Тест4");

		Gradebook gradebook = new Gradebook();
		gradebook.setIssueDate(new Date(System.currentTimeMillis()));
		gradebook.setExpirationDate(new Date(System.currentTimeMillis()));
		
		Gradebook gradebook2 = new Gradebook();
		gradebook2.setIssueDate(new Date(System.currentTimeMillis()));
		gradebook2.setExpirationDate(new Date(System.currentTimeMillis()));

		student.setGradebook(gradebook);
		gradebook.setStudent(student);
		studentService.create(student);
		
		student2.setGradebook(gradebook2);
		gradebook2.setStudent(student2);
		studentService.create(student2);

		Teacher teacher = new Teacher();
		teacher.setFirstName("Тест2");
		teacher.setLastName("Тест2");
		teacher.setEntryDate(new Date(System.currentTimeMillis()));
		
		Teacher teacher2 = new Teacher();
		teacher2.setFirstName("Тест3");
		teacher2.setLastName("Тест3");
		teacher2.setEntryDate(new Date(System.currentTimeMillis()));

		Set<Teacher> teachers = new HashSet<>();
		teachers.add(teacherService.create(teacher));
		teachers.add(teacherService.create(teacher2));

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

		System.out.println();
		System.out.println("JPQL:");
		System.out.println(studentService.getBestStudents());
		System.out.println(studentService.maxSubjects());
		
		System.out.println();
		System.out.println("Cache checking:");
		System.out.println(markService.getMarksByStudent(student));
		System.out.println(markService.getMarksByStudent(student));
		System.out.println(markService.getMarksByStudent(student));

		System.out.println();
		System.out.println("Named queries:");
		TypedQuery<Teacher> query = context.getBean(EntityManagerFactory .class).createEntityManager().createNamedQuery("teacher.findAll", Teacher.class);
		System.out.println(query.getResultList());

		TypedQuery<Teacher> query2 = context.getBean(EntityManagerFactory .class).createEntityManager().createNamedQuery("teacher.findByName", Teacher.class).setParameter("name", "Тест2");
		System.out.println(query2.getResultList());
		
		context.close();
	}
}
