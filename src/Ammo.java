
public class Ammo extends Actor {
    private int speed;
    public Ammo(int o,int t,String s){
        super(o,t,s);

    }
public void act(){
    actors.add(this);
    AList.add(this);
}

}

