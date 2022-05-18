/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Woland
 */
public class Utilidad {

    public List<Integer> FIN_DE_SEMANA;

    public Utilidad() {
        List<Integer> finDeSemana = new ArrayList<>();
        finDeSemana.add(DateTimeConstants.SATURDAY);
        finDeSemana.add(DateTimeConstants.SUNDAY);
        FIN_DE_SEMANA = Collections.unmodifiableList(finDeSemana);
    }

    public int dias(String numero, String genero) {

        if (numero.equals("1") && genero.equals("dramatico")) {
            return 5;
        } else if (numero.equals("3") && genero.equals("epica")) {
            return 5;
        } else {

        }
        return 0;
    }

    public boolean validarCarnet(String carnet) {
        return carnet.matches("[A][1-9][5][1-9][1-9](1|3|9)");
    }

    public boolean validarGeneroPoesia(String genero) {

        if (genero.equals("lirica") || genero.equals("epica") || genero.equals("dramatica")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarGenero(String genero) {
        if (genero.equals("femenino") || genero.equals("masculino")) {
            return true;
        } else {
            return false;
        }

    }

    public DateTime carnet1GeneroDramatico(DateTime fechaInscripcion) {
        int add5Days = 5;
        while (add5Days != 0) {
            if (fechaInscripcion.getDayOfWeek() == DateTimeConstants.FRIDAY) {
                fechaInscripcion = fechaInscripcion.plusDays(3);

            } else {
                fechaInscripcion = fechaInscripcion.plusDays(1);
            }

            add5Days--;
        }

        return fechaInscripcion;

    }

    public DateTime carnet3GeneroPoesia(DateTime fechaInscripcion) {
        DateTime ultimoDiaDelMes = fechaInscripcion.dayOfMonth().withMaximumValue();
        while (FIN_DE_SEMANA.contains(ultimoDiaDelMes.getDayOfWeek())) {

            ultimoDiaDelMes = ultimoDiaDelMes.minusDays(1);
        }
        return ultimoDiaDelMes;
    }

    public DateTime otrosCarnetYGeneros(DateTime fechaInscripcion) {

        if (fechaInscripcion.getDayOfWeek() <= DateTimeConstants.FRIDAY) {
            return fechaInscripcion.withDayOfWeek(DateTimeConstants.FRIDAY);
        } else {
            return fechaInscripcion.plusWeeks(1).withDayOfWeek(DateTimeConstants.FRIDAY);
        }
    }
    
    public String fechafinal(String carnet,String genero){
         String[] splits =carnet.split("");
         String dato = splits[splits.length-1];
         DateTimeFormatter fmt = DateTimeFormat.forPattern("d/M/Y");
         if(dato.equals("1")&&genero.equals("dramatica")){
         DateTime d =this.carnet1GeneroDramatico(new DateTime());
         return fmt.print(d);
         }else if(dato.equals("3")&&genero.equals("epica")){
         DateTime d =this.carnet3GeneroPoesia(new DateTime());
         return fmt.print(d);
         }else{
         DateTime d =this.otrosCarnetYGeneros(new DateTime());
         return fmt.print(d);
         }
         
    }
}

