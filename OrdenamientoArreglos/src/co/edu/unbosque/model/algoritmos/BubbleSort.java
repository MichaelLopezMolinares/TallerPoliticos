package co.edu.unbosque.model.algoritmos;

import co.edu.unbosque.model.Politico;

public class BubbleSort {
	
  public static int[] bubbleSort(Politico[] arreglo) {
	  int[] stats= new int[3]; // [0] comparaciones, [1] intercambios, [2] duración
	  long start = System.nanoTime();
	  int n= arreglo.length;
	  
	  
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            stats[0]++;
            if (arreglo[j].getDineroRobado() > arreglo[j + 1].getDineroRobado()) {
                Politico temp = arreglo[j];
                arreglo[j] = arreglo[j + 1];
                arreglo[j + 1] = temp;
                stats[1]++;
            }
        }
    }

    long end = System.nanoTime();

    stats[2] = (int)(end - start);

    return stats;

}
}
