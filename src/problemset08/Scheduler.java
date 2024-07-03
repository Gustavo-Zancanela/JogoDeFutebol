package problemset08;

import java.util.ArrayList;

public class Scheduler {
    private Team[] teamsArray;
    private int[] previous3Temps = {100,100,100};
    private int tempIndex = 0;
    public static final int MINIMUM_TEMP = 32; //Number were tested with Fahrenheit 
    
    public Scheduler(Team[] teamsList){
        this.teamsArray = teamsList;
    }
    
    public void scheduleGames(int temperature)//ordem dos jogos
    {
        if(temperature > MINIMUM_TEMP)//analisa se a temperatura esta boa para haver um jogo
        {
            ArrayList<Integer> teamsRemaining = new ArrayList<>();
            for(int i=0; i<teamsArray.length; i++)// cria uma lista para nao repetir os times ou serem contra si mesmos
            {
                teamsRemaining.add(i);
            }
            while(teamsRemaining.size() > 1)//faz a selecao dos times que irao jogar
            {   
                int randNum = (int)(Math.random()*teamsRemaining.size());// escolhe o time 1
                Team team1 = teamsArray[teamsRemaining.get(randNum)];
                teamsRemaining.remove(randNum);
                
                randNum = (int)(Math.random()*teamsRemaining.size());// escolhe o time 2 
                Team team2 = teamsArray[teamsRemaining.get(randNum)];
                teamsRemaining.remove(randNum);
                
                Game nextGame = new Game(team1, team2, temperature); // cria um jogo
                nextGame.play();
            }
        }
        else{
            System.out.println("Frio demais para jogar.");
        }
        
        // mede se a temperatura foi baixa 3 vezes, se sim acaba a temporada
        previous3Temps[tempIndex] = temperature;
        tempIndex = (tempIndex+1) %3;
    }
    
    public boolean checkLastThreeTemperatures(){
        for(int i: previous3Temps){
            if(i > MINIMUM_TEMP){
                return true;
            }
        }
        return false;
    }
    //fim da medicao de temperatura

    public void printAllStatistics() // mostra os times escolhidos
    {
        for(Team team: teamsArray){
            team.printStatistics();
        }
    }
}
