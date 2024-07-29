import static org.junit.jupiter.api.Assertions.assertEquals;

import com.scclouds.hiring.fibonacci.FibonacciSequence;
import com.scclouds.hiring.utils.ImplementationType;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Test class for {@link FibonacciSequence}. */
public class FibonacciSequenceTest {

  static final Map<Integer, Integer> TEST_CASES =
      Map.of(
          0, 0,
          1, 1,
          2, 1,
          3, 2,
          4, 3,
          5, 5,
          6, 8,
          7, 13,
          8, 21,
          9, 34);

  static void testRunner(ImplementationType method) {
    var fibonacci = new FibonacciSequence(method);
    TEST_CASES.forEach(
        (input, expected) -> assertEquals(expected.intValue(), fibonacci.get(input)));
  }

  /** Test method for {@link FibonacciSequence#get(int)} using the ITERATIVE method. */
  @Test
  public void testFibonacciIterative() {
    testRunner(ImplementationType.ITERATIVE);
  }

  /** Test method for {@link FibonacciSequence#get(int)} using the RECURSIVE method. */
  @Test
  public void testFibonacciRecursive() {
    testRunner(ImplementationType.RECURSIVE);
  }
}
