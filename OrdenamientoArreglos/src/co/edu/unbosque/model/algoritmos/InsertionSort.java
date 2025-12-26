package co.edu.unbosque.model.algoritmos;

import co.edu.unbosque.model.Politico;

public abstract class InsertionSort {
	
	public static int[] insertionSort(Politico[] arr) {
	    int[] stats = new int[3]; // [0] comparaciones, [1] intercambios, [2] duración
	    long start = System.nanoTime();

	    int n = arr.length;
	    for (int i = 1; i < n; ++i) {
	        Politico key = arr[i];
	        int j = i - 1;

	        // Comparación inicial
	        stats[0]++;
	        while (j >= 0 && arr[j].getDineroRobado() > key.getDineroRobado()) {
	            stats[0]++; // Comparación dentro del while
	            arr[j + 1] = arr[j]; // Desplazamiento = intercambio
	            stats[1]++;
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	        stats[1]++; // Inserción final del key también cuenta como intercambio
	    }

	    long end = System.nanoTime();
	    stats[2] = (int)(end - start);

	    return stats;
	}

}
