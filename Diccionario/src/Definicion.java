/**
 * La clase `Definicion` implementa la interfaz `Comparable<Definicion>` y anula el método `compareTo`
 * para comparar dos objetos de tipo `Definicion` comparando sus campos `terminal`
 */
public class Definicion implements Comparable<Definicion>{
    private String termino;
    private String definicion;
    public Definicion(String termino, String definicion){
        this.termino= termino;
        this.definicion= definicion;
    }

    public Definicion (String termino){
        this.termino= termino;
    }

    public String getTermino() {
        return termino;
    }
    public String getDefinicion() {
        return definicion;
    }
    @Override
    public String toString() {
        return "Definicion\n" +
                 termino +
                "= " + definicion;

    }
    @Override
    // Comparando los dos objetos.
    public int compareTo(Definicion d) {
        return this.getTermino().compareTo(d.getTermino());

    }
    @Override
    // Comparar el término de la definición con el término del objeto pasado como parámetro.
    public boolean equals(Object o) {
        return termino.equals(((Definicion)o).getTermino());
    }
}