package com.scclouds.hiring;

import com.scclouds.hiring.fibonacci.FibonacciSequence;
import com.scclouds.hiring.primes.PrimeCollector;
import com.scclouds.hiring.utils.ImplementationType;
import java.util.List;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
    name = "SC Clouds Hiring Challenge",
    mixinStandardHelpOptions = true,
    version = "1.0",
    description = "Computes Fibonacci sequences and prime numbers.")
public class CommandLineApp implements Callable<Integer> {

  @Parameters(index = "0", description = "The command to execute: fibonacci or prime")
  private String command;

  @Parameters(index = "1", description = "The number for the command")
  private int number;

  @Option(
      names = {"-m", "--method"},
      description = "The method to use: recursive or iterative",
      required = true)
  private String method;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new CommandLineApp()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    ImplementationType implementationType;
    switch (method.toLowerCase()) {
      case "recursive":
        implementationType = ImplementationType.RECURSIVE;
        break;
      case "iterative":
        implementationType = ImplementationType.ITERATIVE;
        break;
      default:
        System.out.println("Unsupported method: " + method);
        return 1;
    }

    switch (command.toLowerCase()) {
      case "fibonacci":
        FibonacciSequence fibonacci = new FibonacciSequence(implementationType);
        int fibResult = fibonacci.get(number);
        System.out.println("Fibonacci result: " + fibResult);
        break;
      case "prime":
        PrimeCollector primeCollector = new PrimeCollector(implementationType);
        List<Integer> primes = primeCollector.get(number);
        System.out.println("Prime numbers up to " + number + ": " + primes);
        break;
      default:
        System.out.println("Unsupported command: " + command);
        return 1;
    }
    return 0;
  }
}
