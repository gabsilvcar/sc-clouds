import static org.junit.jupiter.api.Assertions.assertEquals;

import com.scclouds.hiring.primes.PrimeCollector;
import com.scclouds.hiring.utils.ImplementationType;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Test class for {@link PrimeCollector}. */
public class PrimeSequenceTest {
  static final Map<Integer, List<Integer>> TEST_CASES =
      Map.of(
          0,
          List.of(),
          2,
          List.of(),
          3,
          List.of(2),
          10,
          List.of(2, 3, 5, 7),
          100,
          List.of(
              2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
              83, 89, 97));

  static void testRunner(ImplementationType method) {
    var primeCollector = new PrimeCollector(method);
    TEST_CASES.forEach((input, expected) -> assertEquals(expected, primeCollector.get(input)));
  }

  /** Test method for {@link PrimeCollector#get(int)} using the ITERATIVE method. */
  @Test
  public void testPrimeIterative() {
    testRunner(ImplementationType.ITERATIVE);
  }

  /** Test method for {@link PrimeCollector#get(int)} using the RECURSIVE method. */
  @Test
  public void testPrimeRecursive() {
    testRunner(ImplementationType.RECURSIVE);
  }
}
