import java.io.*;
import java.util.*;

public class Validar {
	Scanner teclado;
	public Validar() {
		teclado = new Scanner(System.in);
	}
	public int ingresar(String titulo) throws InterruptedException {
		String sel="";
		while(sel.equals(""))
		{
			System.out.print(titulo);
			sel = teclado.nextLine();
			if(!sel.matches("^-*[0-9]*$")) {
				sel="";
				System.out.println("\n\n\nIngresa un valor valido e intenta nuevamente...\n\n\n");
				Thread.sleep(2000);
			}
		}
		return Integer.parseInt(sel);
	}
	
}
