package problemset08;

import javax.swing.JOptionPane;

public class ProblemSet08 {
    public static void main(String[] args) {
        Team team1 = new Team("Time 1");
        Team team2 = new Team("Time 2");
        Team team3 = new Team("Time 3");
        Team team4 = new Team("Time 4");
        Team[] allTeams = {team1, team2, team3, team4}; //cria 4 times
        
        Scheduler scheduler = new Scheduler(allTeams); // cria a instancia da escalacao de cada jogo
        
        boolean continueLoop = true;
        while(continueLoop){
            try{
                int temp = Integer.parseInt((String)JOptionPane.showInputDialog("Qual é a temperatura de hoje?")); //o usuario coloca a temperatura 
                scheduler.scheduleGames(temp);
                continueLoop = scheduler.checkLastThreeTemperatures();// checa se a temperatura foi fria 3 vezes seguidas
            }
            catch(NumberFormatException e) //mostra que a entrada de temperatura foi invalidada
            {
                System.out.println("Valor de temperatura inválida.");
            }
        }
        
        // mostra todas as estatisticas
        System.out.println("Fim da temporada \n");
        System.out.println("*********RESULTADOS*********");
        scheduler.printAllStatistics();
        Game.printAllStatistics();
        Game.printHottestTemperature();
        Game.printAverageTemperature();
        //fim das estatisticas
    }    
}
