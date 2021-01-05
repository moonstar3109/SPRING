package ex07.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("computer-context.xml");
		
		Computer c = ctx.getBean(Computer.class);
		c.computerInfo();
	}
	
}
