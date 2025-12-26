package co.edu.unbosque.model.algoritmos;

import co.edu.unbosque.model.Politico;

public class SelectionSort {
	
	public static int[] selectionSort(Politico[] arreglo) {
		int[] stats= new int[3];
		long start= System.nanoTime();
		
		 for (int i = 0; i < arreglo.length - 1; i++) {
	            int minimo = i;
	            for (int j = i + 1; j < arreglo.length; j++) {
	                stats[0]++;
	                if (arreglo[j].getDineroRobado() < arreglo[minimo].getDineroRobado()) {
	                    minimo = j;
	                }
	            }
	            if (minimo != i) {
	                Politico temp = arreglo[i];
	                arreglo[i] = arreglo[minimo];
	                arreglo[minimo] = temp;
	                stats[1]++;
	            }
	        }

	        long end = System.nanoTime();
	        stats[2]= (int)(end-start);
	        return stats;
	}

}
