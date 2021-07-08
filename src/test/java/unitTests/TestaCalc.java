package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestaCalc {
    @Test(priority = 2)
    public void testarSomarDoisNumeros() {
        // 1 - Preparar - Configurar - Given - Arrange
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        // 2 - Executar - When - Act
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        // 3 - Validar - Then - Assert
        System.out.println("O resultado esperado é " + resultadoEsperado + "\n O resultado atual é " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test(priority = 1)
    public void testarSubtrairDoisNumeros(){
        int num1 = 6;
        int num2 = 2;
        int resultadoEsperado = 4;

        int resultadoAtual = Calc.subtrairDoisNumeros(num1, num2);
        System.out.println("O resultado esperado é " + resultadoEsperado
                + " e o resultado atual é " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test(priority = 3)
    public void testarMultiplicarDoisNumeros(){
        int num1 = 6;
        int num2 = 2;
        int resultadoEsperado = 12;

        int resultadoAtual = Calc.multiplicarDoisNumeros(num1, num2);
        System.out.println("O resultado esperado é " + resultadoEsperado
                + " e o resultado atual é " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }
    @Test(priority = 4)
    public void testarDividirDoisNumeros(){
        int num1 = 6;
        int num2 = 2;
        int resultadoEsperado = 3;

        int resultadoAtual = Calc.dividirDoisNumeros(num1, num2);
        System.out.println("O resultado esperado é " + resultadoEsperado
                + " e o resultado atual é " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

}
