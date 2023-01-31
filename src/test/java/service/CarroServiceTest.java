package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTest {

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
}
