package ex08.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.DatabaseDev;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;
import ex04.quiz.Battery2;
import ex04.quiz.Car;
import ex04.quiz.IBattery;

@Configuration //이 클래스가 스프링 설정 파일이라는 것을 표기 - xml문서를  자바에서 사용
public class JavaConfig {
	
	
//	<bean id="chef" class = "ex02.construct.Chef"/>
//	<bean id="hotel" class = "ex02.construct.Hotel">
//		<constructor-arg ref="chef"/>
//	</bean>
	
	//@Bean이 붙은 메서드를 스프링컨테이너가 객체로 생성합니다.
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Hotel hotel() {
		return new Hotel( chef() );
	}
	
	
//	<bean id = "db" class="ex03.setter.DatabaseDev">
//	<property name = "url" value ="bean으로넣은데이터베이스주소"/>
//	<property name = "uid" value ="bean으로넣은데이터베이스아이디"/>
//	<property name = "upw" value ="bean으로넣은데이터베이스비밀번호"/>
//	</bean>
	
//	<bean id = "dao" class = "ex03.setter.MemberDAO">
//	<property name ="ds" ref="db"/>
//	/bean>
	
	@Bean
	public DatabaseDev db() {
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("자바로 설정한 데이터베이스 주소");
		dev.setUid("자바로 설정한 아이디");
		dev.setUpw("자바로 설정한 비밀번호");
		return dev;
	}
	
	@Bean
	public MemberDAO dao() {
		MemberDAO dao = new MemberDAO();
		dao.setDs(db());
		return dao;
	}
	
	
	
//	<bean id = "battery1" class="ex04.quiz.Battery1"/>
//	<bean id = "battery2" class="ex04.quiz.Battery2"/>
//	<bean class="ex04.quiz.Car">
//		<constructor-arg ref="battery1"/>
//	</bean>
//	
//	<bean class="ex04.quiz.Airplane">
//		<property name = "battery" ref ="battery2"/>
//		
//	</bean>
	@Bean
	public Battery1 battery1() {
		return new Battery1();
	}
	
	@Bean
	public Battery2 battery2() {
		return new Battery2();
	}
	
	@Bean
	public Car car() {
		return new Car(battery1());
	}
	
	@Bean
	public Airplane air() {
		Airplane air = new Airplane();
		air.setBattery(battery2());
		return air;
	}
	
}
