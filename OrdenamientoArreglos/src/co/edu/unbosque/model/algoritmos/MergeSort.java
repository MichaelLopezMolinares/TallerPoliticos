package co.edu.unbosque.model.algoritmos;

import co.edu.unbosque.model.Politico;

public abstract class MergeSort {
	
    
	public static int[] mergeSort(Politico[] a, int l, int h) {
	    int[] stats = new int[3]; // [0] comparaciones, [1] intercambios, [2] duración
	    long start = System.nanoTime();
	    sort(a, l, h, stats);
	    long end = System.nanoTime();

	    stats[2] = (int)(end - start);

	    return stats;
	}

	private static void merge(Politico arr[], int l, int m, int r, int[] stats) {
	    int n1 = m - l + 1;
	    int n2 = r - m;

	    Politico L[] = new Politico[n1];
	    Politico R[] = new Politico[n2];

	    for (int i = 0; i < n1; ++i)
	        L[i] = arr[l + i];
	    for (int j = 0; j < n2; ++j)
	        R[j] = arr[m + 1 + j];

	    int i = 0, j = 0;
	    int k = l;

	    while (i < n1 && j < n2) {
	        stats[0]++; // Comparación
	        if (L[i].getDineroRobado() <= R[j].getDineroRobado()) {
	            arr[k] = L[i];
	            i++;
	        } else {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	        stats[1]++; // Intercambio (asignación en array original)
	    }

	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	        stats[1]++; // Intercambio
	    }

	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	        stats[1]++; // Intercambio
	    }
	}

	private static void sort(Politico arr[], int l, int r, int[] stats) {
	    if (l < r) {
	        int m = l + (r - l) / 2;

	        sort(arr, l, m, stats);
	        sort(arr, m + 1, r, stats);

	        merge(arr, l, m, r, stats);
	    }
	}

}
