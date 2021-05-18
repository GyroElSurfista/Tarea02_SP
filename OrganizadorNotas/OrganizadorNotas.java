public class OrganizadorNotas
{
    private double[] notas;
    private int   cantEst;
    private int   cantAprob;
    private int   cantRep;
    public OrganizadorNotas(int cantEst){
        this.cantEst = cantEst;
        notas = new double[cantEst];
        cantAprob = 0;
        cantRep = 0;
    }
    /** 
     * Para añadir una nota ingrese en numero del estudiante (comenzando desde 1) y la nota correspondiente
    **/ 
    public String añadirNotas(int numEst , double nota){
        String reporte = "";
        if((numEst-1) >= 0 && (numEst-1) < notas.length){
            notas[numEst - 1] = nota;
            reporte ="Numero estudiante: "+ numEst + " Nota agregada: " + nota + " Nota añadida exitosamente.";
        }else{
            reporte = "El numero de estuadiante: " + numEst + " no se encuentra en el registro.";
        }
        return reporte;
    }
    public double promedioNotas(){
        double promedio = 0.0;
        for(double n : notas){
            promedio = promedio + n;
        }
        promedio = promedio / cantEst;
        return promedio;
    }
    public double promedioAprobados(){
        double promedio = 0.0;
        for(double n : notas){
            if(n > 51){
                promedio = promedio + n;
            }
        }
        contarAprobados();
        promedio = promedio / cantAprob;
        return promedio;
    }
    public int cantAprobados(){
        contarAprobados();
        return cantAprob;
    }
    public int cantReprobados(){
        contarAprobados();
        cantRep = cantEst - cantAprob;
        return cantRep;
    }
    public double mejorNota(){
        double notaMayor = -1.0;
        for(int i = 0 ; i < notas.length ; i++){
            if(notas[i] > notaMayor){
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }
    private void contarAprobados(){
        int aprobados = 0;
        for(double n : notas){
            if(n > 51){
                aprobados++;
            }
        }
        cantAprob = aprobados;
    }
}
