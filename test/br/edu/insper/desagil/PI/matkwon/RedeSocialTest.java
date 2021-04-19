package br.edu.insper.desagil.PI.matkwon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedeSocialTest {
	
	private Usuario user;
	private Produto prod;
	private Video vid1;
	private Video vid2;
	
	@BeforeEach
	public void setUp() {
		user = new Usuario("matkwon");
		prod = new Produto("sofa", 499.99);
		vid1 = user.postaVideo(1, prod);
		vid2 = user.postaVideo(2, prod);
	}
	
	@Test
	public void avaliacoesInvalidas1video() {
		vid1.adicionaAvaliacao(user, 5);
		vid1.adicionaAvaliacao(new Usuario("dragonslayer"), 0);
		vid1.adicionaAvaliacao(new Usuario("mamaekwon"), 10);
		
		assertEquals(0, user.totalAvaliacoes());
	}

	@Test
	public void umaAvaliacao1video() {
		vid1.adicionaAvaliacao(new Usuario("ben10"), 3);
		
		assertEquals(3, user.totalAvaliacoes());
	}

	@Test
	public void duasAvaliacoes1video() {
		vid1.adicionaAvaliacao(new Usuario("ben10"), 4);
		vid1.adicionaAvaliacao(new Usuario("gumball"), 3);
		
		assertEquals(4, user.totalAvaliacoes());
	}

	@Test
	public void tresAvaliacoes1video() {
		vid1.adicionaAvaliacao(new Usuario("ben10"), 3);
		vid1.adicionaAvaliacao(new Usuario("gumball"), 4);
		vid1.adicionaAvaliacao(new Usuario("finn"), 3);
		
		assertEquals(3, user.totalAvaliacoes());
	}

	@Test
	public void tresAvaliacoes2videos() {
		vid1.adicionaAvaliacao(new Usuario("ben10"), 3);
		vid2.adicionaAvaliacao(new Usuario("gumball"), 4);
		vid1.adicionaAvaliacao(new Usuario("finn"), 3);
		
		assertEquals(7, user.totalAvaliacoes());
	}

}
