package aeroport.sgbag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Hello world!
 * 
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class App {

	@Getter
	private String exemple;

	public static void main(String[] args) {
		System.out.println("Hello World! This is a test. Ok.");
	}
}
