package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {
	//키보드, 마우스, 모니터에 대한 멤버변수를 만들고, resource, autowired를 사용해서 자동주입.
	//main에서  computerInfo()확인
	
	@Resource(name ="key")
	
	private Keyboard key;
	@Autowired
	@Qualifier("mon")
	private Monitor mon;
	@Autowired
	@Qualifier("mouse")
	private Mouse mouse;
	
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Computer(Keyboard key, Monitor mon, Mouse mouse) {
		super();
		this.key = key;
		this.mon = mon;
		this.mouse = mouse;
	}

	


	public Keyboard getKey() {
		return key;
	}




	public void setKey(Keyboard key) {
		this.key = key;
	}




	public Monitor getMon() {
		return mon;
	}




	public void setMon(Monitor mon) {
		this.mon = mon;
	}




	public Mouse getMouse() {
		return mouse;
	}




	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}




	public void computerInfo() {
		System.out.print("마우스 :");
		mouse.info();
		System.out.print("모니터 :");
		mon.info();
		System.out.print("키보드 :");
		key.info();
	}
}
