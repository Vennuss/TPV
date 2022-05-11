/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package PedidosTests;

import Pedidos.Pedido;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author admin
 */

@RunWith(Parameterized.class)
public class PedidoTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    private String fecha;
    private String formaPago;
    private boolean estadoPago;
    private String cliente;
    
    @Parameterized.Parameters
    public static Iterable parametros(){
        return Arrays.asList(new Object[][]{
            {"2020-05-11 20:10:59","Visa",false,"122345678X"}
        });
    }
    public PedidoTest(String _fecha, String _formaPago, boolean _estadoPago, String _cliente){
        this.fecha = _fecha;
        this.formaPago = _formaPago;
        this.estadoPago = _estadoPago;
        this.cliente = _cliente;
    }
    
    
    @Test
    public void testCrearPedido01(){
        Pedido p1 = new Pedido(fecha,formaPago,estadoPago,cliente);
        assertNotNull(p1);
    }
    
    @Test
    public void testCrearPedido02(){
        Pedido p1 = new Pedido(formaPago,estadoPago,cliente);
        assertNotNull(p1);
    }
    
    @Test //Esto tiene que dar error. Si da error saldra como bien
    public void testCrearPedido03(){
        try{
            Pedido p1 = new Pedido();
            assertNotNull(null);
        }
        catch(Exception e){
            assertNull(null);
        }
    }
    
    @Test
    public void testRegistrar01(){
        Pedido p1 = new Pedido(fecha, formaPago,estadoPago,cliente);
        boolean expectedResult = true;
        assertEquals(p1.registrar(), expectedResult);
    }
}
