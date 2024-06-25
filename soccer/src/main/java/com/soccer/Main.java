package com.soccer;

import com.soccer.view.viewTeam;

public class Main {
    public static void main(String[] args) {
      
        Controller ctrlTeams = new Controller();

        viewTeam vt = new viewTeam(ctrlTeams);

   
        vt.start();
    }
}
