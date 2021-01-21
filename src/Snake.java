/** 
 * 자바프로그래밍 01분반 
 * 20160658 강상우
 *  **/


import java.util.Scanner;

class Pos {
	int x, y;
}

class Body {
	Pos[] body;
	void init()
	{
		body = new Pos[3];
	}
}

public class Snake {
    public static int[][] bd = new int[10][10];
    public static int[][] bd_old = new int[10][10];
	public static Body[] Snake = new Body[1];
    public static int[] x={4,5,6}; 
    public static int[] y={5,5,5};
    public static int[] x_old={0,0};
    public static int[] y_old={0,0};
    public static int dir=0;
	
    public static void print_bd(int[][] bd)
    {
        for(int i=0; i<bd.length; i++) {
            for(int j=0; j<bd[i].length; j++) {
                if( bd[i][j] == 0 )
                    System.out.print('□');
                else if ( bd[i][j] == 2 )
                	System.out.print('H');
                else
                    System.out.print('S');
            }
            System.out.println();
        }
    }
    
    
    public static void put_snake() {
    	// put snake on the board
    	bd[y[0]][x[0]] = 2;
        for(int i=1; i<3; i++) {
            bd[y[i]][x[i]]=1;
        }
    }
    
    public static void restore_snake() {
    	for(int i=0; i<2; i++) {
    		x_old[i]=x[i]; // x
    		y_old[i]=y[i];
    	}
    }
    
    public static void restore_board() {
    	// board restore
        for(int i=0;i<bd.length;i++) {
            for(int j=0;j<bd[i].length;j++)
                bd[i][j] = bd_old[i][j];
        }
    }
    
    public static void leftShift() {
        // make snake left shift
    	if(dir != 1 && x[0] != 0) {
    		x[0]--;
    		follow();
    		dir = 0;
    	}
    }
    
    public static void rightShift() {
        // make snake right shift
    	if(dir != 0 && x[0] != 9) {
    		x[0]++;
    		follow();
    		dir = 1;
    	}
    }
    
    public static void upShift() {
        // make snake up shift
    	if(dir != 3 && y[0] != 0) {
    		y[0]--;
    		follow();
    		dir = 2;
    	}
    }
    
    public static void downShift() {
        // make snake up shift
    	if(dir != 2 && y[0] != 9) {
    		y[0]++;
    		follow();
    		dir = 3;
    	}
    }
    
    public static void follow() {
    	for(int i=1; i<3; i++) {
    		x[i] = x_old[i-1];
    		y[i] = y_old[i-1];
    	}
    }
    
    public static void main(String[] args) {
   // write your code here
    	while(true) {
    		Snake s = new Snake();
    		System.out.println("\n");
    		s.restore_board();
    		s.put_snake();
    		s.print_bd(bd);
            s.restore_snake();
    		
        	Scanner sc = new Scanner(System.in);
            System.out.print("\n0: LEFT 1: RIGHT 2: UP 3: DOWN / Enter key: ");
            int key = sc.nextInt();
            switch(key) {
            	case 0: { s.leftShift(); break; }
            	case 1: { s.rightShift(); break; }
            	case 2: { upShift(); break; }
            	case 3: { downShift(); break; }    
            }
    	}
    }
}