import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        JFileChooser files = new JFileChooser();
        files.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= files.showOpenDialog(null);

        File file = new File(files.getSelectedFile().getAbsolutePath());

        LinhaMontagem linhaMontagem = new LinhaMontagem();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);
            String linha;
            String atividade;

            Date inicioDia = new Date();
            inicioDia.setHours(9);
            inicioDia.setMinutes(0);
            linhaMontagem.setHorario(inicioDia);

            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(inicioDia);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            linhaMontagem.setHoraDiaAtividade(gc);
            linhaMontagem.setNumLinha(linhaMontagem.getNumLinha()+1);
            System.out.printf("\nLinha de Montagem: %d \n\n", (linhaMontagem.getNumLinha()) );
            while ((linha = input.readLine()) != null) {
                String manutencao = linha.substring(linha.length() - 10);
                int minutosHora = 0;
                if ((manutencao.substring(0,5)).equals("manut")) {
                    minutosHora = 5;
                } else {
                    String tempo = linha.substring(linha.length() - 5);
                    minutosHora = Integer.parseInt( tempo.substring(0,2));
                }
                if(isAlmoco(linhaMontagem)) {
                    Date almoco = new Date();
                    almoco.setHours(13);
                    almoco.setMinutes(linhaMontagem.getHoraDiaAtividade().getTime().getMinutes());
                    linhaMontagem.setHorario(almoco);
                    GregorianCalendar gca = new GregorianCalendar();
                    gca.setTime(almoco);
                    linhaMontagem.setHoraDiaAtividade(gca);
                    System.out.printf("\nHorário de almoço da linha de montagem : %d \n\n", linhaMontagem.getNumLinha());
                }

                if(isGinastica(linhaMontagem, minutosHora)){
                    Date ginastica = new Date();
                    ginastica.setHours(9);
                    ginastica.setMinutes(0);
                    linhaMontagem.setNumLinha(linhaMontagem.getNumLinha() + 1);
                    atividade = (linhaMontagem.getHoraDiaAtividade().getTime()).toLocaleString() + " : " + "Ginastica";
                    System.out.println(atividade);
                    System.out.printf("\n Linha de Montagem %d \n\n" , linhaMontagem.getNumLinha());
                    linhaMontagem.setHorario(ginastica);
                    GregorianCalendar gcgyn = new GregorianCalendar();
                    gcgyn.setTime(ginastica);
                    linhaMontagem.setHoraDiaAtividade(gcgyn);
                }
                atividade = (linhaMontagem.getHoraDiaAtividade().getTime().toLocaleString()) + " : " + linha;
                System.out.println(atividade);
                GregorianCalendar proximoInicio = linhaMontagem.getHoraDiaAtividade();
                proximoInicio.add(Calendar.MINUTE,minutosHora);
                linhaMontagem.setHoraDiaAtividade(proximoInicio);

            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private static boolean isGinastica(LinhaMontagem linhaMontagem, int minutosHora) {
        if (linhaMontagem.getHoraDiaAtividade().getTime().getHours() == 16){
                return true;
        }
        return false;
    }

    private static boolean isAlmoco(LinhaMontagem linhaMontagem) {
        if (linhaMontagem.getHoraDiaAtividade().getTime().getHours() == 12) {
            return true;
        }
        return false;
    }
}

