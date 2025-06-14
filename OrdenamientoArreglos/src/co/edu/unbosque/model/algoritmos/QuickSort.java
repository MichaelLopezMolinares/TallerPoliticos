package co.edu.unbosque.model.algoritmos;

import co.edu.unbosque.model.Politico;

public abstract class QuickSort {
	 
	public static int[] sort(Politico[] a, int l, int h) {
	    int[] stats = new int[3]; // [0] comparaciones, [1] intercambios, [2] duración
	    long start = System.nanoTime();
	    quickSort(a, l, h, stats);
	    long end = System.nanoTime();

	    stats[2] = (int)(end - start);

	    return stats;
	}

	private static void quickSort(Politico[] a, int low, int high, int[] stats) {
	    if (low < high) {
	        int pi = partition(a, low, high, stats);

	        quickSort(a, low, pi - 1, stats);
	        quickSort(a, pi + 1, high, stats);
	    }
	}

	private static int partition(Politico[] a, int low, int high, int[] stats) {
	    Politico pivot = a[high];
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        stats[0]++; 
	        if (a[j].getDineroRobado() <= pivot.getDineroRobado()) {
	            i++;
	            Politico temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	            stats[1]++; 
	        }
	    }

	    Politico temp = a[i + 1];
	    a[i + 1] = a[high];
	    a[high] = temp;
	    stats[1]++;

	    return i + 1;
	}

}