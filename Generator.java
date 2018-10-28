package game;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Generator {
	public static void main (String[] args) {

		Scanner scan = new Scanner(System.in);
		String s = "";
		Random r = new Random();
		int i = 0, j = 0;
		
		int[][] map = new int[3][3];
		int[][] map2 = new int[3][3];
		
		for (i = 0; i< 3; i++) {
			for (j = 0; j< 3; j++) {
				map[i][j] = r.nextInt(3)+1;
				map2[i][j] = map[i][j];
			}
		}
		
		
		System.out.println(Arrays.deepToString(map));
		

		for (i = 0; i< 3; i++) {
			System.out.println();
			for (j = 0; j< 3; j++) {
				System.out.print(map[i][j] + "\t");
			}
		}
		
		int k = 0, m = 0;
	
		int c = -1;
		int x = 0, y = 0;
		int count = 0, count3 = 0;
		for (i = 0; i< 3; i++) {
			for (j = 0; j< 3; j++) {
				count3 += map[i][j];	
			}
		}
		
		
		//System.out.println(count3);
		
		// This code is good
		i=0; j=0;
		int w = 0, z = 0;
		int count2 = 0;
		while (true) {
			System.out.println("\nPlease Enter the direction you want to move(use lower case WASD for directions: ");
			s = scan.nextLine();
			if(i == 0 && s.equals("w")) {
				System.out.println("you can't move up");
				continue;
			} 
			if(j == 2 && s.equals("d")) {
				System.out.println("you can't move right");
				continue;
			} 
			if(j == 0 && s.equals("a")) {
				System.out.println("you can't move left");
				continue;
			} 
			if(i == 2 && s.equals("s")) {
				System.out.println("you can't move down");
				continue;
			} 
			
			
			if (s.equals("w") && map[i-1][j] !=0) {
				map[i][j]--;
				i--;
				count2++;
			} 
			if (s.equals("s")&& map[i+1][j] !=0) {
				
				map[i][j]--;
				i++;
				count2++;
			} 
			if (s.equals("a")&& map[i][j-1] !=0) {
				
				map[i][j]--;
				j--;
				count2++;
			} 
			if (s.equals("d")&& map[i][j+1] !=0) {
				
				map[i][j]--;
				j++;
				count2++;
			}
			
			
			for (w = 0; w < 3; w++) {
				System.out.println();
				for (z = 0; z< 3; z++) {
					if (w == i && z == j) {
						System.out.print(map[w][z] + "*\t");
					} else {
						System.out.print(map[w][z] + "\t");
					}
					
				}
			}
			//end of p
			c = -1;
			count = 0;
	
			
				int q = -1;
				
				count = 0;
				while (count !=2) {
					try {
						if(c <= (map[i+q][j])) {
							c = map[i+q][j];
						}
						count++;
						q *= -1;
						
					} catch(IndexOutOfBoundsException ex) {
						 q *= -1;
						 count++;
					}
				}
				
				count = 0;
				while (count !=2) {
					try {
						if(c <= (map[i][j+q])) {
							c = map[i][j+q];
						}
						count++;
						q *= -1;
						
					} catch(IndexOutOfBoundsException ex) {
						 q *= -1;
						 count++;
					}
				}
			
			if (c == 0) {
				System.out.println("game over!");
				System.out.println("Your score : " + count2);
				System.out.println("The max score is: " + (count3-1));
				System.exit(0);
			}
			
			System.out.println("Your total amount of  move is: " + count2);
		}
		
		
	
		
		
		
	
	}
}
