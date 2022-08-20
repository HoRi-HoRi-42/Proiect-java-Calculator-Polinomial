import junit.framework.TestCase;
import model.Operations;
import model.Polinom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestUnit extends TestCase {
    @Test
    public void TestAdd() {
        Polinom a = new Polinom();
        a.crearePolinom("2x^2+x+3");
        Polinom b = new Polinom();
        b.crearePolinom("3x^2+2x+1");
        Polinom adunare = new Polinom();
        adunare.crearePolinom("5x^2+3x+4");
        Assertions.assertEquals(a.toString(), Operations.aduna(a,b).toString(), "Adunare incorecta!");
    }
    @Test
    public void TestSubb() {
        Polinom a = new Polinom();
        a.crearePolinom("2x^2+x+3");
        Polinom b = new Polinom();
        b.crearePolinom("3x^2+2x+1");
        Polinom adunare = new Polinom();
        adunare.crearePolinom("-1.0x^2-1.0x^1+2.0x^0");
        Assertions.assertEquals(a.toString(), Operations.scade(a,b).toString(), "Adunare incorecta!");
    }
    @Test
public void Testinmulteste() {
        Polinom a = new Polinom();
        a.crearePolinom("2x^2+x+3");
        Polinom b = new Polinom();
        b.crearePolinom("3x^2+2x+1");
        Polinom inmulteste = new Polinom();
        inmulteste.crearePolinom("+6.0x^4+0+7.0x^3+0+0+13.0x^2+0+7.0x^1+3.0x^0");
        Assertions.assertEquals(a.toString(), Operations.inmulteste(a,b).toString(), "Adunare incorecta!");
        }
    @Test
public void Testderivare() {
        Polinom a = new Polinom();
        a.crearePolinom("2x^2+x+3");
        Polinom derivare = new Polinom();
        derivare.crearePolinom("+6.0x^1+2.0x^0+0");
        Assertions.assertEquals(a.toString(), Operations.derivare(a).toString(), "Adunare incorecta!");
        }
    @Test
public void Testintegrare() {
        Polinom a = new Polinom();
        a.crearePolinom("2x^2+x+3");
        Polinom integrare = new Polinom();
        integrare.crearePolinom("+1.0x^3+1.0x^2+1.0x^1");
        Assertions.assertEquals(a.toString(), Operations.integrare(a).toString(), "Adunare incorecta!");
        }

}