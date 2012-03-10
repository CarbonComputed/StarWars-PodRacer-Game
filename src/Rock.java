/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class Rock extends Actor {
    public Rock(int o,int t,String s){
        super(o,t,s);
    }
public void act(){
    actors.add(2,this);
    AList.add(this);
}
}
