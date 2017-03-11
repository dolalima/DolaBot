package facol;

import robocode.*;
//import java.awt.Color;
import java.util.ArrayList;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html
/**
 * DolaBot - a robot by (your name here)
 */
public class DolaBot extends Robot {
    
    ArrayList<Enemy> enemies = new ArrayList();

    /**
     * run: DolaBot's default behavior
     */
    @Override
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar
        // Robot main loop
        while (true) {
            // Replace the next 4 lines with any behavior you would like
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        fire(1);
        
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    @Override
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);
    }
    
    private void updateEnemyList(ScannedRobotEvent e){
        boolean robotInList = false;        
        for(Enemy enemy:this.enemies){
            if(e.getName().equals(enemy.getName())){
                enemy.update(e);
                return;
            }                        
        }
        this.enemies.add(new Enemy(e));
    }

    private class Enemy {
        String name;
        int x,y;
        double velocity,energy,heading,distance;
        public Enemy(ScannedRobotEvent event){
            this.update(event);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getVelocity() {
            return velocity;
        }

        public void setVelocity(double velocity) {
            this.velocity = velocity;
        }

        public double getEnergy() {
            return energy;
        }

        public void setEnergy(double enegy) {
            this.energy = enegy;
        }

        public double getHeading() {
            return heading;
        }

        public void setHeading(double heading) {
            this.heading = heading;
        }
        
        public void update(ScannedRobotEvent event){
            this.name = event.getName();
            this.heading = event.getHeading();
            this.distance = event.getDistance();
            this.energy = event.getEnergy();
        }
        
        
        
    }

}
