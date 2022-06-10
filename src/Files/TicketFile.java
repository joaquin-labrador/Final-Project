package Files;

import Restaurant.Table;
import Restaurant.Ticket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

public class TicketFile {
    private List<Ticket> ticketList = new ArrayList<>();

    public TicketFile() {
        loadTicket();
    }

    public void saveTicket(Ticket ticket) {

        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        List<Ticket> ticketListAux;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            bufferedReader = new BufferedReader(new FileReader("JSONTickets\\TicketFile.json"));
            ticketListAux = gson.fromJson(bufferedReader,
                    (new TypeToken<List<Ticket>>() {
                    }.getType()));
            if (ticketListAux == null) {
                ticketListAux = new ArrayList<>();
            }
            ticketListAux.add(ticket);
            bufferedWriter = new BufferedWriter(new FileWriter("JSONTickets\\TicketFile.json"));
            gson.toJson(ticketListAux, bufferedWriter);
            System.out.println("Ticket saved");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert bufferedWriter != null;
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void loadTicket() {
        BufferedReader bufferedReader = null;
        Gson gson = new Gson();
        try {
            bufferedReader = new BufferedReader(new FileReader("JSONTickets\\TicketFile.json"));
            ticketList = gson.fromJson(bufferedReader,
                    (new TypeToken<List<Ticket>>() {
                    }.getType()));
            if (ticketList == null) {
                ticketList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert bufferedReader != null;
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
