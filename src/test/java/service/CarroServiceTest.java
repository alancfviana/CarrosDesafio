package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTest {

    @Test
    public void carroDeveSerCriadoDesligado(){
        //Dado
        CarroService carroService = new CarroServiceImpl();

        //Quando
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Então
        Assert.assertFalse(carro.isLigado());
    }
    @Test
    public void deveAcelerarCorretamente(){
    //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

    //Quando
        carroService.ligar(carro);
        carroService.acelerar(carro,10);

    //Então
        Assert.assertEquals(10,carro.getVelocidadeAtual());
    }

    @Test
    public void deveFrearCorretamente(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        carroService.ligar(carro);
        carroService.acelerar(carro,20);
        carroService.frear(carro,10);

        //Então
        Assert.assertEquals(10,carro.getVelocidadeAtual());
    }
    @Test
    public void DeveFrearSomenteComCarroLigado(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando

        carroService.frear(carro,10);

        //Então
        Assert.assertEquals(0,carro.getVelocidadeAtual());
    }
    @Test
    public void deveAcelerarSomenteComCarroLigado(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando

        carroService.acelerar(carro,10);

        //Então
        Assert.assertEquals(0,carro.getVelocidadeAtual());
    }

    @Test
    public void deveDesligarSomenteComCarroParado(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        carroService.ligar(carro);
        carroService.acelerar(carro,10);
        carroService.desligar(carro);
        //Então
        Assert.assertTrue(carro.isLigado());
    }
    @Test
    public void naoDeveTerVelocidadeNegativa(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        carroService.ligar(carro);
        carroService.frear(carro,10);

        //Então
        Assert.assertEquals(0,carro.getVelocidadeAtual());
    }
    @Test
    public void carroDesligadoDeveMostrarEstadoAtual(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        System.out.println("\ncarroDesligadoDeveMostrarEstadoAtual");
        System.out.println(carro.toString());

        //Então
        Assert.assertFalse(carro.isLigado());
    }

    @Test
    public void carroLigadoDeveMostrarEstadoAtual(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        carroService.ligar(carro);
        System.out.println("\ncarroLigadoDeveMostrarEstadoAtual");
        System.out.println(carro.toString());

        //Então
        Assert.assertTrue(carro.isLigado());
    }
    @Test
    public void naoDeveAcelerarAlemDaVelocidadeMaxima(){
        //Dado
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("verde","Fiat","Uno",2012,150);

        //Quando
        carroService.ligar(carro);
        carroService.acelerar(carro,20);
        carroService.acelerar(carro, carro.getVelocidadeMaxima());

        //Então
        Assert.assertEquals(carro.getVelocidadeMaxima(),carro.getVelocidadeAtual());
    }

}
