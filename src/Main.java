void main(){
    Datos date = new Datos(5, 3.14f, 'A', "Hola");
    date.mostrarDatos();
    System.out.println();

    Cuadrado cuadrado = new Cuadrado(10.5f);
    cuadrado.mostrarArea();
    cuadrado.mostrarPerimetro();
    System.out.println();

    Temperatura temp = new Temperatura(36.1);
    Persona persona = new Persona("Vanya","Castillo","Castillo","Calle 1", temp);
    persona.mostrarDatosPersonales();
    System.out.println();

    Animal perro = new Animal(
                    "Perro",
                    "Canis lupus familiaris",
                    5,
                    0.6,
                    "Doméstico",
                    "Omnívoro",
                    true);
    Planta girasol = new Planta(
            "Girasol",
            "Helianthus annuus",
            1,
            2.0,
            "Pradera",
            true,
            true);

    perro.alimentarse();
    System.out.println();
    girasol.alimentarse();
}
class Datos {
    // Atributos
    int numero;
    float decimal;
    char caracter;
    String cadena;

    //Constructor
    Datos(int numero, float decimal, char caracter, String cadena) {
        this.numero = numero;
        this.decimal = decimal;
        this.caracter = caracter;
        this.cadena = cadena;
    }

    //Métodos
    void mostrarDatos() {
        System.out.println("Número: " + numero);
        System.out.println("Decimal: " + decimal);
        System.out.println("Carácter: " + caracter);
        System.out.println("Cadena: " + cadena);
    }
}

//Creación de la clase cuadrado
class Cuadrado {
    //Atributos
    private float lado;

    //Constructor
    Cuadrado(float lado){
        introducirLado(lado);
    }
    //Metodos
    void introducirLado(float lado){
        if(lado>0){
            this.lado = lado;
        } else{
            System.out.println("El lado no debe de ser negativo.");
        }
    }
    float area(){
        return lado*lado;
    }
    float perimetro(){
        return 4*lado;
    }
    void mostrarArea(){
        System.out.println("El área es: " + area());
    }
    void mostrarPerimetro(){
        System.out.println("El perímetro es: " + perimetro());
    }
}

class Persona{
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String direccion;
    Temperatura temperatura;

    Persona(String nombre,String apellidoPaterno,String apellidoMaterno,String direccion, Temperatura grados){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.temperatura = grados;
    }
    void mostrarDatosPersonales(){
        System.out.println("Mi nombre completo es: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + ".");
        System.out.println("Mi dirección es: " + direccion + ".");
        System.out.println("Mi temperatura es: " + temperatura.grados + "."); //Cuando un atributo see envía de una clase a otro se debe hacer mención
    }
}

class Temperatura{
    //Atributo
    double grados;
    //Constructor
    Temperatura(double grados){
        this.grados = grados;
    }
}

abstract class SerVivo{
    //Atributos
    String nombreComun;
    String nombre_Cientifico;
    int edad;
    double dimension;
    String habitat;

    //Constructor
    public SerVivo(String nombreComun, String nombre_Cientifico, int edad, double dimension, String habitat) {
        this.nombreComun = nombreComun;
        this.nombre_Cientifico = nombre_Cientifico;
        this.edad = edad;
        this.dimension = dimension;
        this.habitat = habitat;
    }

    //Metodos
    // Metodo NORMAL: es igual para todos, se hereda tal cual
    void crecer(){
        edad++;
        System.out.println(nombreComun + " ahora su edad es: " + edad + ".");
    }
    void respirar(){
        System.out.println("Está respirando " + nombreComun + ".");
    }

    // Metodo ABSTRACTO: cada hija DEBE escribirlo
    abstract void alimentarse();
}

class Animal extends SerVivo{
    String tipoDeAlimentacion;
    boolean esVertebrado;
    Animal(String nombre_Comun, String nombre_Cientifico, int edad, double dimension, String habitat, String tipoDeAlimentacion, boolean esVertebrado){
        super(nombre_Comun, nombre_Cientifico, edad, dimension, habitat);
        this.tipoDeAlimentacion = tipoDeAlimentacion;
        this.esVertebrado = esVertebrado;
    }

    @Override
    void alimentarse(){
        System.out.println(nombreComun + " come (" + tipoDeAlimentacion + ").");
    }
}


class Planta extends SerVivo{
    boolean tieneFlores;
    boolean necesitaMuchaLuz;
    Planta(String nombre_Comun, String nombre_Cientifico, int edad, double dimension, String habitat, boolean tieneFlores, boolean necesitaMuchaLuz){
        super(nombre_Comun, nombre_Cientifico, edad, dimension, habitat);
        this.tieneFlores = tieneFlores;
        this.necesitaMuchaLuz = necesitaMuchaLuz;
    }

    @Override
    void alimentarse(){
        System.out.println(nombreComun + " produce su propio alimento por fotosíntesis.");
    }
}