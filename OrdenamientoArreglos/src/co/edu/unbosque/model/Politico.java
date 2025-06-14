package co.edu.unbosque.model;

public class Politico {
    private int id;
    private int dineroRobado;
    private String fechaNacimiento;

    public Politico(int id, int dineroRobado, String fechaNacimiento) {
        this.id = id;
        this.dineroRobado = dineroRobado;
        this.fechaNacimiento = fechaNacimiento;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDineroRobado() {
		return dineroRobado;
	}

	public void setDineroRobado(int dineroRobado) {
		this.dineroRobado = dineroRobado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
    
    
    
    
}
