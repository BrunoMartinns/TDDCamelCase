import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseTest {
	
	private List<String> palavraAnalisadaCamelCase;
	private CamelCase palavra;
	
	@Before
	public void inicializador() {
		palavra = new CamelCase();
	}

	@Test(expected = palavraVaziaExcpetion.class)
	public void palavraInvalidaVazia() {
		palavra.converterCamelCase("");
		palavra.converterCamelCase(null);
		palavra.converterCamelCase(" ");
		
	}
	
	@Test(expected = iniciaComNumeroException.class)
	public void iniciaComNumero() {
		palavra.converterCamelCase("10Primeiros");
	}
	
	@Test(expected = contemCaractersEspeciais.class)
	public void contemCaractersEspeciais() {
		palavra.converterCamelCase("nome#Composto");
	}
	
	@Test
	public void converterPalavraMinuscula() {
		palavraAnalisadaCamelCase = palavra.converterCamelCase("Nome");
		assertEquals("nome", palavraAnalisadaCamelCase.get(0));
	}
	
	@Test
	public void separarCamelCase() {
		palavraAnalisadaCamelCase = palavra.converterCamelCase("nomeComposto");
		assertEquals(palavraAnalisadaCamelCase.get(0), "nome");
		assertEquals(palavraAnalisadaCamelCase.get(1), "composto");
		
		palavraAnalisadaCamelCase = palavra.converterCamelCase("numeroCPF");
		assertEquals(palavraAnalisadaCamelCase.get(0), "numero");
		assertEquals(palavraAnalisadaCamelCase.get(1), "CPF");
		
		palavraAnalisadaCamelCase = palavra.converterCamelCase("numeroCPFContribuinte");
		assertEquals(palavraAnalisadaCamelCase.get(0), "numero");
		assertEquals(palavraAnalisadaCamelCase.get(1), "CPF");
		assertEquals(palavraAnalisadaCamelCase.get(2), "contribuinte");
		
		palavraAnalisadaCamelCase = palavra.converterCamelCase("recupera10Primeiros");
		assertEquals(palavraAnalisadaCamelCase.get(0), "recupera");
		assertEquals(palavraAnalisadaCamelCase.get(1), "10");
		assertEquals(palavraAnalisadaCamelCase.get(2), "primeiros");
		
	}
	
	@Test
	public void CPF() {
		palavraAnalisadaCamelCase = palavra.converterCamelCase("CPF");
		assertEquals(palavraAnalisadaCamelCase.get(0), "CPF");
	}
	
	
	
	
	

}
