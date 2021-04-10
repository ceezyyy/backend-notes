import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * <p>
 * Memory Layout of Objects in Java
 * https://www.baeldung.com/java-memory-layout
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/4
 */
public class App {

    @Test
    public void vmInfo() {
        /*
          Running 64-bit HotSpot VM
          reference: 4 bytes
          boolean: 1 byte
          byte: 1 byte
          short: 2 bytes
          char: 2 bytes
          int: 4 bytes
          float: 4 bytes
          long: 8 bytes
          double: 8 bytes
         */
        System.out.println(VM.current().details());
    }

    @Test
    public void classLayout() {
        /*
          1. object head: 12 bytes, including mark (8 bytes) and klass (4 bytes)
          2. state field: 4 bytes
         */
        System.out.println(ClassLayout.parseClass(SimpleInt.class).toPrintable());
    }

    @Test
    public void identifyHashCode() {
        SimpleInt instance = new SimpleInt();
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }

}
