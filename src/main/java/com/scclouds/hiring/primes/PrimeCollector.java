package com.scclouds.hiring.primes;

import com.scclouds.hiring.utils.ImplementationType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeCollector {
  final ImplementationType method;

  /**
   * Constructs a PrimeCollector object with the specified method.
   *
   * @param method the method to compute prime numbers (RECURSIVE or ITERATIVE)
   */
  public PrimeCollector(ImplementationType method) {
    this.method = method;
  }

  /**
   * Gets the list of prime numbers up to the specified limit using the selected method.
   *
   * @param n the limit up to which prime numbers are to be computed
   * @return a list of prime numbers
   */
  public List<Integer> get(int n) {
    switch (method) {
      case RECURSIVE:
        return recursivePrimeCollector(n);
      case ITERATIVE:
        return sieveOfEratosthenes(n);
      default:
        throw new IllegalArgumentException("Unsupported method: " + method);
    }
  }

  /**
   * Implements the <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">The sieve of
   * Eratosthenes</a> algorithm to find all prime numbers less than n.
   *
   * <p>Time complexity: O(N*log(log(N)))
   *
   * <p>Space Complexity: O(N/2)
   *
   * @param n the limit up to which prime numbers are to be computed
   * @return a list of prime numbers
   */
  static List<Integer> sieveOfEratosthenes(int n) {
    List<Integer> primes = new ArrayList<>();

    // Algorithm has been adapted to skip multiples of two to reduce space complexity.
    boolean[] arr = new boolean[n >> 1];

    if (n < 3) {
      return primes;
    }

    primes.add(2);

    for (int i = 3; i * i < n; i += 2) {
      if (!arr[i >> 1]) {
        for (int j = i * i; j < n; j += i << 1) {
          if (!arr[j >> 1]) {
            arr[j >> 1] = true;
          }
        }
      }
    }

    IntStream.range(1, arr.length)
        .forEach(
            i -> {
              if (!arr[i]) {
                primes.add(i * 2 + 1);
              }
            });

    return primes;
  }

  /**
   * Collects prime numbers up to the specified limit using a recursive prime checking method. Time
   * complexity: O(n*sqrt(n))
   *
   * @param limit the limit up to which prime numbers are to be collected
   * @return a list of prime numbers
   */
  static List<Integer> recursivePrimeCollector(int limit) {
    List<Integer> primes = new ArrayList<>();
    if (limit > 2) primes.add(2);
    for (int i = 3; i < limit; i = i + 2) {
      if (isPrimeRecursive(i, 2)) {
        primes.add(i);
      }
    }
    return primes;
  }

  /**
   * Determines if a number is prime using a recursive approach.
   *
   * <p>Time complexity: O(sqrt(n))
   *
   * @param n the number to check
   * @param divisor the current divisor to check against
   * @return true if the number is prime, false otherwise
   */
  static boolean isPrimeRecursive(int n, int divisor) {
    if (n < 2) {
      return false;
    }
    if (divisor > Math.sqrt(n)) {
      return true;
    }
    if (n % divisor == 0) {
      return false;
    }
    return isPrimeRecursive(n, divisor + 1);
  }
}
