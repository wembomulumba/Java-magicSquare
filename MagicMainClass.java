package Trees;
/*
  Author : Wembo otepa Mulumba
  
  Main Class calling the class MagicMainClass

 */
public class MagicMainClass {
    public static void main(String[] args){
        MagicSquare data = new MagicSquare(3);
        data.solve(0);
        data.outputSlt();
    }
}
