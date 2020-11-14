public class Assignment2 
{
    /*
     *  NETTRIX CATALOGUE!
     */   
    private String[] catalogue=
    {
        "MOVIE#2001: A Space Odyssey#1968",
        "GAME#The Witcher 3#2015",
        "TV-SERIES#Stranger Things (Season 1)#2016",
        "GAME#Minecraft#2009",
        "ALBUM#All Eyez On Me#1996",
        "MOVIE#Star Trek II: The Wrath of Khan#1982",
        "ALBUM#Hand on the Torch#1993",
        "TV-Series#Black Mirror (Season 1)#2011",
        "GAME#Zork#1980",
        "ALBUM#Fetch the Bolt Cutters#20190",
        "MOVIEZ#The Irishman#2019",
        "GAME#Papers, Please#2013"
    }; 

    /*
     * DO NOT MODIFY THIS METHOD STRUCTURE!
     * FEEL FREE TO MODIFY VALUES FOR myYear AND myTitleType TO TEST METHOD IMPLEMENTATIONS.
     */
    public void run()
    {
        int myYear=1999;
        int myTitleType=0;

        System.out.println("Printing names of existing titles in the catalog...");
        printTitleNames(myTitleType);
        System.out.println("------------");
        if (isThereMusicAfter(myYear))
        {
            System.out.println("There is some music after "+myYear);
        }
        else
        {
            System.out.println("Seriously, there is NO music after "+myYear);
        }

        System.out.println("------------");
        System.out.println("Printing report on catalog format...");
        System.out.println(getFormatReport());
        System.out.println("------------");
        System.out.println("Printing statistics on media release periods...");
        System.out.println(releasedTitlesHistogram());  
    }

    /**
     * Implement Q1, feel free to modify the body of this method
     */
    private void printTitleNames(int titleType)
    {
        switch(titleType) { // using the switch case

            case 0:
            for (int i=0; i < catalogue.length; i++) {

                int fhash = catalogue[i].indexOf('#'); // searches the first hash
                int lhash = catalogue[i].indexOf('#', fhash+1); // searches the subsequent hashtag
                System.out.println(catalogue[i].substring(fhash+1, lhash)); // +1 is added otherwise hash will be produced alongside


            }
            break;
            case 1:
            for (int i=0; i < catalogue.length; i++) {

                int fhash = catalogue[i].indexOf('#'); // searches the first hash
                int lhash = catalogue[i].indexOf('#', fhash+1); // searches the subsequent hashtag
                if(catalogue[i].substring(0, fhash).toUpperCase().equals("MOVIE")){ 

                    System.out.println(catalogue[i].substring(fhash+1, lhash)); // +1 is added otherwise hash will be produced alongside

                }
                


            }
            break;
            case 2:
            for (int i=0; i < catalogue.length; i++) {

                int fhash = catalogue[i].indexOf('#'); // searches the first hash
                int lhash = catalogue[i].indexOf('#', fhash+1); // searches the subsequent hashtag
                if(catalogue[i].substring(0, fhash).toUpperCase().equals("TV-SERIES")){

                    System.out.println(catalogue[i].substring(fhash+1, lhash)); // +1 is added otherwise hash will be produced alongside

                }
                


            }
            break;
            case 3:
            for (int i=0; i < catalogue.length; i++) {

                int fhash = catalogue[i].indexOf('#'); // searches the first hash
                int lhash = catalogue[i].indexOf('#', fhash+1); // searches the subsequent hashtag
                if(catalogue[i].substring(0, fhash).toUpperCase().equals("GAMES")){

                    System.out.println(catalogue[i].substring(fhash+1, lhash)); // +1 is added otherwise hash will be produced alongside

                }
                


            }
            break;
            case 4:
            for (int i=0; i < catalogue.length; i++) {

                int fhash = catalogue[i].indexOf('#'); // searches the first hash
                int lhash = catalogue[i].indexOf('#', fhash+1); // searches the subsequent hashtag
                if(catalogue[i].substring(0, fhash).toUpperCase().equals("ALBUMS")){

                    System.out.println(catalogue[i].substring(fhash+1, lhash)); // +1 is added otherwise hash will be produced alongside

                }
                


            }
            break;
            default:
            System.out.println("Invalid Media Type");
            break; 


        }
    }
    
    /**
     * Implement Q2, feel free to modify the body of this method
     * @return Whether there is music in the catalog released after the 90s
     */
    private boolean isThereMusicAfter(int year) 
    {
        if(year >=1920 && year <=2019) { // checks whether the year is between the range or not before implementing the function

            for(int i=0; i <= catalogue.length; i++) {
                int fhash = catalogue[i].indexOf('#'); // looks for the first #
                int lhash = catalogue[i].indexOf('#', fhash+1); // looks for the subsequent hash
                int YEAR = Integer.parseInt(catalogue[i].substring(lhash +1)); // this is the year variable which is converted to an integer

                if(catalogue[i].substring(0, fhash).toUpperCase().equals("ALBUM")){

                    if(YEAR > year){ // checks whether the year from the array is greater than the given array or not 

                        return true; 
                        
                    }


                }
                
                

            }


        }
        return false;
    }

    /**
     * Implement Q3, feel free to modify the body of this method
     * @return A report on format validity of the provided catalogue.
     */
    private String getFormatReport()
    {
        String report = "";
        // TODO: Question 3 here
        for (int i=0; i < catalogue.length; i++) {
            int j = i + 1;
            int fhash = catalogue[i].indexOf('#'); // spots the first hashtag
            int lhash = catalogue[i].indexOf('#', fhash+1); // spots the closing hashtag
            int year = Integer.parseInt(catalogue[i].substring(lhash+1)); // the year from the array and converting into a string

            if(!((catalogue[i].substring(0, fhash).toUpperCase().equals("MOVIE"))|| (catalogue[i].substring(0, fhash).toUpperCase().equals("TV-SERIES")) || (catalogue[i].substring(0, fhash).toUpperCase().equals("ALBUM"))|| (catalogue[i].substring(0, fhash).toUpperCase().equals("GAME")))) {
                report += "\nItem #"+j+" - Incorrect media type.";
            } else if (!(year>=1920&&year<=2019)) {
                report += "\nItem #"+j+" - Year incorrect or out of range.";
            } else {
                report += "\nItem #"+j+" - OK.";
            }
        }
        return report;
    }

    /**
     * Implement Q4, feel free to modify the body of this method
     */
    private String releasedTitlesHistogram()
    {
        int[] values = new int[4]; // four values
        String histogram = "";
        
        for(int i=0; i < catalogue.length; i++){
            int fhash = catalogue[i].indexOf('#'); // spots the first hashtag
            int lhash = catalogue[i].indexOf('#', fhash+1); // spots the closing hashtag
            int year = Integer.parseInt(catalogue[i].substring(lhash+1)); // the year from the array and converting into a string

            if(year>=1920 && year<=1944) {
                values[0]++;
            } else if(year>=1945 && year<=1969){
                values[1]++;
            } else if(year>=1970 && year<=1994) {
                values[2]++;
            } else if(year>=1995 && year<=2019) {
                values[3]++; 
            }
            histogram = "Histogram Values:\n" + "1920-1944 - " + values[0] + "\n" + "1945-1969 - "+ values[1] + "\n" + "1970-1994 - " + values[2] + "\n" + "1995-2019 - " + values[3] + "\n";
        }

        // TODO: Question 4 here
        return histogram; // histogram is displayed 
    }  
}