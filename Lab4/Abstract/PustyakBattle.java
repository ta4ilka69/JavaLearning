package Abstract;

import Creatures.SomeCreature;
import Objects.Breach;
import Objects.River;
import Objects.SomeObj;
import Objects.StickStageTwo;
import World.World;

import java.util.ArrayList;

public class PustyakBattle extends Battle {
    private boolean signal;
    public PustyakBattle(Game g, ArrayList<SomeCreature> players, World w, StickStageTwo o, River r, Breach b){
        super(g,players);
        signal = false;
        prepare(w, o);
        updatePlayers(o);
        start(r,b,o);
    }

    private void prepare(World w, StickStageTwo o){
        while(!this.signal){
            for(SomeCreature c:this.getPlayers()){
                if(!c.getInventory().contains(o)){
                    c.search(o,w);
                }
                if(c.getName().equals("Кролик")){
                    shoutGame();
                    if(this.signal){
                        break;
                    }
                }
            }
        }
    }
    private void updatePlayers(StickStageTwo o){
        ArrayList<SomeCreature> newp = new ArrayList<>();
        for(SomeCreature c:this.getPlayers()){
            if(c.getInventory().contains(o)){
                newp.add(c);
            }
        }
        this.setPlayers(newp);
    }
    private void start(River r, Breach b, StickStageTwo o){
        for(SomeCreature c: this.getPlayers()) {
            ObjCreatureInteract.ThrowingStickIntoRiver(o,c,r);
        }
        for(SomeCreature c: this.getPlayers()) {
            ObjCreatureInteract.getCloserTo(c,b);
        }
        r.popup();
        setWinner(r.getTrashInRiver().get(0).getOwner());
        System.out.println(this.getWinner().getName()+" победил в этой битве, поздравляем!!!");
    }

    private void setSignalTrue(){
        this.signal = true;
        System.out.println("Кролик прокричал: поиск палок окончен!");
    }

    private void shoutGame(){
        if(Math.random()<=0.15){
            this.setSignalTrue();
        }
    }
}
