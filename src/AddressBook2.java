import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook2 {
    public static void main(String[] args) {
        HashMap<String, String> mapaVer = new HashMap<String, String>();
        Scanner alma = new Scanner(System.in);

        int pro, mon = 0;
        String celular, nombre;
        System.out.println("-- AGENDA DE CONTACTOS 2023 --\n");

        do
        {
            try{
                System.out.println("Seleccione una opción:");
                System.out.println("Cargar Datos          -1-");
                System.out.println("Guardar Datos         -2-");
                System.out.println("Mostrar Contactos     -3-");
                System.out.println("Nuevo Contacto        -4-");
                System.out.println("Borrar Numero         -5-");
                System.out.println("Salir                 -6-");

                pro = alma.nextInt();

                switch(pro)
                {
                    case 1 :
                        load(mapaVer);
                        break;

                    case 2:
                        save(mapaVer);
                        break;

                    case 3:
                        list(mapaVer);
                        break;

                    case 4:
                        System.out.println("Inserte nuevo numero telefonico: ");
                        celular = alma.next();
                        System.out.println("Inserte nombre del contacto");
                        nombre = alma.next();
                        create(mapaVer,celular,nombre);
                        break;

                    case 5:
                        System.out.println("Inserte el numero a eliminar: ");
                        celular = alma.next();

                        delete (mapaVer, celular);
                        break;

                    case 6:
                        System.out.println("Salir \n");
                        mon = 1;
                        break;

                    default:
                        System.out.println("Incorrecto \n");
                        break;

                }
            }
            catch (Exception e)
            {
                System.out.println("!!!ERROR!!! \n");
                break;

            }
        }while (mon == 0);
    }

    // Paso 1: Crear el metodo lista para modificar la informacion del usuario.

    public static void list(HashMap<String, String> mapaVer)
    {
        Iterator<String> lista = mapaVer.keySet().iterator();

        System.out.println("Contactos: \n");
        System.out.println(" Celular\t|\tNombre ");
        System.out.println("********************");
        while(lista.hasNext())
        {
            String puerta = lista.next();

            System.out.println(" "+puerta+"\t|\t"+mapaVer.get(puerta));
        }
    }

    // Paso 2: Crear contacto nuevo

    public static void create(HashMap<String, String> mapaVer, String cel, String usu)
    {

        if(mapaVer.containsKey(cel))
        {
            System.out.println("\nNo registrar dos veces el numero");
        }
        else
        {
            mapaVer.put(cel, usu);
            System.out.println("Se genero un nuevo contacto");
        }

    }

    //Paso 3: Borrar numero

    public static void delete(HashMap<String, String> mapaVer, String cel)
    {
        if(mapaVer.containsKey(cel));
        {
            System.out.println("\nSe elimino un numero: "+mapaVer.get(cel)+"\n");
            mapaVer.remove(cel);

        }


    }

    public static void load (HashMap<String, String> u)
    {
        String inputFilename = "C:\\Users\\eliax\\Documents\\Actividades GitGit\\milk.csv\\directorio telefonico\\dicCsv.csv";
        String b [];

        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(inputFilename));

            String docu;
            while ((docu = bufferedReader.readLine()) !=null){
                b = docu.split (",");
                u.put(b[0], b[1]);
            }
        } catch(IOException e){
            System.out.println("IOException catched while reading: " + e.getMessage());
        }finally{
            try{
                if (bufferedReader != null){
                    bufferedReader.close();
                    System.out.println("\nSe cargo el contacto");
                }
            }catch (IOException e){
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public static void save(HashMap<String, String> u)
    {
        Iterator<String> iterator = u.keySet().iterator();
        String inputFilename = "C:\\Users\\eliax\\Documents\\Actividades GitGit\\milk.csv\\directorio telefonico\\dicCSV.csv";

        BufferedWriter bufferedWriter = null;

        try{
            bufferedWriter = new BufferedWriter(new FileWriter(inputFilename));

            while(iterator.hasNext())
            {
                String puerta = iterator.next();

                bufferedWriter.write(puerta+","+u.get(puerta)+"\n");
            }
        }
        catch(IOException e){
            System.out.println("IOException catched while writing: " + e.getMessage());
        }finally{
            try{
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    System.out.println("\nCambios guardados");
                }
            }catch(IOException e){
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
}

