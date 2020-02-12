
public class Main {

    public static void main(String[] args) throws Exception
    {
        Database database = Database.getInstance(); //creez baza de date
        //citirea si crearea bazei de date este gestionata de baza de date
        if ("inscriere".equals(args[0]))
        {
            database.setFolderCitire(args[1]);
            database.setFolderScriere(args[3]);
            database.populareEchipe();
            database.print();
            database.closeScriitor();
        }
        
        if ("competitie".equals(args[0]))
        {
            database.setFolderCitire(args[1]);
            database.populareEchipe();
            
            //creare competitie
            database.setFolderCitire(args[2]);
            String[] buffer = database.cititor.linieNoua().split(",");
            Competitie competitie = new Competitie(buffer[0].trim(), buffer[1].trim());
            
            //adaugare in liste echipele ce participa
            database.setFolderScriere(args[3]);
            competitie.adaugareEchipeInLista();
            competitie.calculPunctajEchipe();
            competitie.adaugareEchipeInClasament();
            competitie.desfasurare();
            competitie.printCastigatori();
            database.closeScriitor();
        }
        
    }
}
