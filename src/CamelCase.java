import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	public static List<String>converterCamelCase(String original) {
		
		if(estarVazia(original))
			throw new palavraVaziaExcpetion("vazia");
		
		if(iniciaComNumero(original)) 
			throw new iniciaComNumeroException("não deve começar com número");
		
		if(contemCaractersEspeciais(original))
			throw new contemCaractersEspeciais("caracteres especiais não são permitidos, somente letras e números");
		
		return separarCamelCase(original);
	}
	
	
	public static boolean estarVazia(String original) {
		return (original == null || original.length() == 0 || original == " ");
	}
	
	public static boolean iniciaComNumero(String original) {
		return (original.substring(0).matches("[0-9].*"));
			
	}
	

	public static boolean contemCaractersEspeciais(String original) {
		return (analisadorCaractersEspeciais(original));
	}


	public static List<String> separarCamelCase(String original) {
		String[] separando = original.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
		return palavraLowerCase(separando);
	}
	
	private static List<String> palavraLowerCase(String[] separando) {
		List<String> palavraLowerCase = new ArrayList<String>();
		
		for(int cont=0; cont<separando.length; cont++) {
			if(separando[cont].toUpperCase() == separando[cont]) {
				palavraLowerCase.add(separando[cont]);
			} else {
			palavraLowerCase.add(separando[cont].toLowerCase());
			}
		}
		return palavraLowerCase;	
	}
	
	public static boolean analisadorCaractersEspeciais(String original) {
		for(int cont=0; cont<original.length(); cont++) {
			if(original.substring(cont).matches("[!#@$%¨&*()/].*"))
				return true;
		}
		return false;
	}
}