package Code;


import java.util.Random;


import Code.Areas.Areas;
import Code.Areas.Desert;
import Code.Areas.Mountain;
import Code.Areas.Beach;
import Code.Areas.Woods;
import Code.Creatures.Creatures;
import Code.Creatures.Opponents;
import Code.Creatures.Players;

public class Maps {
    private Random randGen;
    private Areas[][] map ;
    private UserInputs uI;
    
    /*
     * Constructor creating and randomly filling a 5x5 map with Areas Objects
     */
    public Maps () {
        uI = new UserInputs();
        randGen = new Random();
        map = new Areas[5][5];
        fillMap();
    }
    
    public void setAreaByEqNeeded(Players player , String eqNeeded) {
        switch (eqNeeded) {
        case "googles": map[player.getyCoordinate()][(player.getxCoordinate() + 1) % 5] = new Desert(); break;
        case "suspensions": map[player.getyCoordinate()][(player.getxCoordinate() + 1) % 5] = new Mountain(); break;
        case "tyres": map[player.getyCoordinate()][(player.getxCoordinate() + 1) % 5] = new Beach(); break;
        case "brakes": map[player.getyCoordinate()][(player.getxCoordinate() + 1) % 5] = new Woods(); break;
        }
    }
    
    
    /*
     * return a New random area
     */
    public Areas chooseArea(int randInt) {
        Areas area = null;
        switch (randInt) {
        case 0: area = new Desert(); break;
        case 1: area = new Mountain(); break;
        case 2: area = new Beach(); break;
        case 3: area = new Woods(); break;
        }
        return area;
    }
    
    /*
     * Fill the map with random areas
     */
    public void fillMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                int randInt = randGen.nextInt(4);
                map[row][col] = chooseArea(randInt);
            }
        }
    }
    /*
     * Print map areas in 5x5 format
     */
    public void printMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                Areas area = map[row][col];
                System.out.print("[" + area.getTag() + "-" + area.getCreatureTag() + "-" + area.getItemTag() + "] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * Method that allow creatures to move around the Map and replace them in the place they leave
     * Works combined with directioChoice() 
     */
    public void movePlayer (Players player, int direction) {
        int originalX = player.getxCoordinate();        //trace original player x position
        int originalY  = player.getyCoordinate();       //trace original player y position
        switch (direction) {
        case 5: player.moveUp(); break;         
        case 2: player.moveDown(); break;
        case 1: player.moveLeft(); break;
        case 3: player.moveRight(); break;
        default: break;
        }
        map[player.getyCoordinate()][player.getxCoordinate()].printAreaDescription();
        if (map[player.getyCoordinate()][player.getxCoordinate()].checkEquipment(player)) {     // check if the player has the equipment needed
            Opponents opponent = (Opponents) map[player.getyCoordinate()][player.getxCoordinate()].getCreature();
            opponent.opponentIntroduction();        //Opponent introduce himself no user input
            opponent.challengeProposal(player, uI.proposalChoice(opponent)/*User Input*/); // if parameter == 1 set challengeAccepted parameter to true
            if (opponent.isChallengeAccepted()) {       
                opponent.challenge(player);        
                if (opponent.getIsDefeated()) {
                    map[player.getyCoordinate()][player.getxCoordinate()].addItemToPlayer(player);
                    map[player.getyCoordinate()][player.getxCoordinate()].setCreature(player);  // actually moving the player   
                    map[originalY][originalX].addRandomCreature();      // replace player with another creature
                    System.out.println("Congratulation! Now you can visit this area and proceed.");
                }
                else {
                    //System.out.println("Your opponent won the race, go back to training");
                    player.setxCoordinate(originalX); // reset to the original xy the player
                    player.setyCoordinate(originalY);
                }
            }
            else {
                player.setxCoordinate(originalX); // reset to the original xy the player
                player.setyCoordinate(originalY);
            }
        }
        else {
            player.setxCoordinate(originalX); // reset to the original xy the player
            player.setyCoordinate(originalY);
        }
                
    }
    
    /*
     * Method that add a new player in a specific area of the map
     */
    public void addCreatureXY (Creatures creature, int x, int y ) {
        creature.setxCoordinate(x);
        creature.setyCoordinate(y);
        map[x][y].setCreature(creature);
    }
    
    public void addEndGameItem() {
        
    }

    
    public void addSpecialItem(int x, int y) {
        map[y][x].setSpecialItem();
    }
        



}
