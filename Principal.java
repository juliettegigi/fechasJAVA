package principal;

import java.time.LocalDate;
import java.time.Month;// esto es una enumeración
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;// también, una enumeración

public class Principal {

	public static void main(String[] args) {
	
		
		
	
	
		
		//////////////////////////////////////////////////////////////////////////////////// MESES
		Month mes=Month.MAY;
		System.out.println("Le sumo dos meses "+ mes.plus(2));// me imprime JULY 
		System.out.println("Le resto dos meses "+mes.minus(2));// MARCH
		mes=Month.DECEMBER;
		System.out.println("Le sumo 1 "+mes.plus(1));
		System.out.println("Este mes tiene "+mes.maxLength());
        
		////////////////////////////////////////////////////////////////////////////////////  DIAS
		DayOfWeek lunes=DayOfWeek.MONDAY;
		System.out.println("En 8 días será "+lunes.plus(8));
		System.out.println("2 días antes fue: "+lunes.minus(2));

		
		//////////////////////////////////////////////////////////////////////////////////
		
		LocalDate date=LocalDate.of(2018,Month.MARCH,10);
		LocalDate date2=LocalDate.of(2022, 5, 2);
	    DayOfWeek dia=date.getDayOfWeek(); // así obtengo el dia de hoy
	    System.out.println("LocalDate.of(2018,Month.MARCH,10)");
	    System.out.println(date);
	    System.out.println("LocalDate.of(2022, 5, 2);");
	    System.out.println(date2);
	    System.out.println("dia=date.getDayOfWeek();"); 
	    System.out.println(dia);
	    
	  
	    
	    ////////////////////////////////////////////////////////////////////////// LOCALDATE
	    LocalDate dia2=LocalDate.of(2022, 4, 10);   // RECIBE COMO PARÁMETROS NÚMEROS (AÑO, MES , DIA)
	    LocalDate dia3=LocalDate.of(2020,5,1);
	    System.out.println("dia 2 :"+dia2);
	    System.out.println("fecha de hoy: "+LocalDate.now());  //  LA FECHA DE HOY
	    
	   
	    
	    
	    // para saber cual fecha es mayor uso compareTo
	    System.out.println("\n\n--------------------------------------------------");
	    System.out.println("COMPARO 2 FECHAS\n----------------------------------------");
	    if(dia2.compareTo(dia3)>0) 
	    	System.out.println("dia 2("+dia2+") es mayor que dia 3("+dia3+")" );
	    else System.out.println("dia 3("+dia3+") es mayor que dia 2("+dia2+")" );
	    
	   
	    
	    // CALCULAR PERIODO ENTRE DOS FECHAS
	    System.out.println("--------------------------------------------------");
	    System.out.println("PERIODO ENTRE LAS DOS  FECHAS ANTERIORES\n---------------------------------------");
	    
	    Period periodo=Period.between(dia3, dia2); //1ro va la fecha menor
	    System.out.println(periodo);
        System.out.println("dias: "+periodo.getDays());
        System.out.println("meses"+periodo.getMonths());
        System.out.println("anios"+periodo.getYears());
        
        
        
        
        // AFTER  o isAfter(para LocalDate)
        Date f=new Date();
        Date ff=new Date(1991-1900,5-1,2);
        System.out.println("--------------------------------------------------");
        System.out.println("                 AFTER");
        System.out.println("--------------------------------------------------");
        System.out.println("le hago after al dia de hoy con dia(2/5/1991 ) "+ f.after(ff));
        //da true porq f es después que ff
        
        
        
        
	    // CHRONOUNIT
        System.out.println("\n\n----------------------------------");
        System.out.println("CHRONOUNIT");
        System.out.println("----------------------------------");
        LocalDate desde=LocalDate.of(1976, Month.APRIL, 20);
        LocalDate hasta=LocalDate.of(2020, Month.JUNE, 25);
        System.out.println("desde: " + desde);
        System.out.println("hasta: "+hasta);
        long dias=ChronoUnit.DAYS.between(desde, hasta);  //me pasa los años, meses a días y lo suma con los días
	    long meses=ChronoUnit.MONTHS.between(desde, hasta);  // me pasa todo a meses
	    long anios=ChronoUnit.YEARS.between(desde, hasta); // me pasa todo a año
	    System.out.println("dias: "+dias);
	    System.out.println("meses: "+meses);
	    System.out.println("anios: "+anios);
        
        //////////////////////////////////////////////////
	    //           QUE PASA SI TENGO UN String fecha  Y QUIERO ASIGNARLO A UN LocalDate fecha2???
	    // VOY A TENER QUE VER CUAL ES SU PATRÓN  Y USAR EL MÉTODO LocalDate fecha2=LocalDate.parse(fecha,suFormato);
	    
	    //  Y SI QUIERO ASIGNAR AL String fecha el LocalDate fecha2 ==>  String fecha=fecha2.format(formato);
	    
	    //   LocalDate fecha2=LocalDate.parse(fecha,suFormato);
	    //   String fecha=fecha2.format(formato);
	    //////////////////////////////////////////////////
	    System.out.println("\n\nFORMATOO");
	    
	    String [] formatos= {"dd-MM-yyyy","d MMM uuuu" , "dd/MMMM/yyyy", "E,dd/MMM/yyyy","dd/MMMM/yyyy"};
	   
	    for(int i=0;i<formatos.length;i++) {
	    DateTimeFormatter patron2=DateTimeFormatter.ofPattern(formatos[i]);// DEFINO UN PATRON
	    String dia33=LocalDate.of(2022, 4, 10).format(patron2); // a una fecha la formateo con un patrón==> ahora es de tipo String
	    System.out.println("Fecha con patrón "+formatos[i]+"========>"+dia33);
	    LocalDate nuevo=LocalDate.parse(dia33, patron2);// ME PASA LA FECHA CON ESE PATRÓN, AL PATRÓN NORMAL  , ie, pasaría un String a fecha 
	    System.out.println("formato[ "+i+"]= "+nuevo);
	    		
	    }
	    		
	    		
	    /////////////////////////////////////////////////////////////////////////////////////////  DATE
	    System.out.println("\n\nDATE\n----------------------------------------------------------");
	    Date fechaDeHoy=new Date();
	    System.out.println("FECHA DE HOY: "+fechaDeHoy);
	    
	    //  si quiero crear una fecha que sea 02/05/2020 ==> 1ro va el año. luego mes y dia
	    int anio=2020,mess=5,diaa=02;
	    
	    Date miFecha=new Date(anio-1900,mess-1,diaa);
	    
	    System.out.println(miFecha.getDate());// me da 2
	    System.out.println(miFecha.getMonth());// me da 4 
	    System.out.println(miFecha.getYear());// me da 120  (120+1900=2020)
	    
	    System.out.println(miFecha);
	    
	    ///////////////////////////////////////////////////////////////////////////  pasar fecha a String
	    
	    
	    
	    		
	}
	
	static public String fechaString(Date d, String formato) {
		SimpleDateFormat sdf=new SimpleDateFormat(formato);
		return sdf.format(d);				
	}
	
	static public Date stringFecha(String s, String formato) {
		SimpleDateFormat sdf=new SimpleDateFormat(formato);
	    try {
			return sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}				
	}
	

}
