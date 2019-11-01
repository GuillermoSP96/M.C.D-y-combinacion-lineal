
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AlgoritmoEuclides {
	private ArrayList<String> buffer = new ArrayList<String>();
	private ArrayList<String> bufferRes = new ArrayList<String>();

	public AlgoritmoEuclides() {
	}

	public AlgoritmoEuclides(ArrayList<String> buffer) {
		super();
		this.buffer = buffer;
		this.bufferRes = bufferRes;
	}

	public static int euclides(ArrayList<String> buffer, int a, int b) {
		if (b == 0)
			return a;
		else {
			// System.out.println("mcd("+a+","+b+")");
			int q = a / b;
			// System.out.println("valor de q:"+q);
			int res = a % b;
			// System.out.println("Valor de res:"+res);
			int mcd = euclides(buffer, b, res);
			// System.out.println("Valor de mcd:"+mcd);
			guardar(buffer, a, b, q, res);
			return mcd;
		}
	}

	public static void benz(int old_r, int r) {
		int a = old_r, b = r;
		boolean negative = false;
		int s, old_t;
		s = old_t = 0;
		int old_s, t;
		old_s = t = 1;

		if (r < 0) {
			r = -r;
			negative = true;
		}
		int q = 1;
		int aux_r,aux_s,aux_t;
		while (r > 0) {
			q = old_r / r;
			// #MCD:
			aux_r = r;
			r = old_r - q * r;
			old_r=aux_r;
			// #Coeficiente s:
			aux_s = s;
			s = old_s - q * s;
			old_s = aux_s;
			// #Coeficiente t:
			aux_t = t;
			t = old_t - q * t;
			old_t = aux_t;
		}
		if (negative)
			old_t = old_t * -1;

		System.out.println(" "+a + "(" + old_s + ") + " + b + "(" + old_t + ") = " + old_r);
	}

	public static void guardar(ArrayList<String> buffer, int a, int b, int q, int res) {
		AlgoritmoEuclides ae = new AlgoritmoEuclides(buffer);
		buffer.add(a + " = " + b + " * " + q + " + " + res);
	}

	public static void imprime(ArrayList<String> buffer) {
		for (int i = buffer.size() - 1; i >= 0; i--)
			System.out.println("  " + buffer.get(i));
		System.out.println("\n");
	}

	public static void main(String[] args) throws InterruptedException {
		AlgoritmoEuclides ae;
		Validar v = new Validar();
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		boolean f = true;
		while (f) {
			ae = new AlgoritmoEuclides();
			a = v.ingresar("Da un numero: ");
			b = v.ingresar("Da el siguiente numero: ");
			
			System.out.println("\n\n mcd(" + a + "," + b + ")= " + euclides(ae.buffer, a, b) + "\n");
			imprime(ae.buffer);
			benz(a, b);
			Thread.sleep(2000);
			f = false;
		}
	}
}
