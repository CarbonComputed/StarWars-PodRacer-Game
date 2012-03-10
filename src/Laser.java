
public class Laser extends Actor {
    private int speed;
    public Laser(int o,int t,String s){
        super(o,t,s);
        speed=3;
    }
public void act(){
   // actors.add(actors.size()-1,this);
    //AList.add(AList.size()-1,this);
}
public void Shot(){
    y-=speed;
}
}

