package problemset08;

import java.util.ArrayList;

public class Game {
    private static final ArrayList<Game> gameLog = new ArrayList<>();
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private int temperature;    //Number were tested with Fahrenheit 
    private int gameNumber;
    
    public Game(Team homeTeam, Team awayTeam, int temperature)// construtor para formar o jogo
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.temperature = temperature;
        
        gameLog.add(this);
        gameNumber = gameLog.size();
    }
    
    public void play()//o jogo
    {
        homeTeamScore = (int)(Math.random()*(3+temperature/16.0));// calculo para formacao de pontos a partir de um numero aleatorio e da temperatura
        awayTeamScore = (int)(Math.random()*(3+temperature/16.0));
        
        homeTeam.addPointsScored(homeTeamScore); //adiciona aos campos os pontos marcados e permitidos para cada time
        homeTeam.addPointsAllowed(awayTeamScore);
        awayTeam.addPointsScored(awayTeamScore);
        awayTeam.addPointsAllowed(homeTeamScore);
        
        if(homeTeamScore > awayTeamScore)// comparacao de pontos para saber que ganhou ou perdeu
        {
            homeTeam.addWin();
            awayTeam.addLoss();
        }
        else if(homeTeamScore < awayTeamScore){
            homeTeam.addLoss();
            awayTeam.addWin();
        }
        else //comparacao em caso de empate
        {
            homeTeam.addTie();
            awayTeam.addTie();
        }
    }
    
    private void printStatistics()// mostra os resultados do jogo
    {
        System.out.println("Jogo #" +gameNumber);
        System.out.println("Temperatura: " +temperature);
        System.out.println("Time de fora: " +awayTeam.getName() +", " +awayTeamScore);
        System.out.println("Time da casa: " +homeTeam.getName() +", " +homeTeamScore);
        System.out.println("");
    }
    public static void printAllStatistics()//cria um leitor de lista estatica para os resultados de cada jogo
    {
        for(Game game: gameLog){
            game.printStatistics();
        }
    }
    public static void printHottestTemperature() //mostra a maior temperatura dos jogos da temporada
    {
        int hottestTemp = 0;
        for(Game game: gameLog){
            if(game.temperature > hottestTemp){
                hottestTemp = game.temperature;
            }
        }
        System.out.println("Maior temperatura: " +hottestTemp);
    }
    public static void printAverageTemperature()//mostra a media da temperatura da temporada
    {
        double totalDegrees = 0;
        for(Game game: gameLog){
            totalDegrees +=game.temperature;
        }
        if(gameLog.isEmpty()){
            System.out.println("Jogos não jogados nesta temporada");
        }
        else{
            System.out.println("Média de temperatura:" + totalDegrees/gameLog.size());
        }
    }
    
    public static int getGameLogSize()//retorna a quantidade de jogos 
    {
        return gameLog.size();
    }
}
