package application;
import java.util.Scanner;

import java.util.*;

public class ReadingChord {
    
    // Map of chords to their finger positions on the guitar
    private static final Map<String, Integer[][]> CHORDS = new HashMap<>();
    
    // Initialize the CHORDS map
    static {
        // Add your own chords and finger positions here
        CHORDS.put("G", new Integer[][]{{3, 2, 0, 0, 0, 3}});
        CHORDS.put("C", new Integer[][]{{0, 1, 0, 2, 3, 0}});
        CHORDS.put("D", new Integer[][]{{0, 0, 0, 2, 3, 2}});
        CHORDS.put("Am", new Integer[][]{{0, 0, 2, 2, 1, 0}});
      
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the chords (separated by spaces): ");
        String[] chords = scanner.nextLine().split(" ");
        
        // Generate tabs for each chord
        for (String chord : chords) {
            Integer[][] positions = CHORDS.get(chord);
            if (positions == null) {
                System.out.println("Unknown chord: " + chord);
            } else {
                System.out.println(chord + ":");
                for (int i = 5; i >= 0; i--) {
                    Integer position = positions[0][i];
                    if (position == null) {
                        System.out.println("X");
                    } else {
                        System.out.println(position);
                    }
                }
                System.out.println();
            }
        }
    }
}

