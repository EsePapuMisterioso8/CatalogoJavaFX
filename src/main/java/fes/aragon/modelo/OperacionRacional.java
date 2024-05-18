package fes.aragon.modelo;

public class OperacionRacional {
     private Racional racionalUno;
    private Racional racionalDos;

    public OperacionRacional(){
        this.racionalUno = new Racional();
        this.racionalDos = new Racional();
    }
    public OperacionRacional(Racional r1, Racional r2){
        racionalUno = r1;
        racionalDos = r2;
    }
    public Racional suma(){
        int numerador;
        int denominador;
        if(racionalUno.getDenominador() == racionalDos.getDenominador()){
            numerador= racionalUno.getNumerador()+racionalDos.getNumerador();
            denominador = racionalUno.getDenominador();
            return new Racional(numerador,denominador);
        }else {
             numerador = racionalUno.getNumerador() * racionalDos.getDenominador() +
                    racionalUno.getDenominador() * racionalDos.getNumerador();
             denominador = racionalUno.getDenominador() * racionalDos.getDenominador();
        }
        return new Racional(numerador, denominador);
    }
    public Racional suma(Racional r1, Racional r2){
        int numerador;
        int denominador;
        if(r1.getDenominador() == r2.getDenominador() ){
             numerador = r1.getNumerador() + r2.getNumerador();
             denominador = r1.getDenominador();
             return new Racional(numerador,denominador);
        }else{
             numerador = r1.getNumerador()*r2.getDenominador() +
                r1.getDenominador()* r2.getNumerador();
             denominador = r1.getDenominador()*r2.getDenominador();
        }
        return new Racional(numerador,denominador);
    }
    public Racional resta(){
        int numerador = racionalUno.getNumerador()*racionalDos.getDenominador() -
                racionalUno.getDenominador()*racionalUno.getNumerador();
        int denominador = racionalUno.getDenominador()*racionalDos.getDenominador();
        return new Racional(numerador,denominador);
    }
    public Racional resta(Racional r1,Racional r2){
        int numerador = r1.getNumerador()* r2.getDenominador()-
                r1.getDenominador()*r2.getNumerador();
        int denominador = r1.getDenominador()*r2.getDenominador();
        return new Racional(numerador,denominador);
    }
    public Racional multiplicacion(){
        int numerador = racionalUno.getNumerador()*racionalDos.getNumerador();
        int denominador = racionalUno.getDenominador()*racionalDos.getDenominador();
        return new Racional(numerador,denominador);
    }
    public Racional multiplicacion(Racional r1, Racional r2){
        int numerador = r1.getNumerador()*r2.getNumerador();
        int denominador = r1.getDenominador()*r2.getDenominador();
        return new Racional(numerador,denominador);
    }

    public Racional division(){
        int numerador = racionalUno.getNumerador()*racionalDos.getDenominador();
        int denominador = racionalUno.getDenominador()*racionalDos.getNumerador();
        return new Racional(numerador,denominador);
    }
    public Racional division(Racional r1, Racional r2){
        int numerador = r1.getNumerador()*r2.getDenominador();
        int denominador = r1.getDenominador()*r2.getNumerador();
        return new Racional(numerador,denominador);
    }
}
