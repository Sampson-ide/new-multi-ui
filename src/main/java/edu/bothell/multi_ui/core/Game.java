package edu.bothell.multi_ui.core;

import java.util.ArrayList;

//s:as a result of code, this has become literally just tictactoe
public class Game {
    private final int                  MAX_PLAYERS = 2;
    private final ArrayList<Player>    p;
    private final State                s;
    private int                        turn;
    private Player                     active;
    private int row_counter = 0;
    private boolean game_ending = false;
    public Game(Control c){
        this.turn = 0;
        this.s = new World();
        this.p = new ArrayList<>();
    }
    
    public Player addPlayer(Player p){
        this.p.add(p);
        if(this.active == null) active = p;

        return p;
    }

    public Player addPlayer(char c, String sId){
        Player p = new Player(c);
        p.setSId(sId);
        return addPlayer(p);
    }

    public char[] getPlayersChar(){
        char[] pcs = new char[p.size()];
        for(int i = 0; i < pcs.length; i++) 
            pcs[i] = p.get(i).getChar();
        
        return pcs;
    }
    
    public boolean isValid(int[] pos, String sId){
        System.out.println("isVAlid?"+s.getIt(pos)+"|" + sId+"|" + active.getSId()+"|");
        return s.isOpen(pos) && active.getSId().equals(sId);
    }

    public char play(int[] pos, String sId){
        if(!isValid(pos, sId)) return ' ';
        while(!game_ending){
        turn++;
        this.s.setIt(active.getChar(), pos[0], pos[1]);
        
        //s:new tic-tac-toe stuff
        game_ending = check_horiz();
        if(!game_ending){game_ending = check_vert();}
        if(!game_ending){game_ending = check_lr_diag();}
        this.active = p.get( turn % p.size() );
        return active.getChar();
        }
       
        return ' ';
        
    }
    private boolean check_horiz(){
    for(var i = 0; i < s.S.length;i++){
        for(var k = 0; k < s.S.length;k++){
                        
            if(s.S[i][k] == active.getChar()){System.out.println("Active char at " + i + " " + k); row_counter +=1;} else{row_counter = 0;};
            if(row_counter == 3){System.out.println("win for active horizontal"); return true;}
            }
        row_counter = 0;
            
    }
    return false;
}
private boolean check_vert(){
    for(var i = 0; i < s.S.length;i++){
        for(var k = 0; k < s.S.length;k++){
                        
            if(s.S[k][i] == active.getChar()){System.out.println("Active char at " + i + " " + k); row_counter +=1;} else{row_counter = 0;};
            if(row_counter == 3){System.out.println("win for active vertical"); return true;}
            }
        row_counter = 0;
            
    }
    return false;
}
private boolean check_lr_diag(){
    for(var i = 0; i < s.S.length;i++){
        if(s.S[i][i] == active.getChar()){row_counter++;};if(row_counter == 3){System.out.println("diag win active");return true;};
    }
    return false;
}
    public Player getActive() {
        return this.active;
    }

    public State getState() {
        return this.s;
    }

    public Location getLocation(int x, int y) {
        return ((World)s).getLocation(x, y);
    }

    public int getMaxPlayers() {
        return MAX_PLAYERS;
    }

    public int getPlayerCount() {
        return p.size();
    }

    public ArrayList<Player> getPlayers(){
        return this.p;
    }

    public int getTurn(){
        return this.turn;
    }


}
 