package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.ChainedHashTable;
import edu.grinnell.csc207.util.Reporter;

import java.io.PrintWriter;

/**
 * A series of experiments with chained hash tables.
 *
 * @author Princess Alexander
 * @author Samuel A. Rebelsky
 */
public class ChainedHashTableExperiments {

  // +------+------------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Conduct a series of experiments on chained hash tables.
   *
   * @param args
   *   Command-line arguments (ignored).
   */
  public static void main(String[] args) {
    // Create our normal output mechanism.
    final PrintWriter pen = new PrintWriter(System.out, true);
    // Convert the PrintWriter to a Reporter.
    Reporter rept = new Reporter() {
      public void report(String str) {
        pen.println("*** " + str);
      } // report(String)
    }; // new Reporter()

    // Create a new hash table
    ChainedHashTable<String, String> htab =
        new ChainedHashTable<String, String>(rept);

    // Experiment 0: Setup and observation
    pen.println("=== Experiment 0: Initial Setup ===");
    htab.reportBasicCalls(false);
    htab.dump(pen); // Print the initial, empty state of the hash table
    pen.println();

    // Experiment 1: Matching keys
    pen.println("=== Experiment 1: Matching Keys ===");
    HashTableExperiments.matchingKeysExpt(pen, htab);
    pen.println("Experiment 1 completed.\n");

    // Experiment 2: Duplicate keys
    pen.println("=== Experiment 2: Duplicate Keys ===");
    HashTableExperiments.repeatedSetExpt(pen, htab);
    pen.println("Experiment 2 completed.\n");

    // Experiment 3: Handling collisions (single collision scenario)
    pen.println("=== Experiment 3: Handling Collisions (Single Case) ===");
    HashTableExperiments.matchingSetExpt(pen, htab);
    pen.println("Experiment 3 completed.\n");

    // Experiment 4: Handling collisions (multiple collisions)
    pen.println("=== Experiment 4: Handling Collisions (Multiple Cases) ===");
    HashTableExperiments.multipleSetExpt(pen, htab);
    pen.println("Experiment 4 completed.\n");

    // Experiment 5: Removing elements
    pen.println("=== Experiment 5: Removing Elements ===");
    HashTableExperiments.removeExpt(pen, htab);
    pen.println("Experiment 5 completed.\n");

    // Final report and cleanup
    pen.println("=== All experiments completed. ===");
    htab.reportBasicCalls(false); // Turn off basic call reporting
    htab.dump(pen); // Final state of the hash table
    pen.close(); // Close the writer
  } // main(String[])

} // class ChainedHashTableExperiments
