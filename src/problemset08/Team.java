package problemset08;

public class Team 
{
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int pointsScored;
    private int pointsAllowed;
    
    public Team(String name)
    {
        this.name = name;
    }
    
    public void printStatistics()//mostra as estaticas de cada time
    {
        System.out.println(name);
        System.out.println("Vitórias: " +wins +", Derrotas: " +losses +", Empates:" +ties);
        System.out.println("Pontos marcados: " +pointsScored +", Pontos permitidos: " +pointsAllowed);
        System.out.println("");
    }


    public String getName()
    {
        return name;
    }
    
    public void addWin() 
    {
        wins++;
    }
    public void addLoss() 
    {
        losses++;
    }
    public void addTie() 
    {
        ties++;
    }
    public void addPointsScored(int pointsScored) {
        this.pointsScored = this.pointsScored +pointsScored;
    }
    public void addPointsAllowed(int pointsAllowed) {
        this.pointsAllowed = this.pointsAllowed +pointsAllowed;
    }
}
