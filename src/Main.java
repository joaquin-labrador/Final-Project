import Employee.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


    }


    /*
    public static void escribirArchivoReservas(File fileReservas, ArrayList<Reserva> listaReserva) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileReservas));
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();


            Type listOfReservaObject = new TypeToken<ArrayList<Reserva>>() {
            }.getType();
            gson.toJson(listaReserva, listOfReservaObject, bufferedWriter);

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("ERROR al Escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    ///
     */
    /// -------------------------------------------------- DESERIALIZACION RESERVAS --------------------------------------------------
    /*
    public static ArrayList<Reserva> leerArchivoReservas (File fileReservas) {
        ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReservas));

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
                }
            }).create();

            Type listOfReservaObject = new TypeToken<ArrayList<Reserva>>() {
            }.getType();

            listaReserva=(gson.fromJson(bufferedReader, listOfReservaObject))

    */
}