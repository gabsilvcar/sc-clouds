package com.scclouds.hiring.fibonacci;

import com.scclouds.hiring.utils.ImplementationType;

public class FibonacciSequence {

  final ImplementationType method;

  /**
   * Constructs a FibonacciSequence object with the specified method.
   *
   * @param method the method to compute Fibonacci numbers (RECURSIVE or ITERATIVE)
   */
  public FibonacciSequence(ImplementationType method) {
    this.method = method;
  }

  /**
   * Gets the nth Fibonacci number using the specified method.
   *
   * @param n the position in the Fibonacci sequence
   * @return the nth Fibonacci number
   * @throws IllegalArgumentException if an unsupported method is specified
   */
  public int get(int n) {
    switch (method) {
      case RECURSIVE:
        return recursive(n);
      case ITERATIVE:
        return iterative(n);
      default:
        throw new IllegalArgumentException("Unsupported method: " + method);
    }
  }

  static int iterative(int n) {
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  static int recursive(int n) {
    return (n < 2) ? n : recursive(n - 1) + recursive(n - 2);
  }
}
