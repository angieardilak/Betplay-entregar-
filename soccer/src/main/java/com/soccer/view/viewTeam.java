package com.soccer.view;

import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Team;

public class viewTeam {
    private Controller controller;

    public viewTeam(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Team Management System =====");
            System.out.println("1. Create Team");
            System.out.println("2. Update Team");
            System.out.println("3. Find Team");
            System.out.println("4. Delete Team");
            System.out.println("5. List All Teams");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    createTeam(scanner);
                    break;
                case 2:
                    updateTeam(scanner);
                    break;
                case 3:
                    findTeam(scanner);
                    break;
                case 4:
                    deleteTeam(scanner);
                    break;
                case 5:
                    listAllTeams();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }

    private void createTeam(Scanner scanner) {
        System.out.println("\n===== Create Team =====");
        System.out.print("Enter Team Code: ");
        String teamCode = scanner.nextLine();
        System.out.print("Enter Team Name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter Team City: ");
        String teamCity = scanner.nextLine();

        Team newTeam = new Team(teamName, teamCity);
        controller.addTeam(teamCode, newTeam);
        
        System.out.println("Team created successfully: " + newTeam);
    }

    private void updateTeam(Scanner scanner) {
        System.out.println("\n===== Update Team =====");
        System.out.print("Enter Team Code to update: ");
        String teamCode = scanner.nextLine();

        Team existingTeam = controller.getTeam(teamCode);
        if (existingTeam == null) {
            System.out.println("Team with code " + teamCode + " not found.");
            return;
        }

        System.out.print("Enter new Team Name (press Enter to keep current value '" + existingTeam.getNombre() + "'): ");
        String newTeamName = scanner.nextLine();
        if (!newTeamName.isEmpty()) {
            existingTeam.setNombre(newTeamName);
        }

        System.out.print("Enter new Team City (press Enter to keep current value '" + existingTeam.getCiudad() + "'): ");
        String newTeamCity = scanner.nextLine();
        if (!newTeamCity.isEmpty()) {
            existingTeam.setCiudad(newTeamCity);
        }

        System.out.println("Team with code " + teamCode + " updated successfully: " + existingTeam);
    }

    private void findTeam(Scanner scanner) {
        System.out.println("\n===== Find Team =====");
        System.out.print("Enter Team Code to find: ");
        String teamCode = scanner.nextLine();

        Team foundTeam = controller.getTeam(teamCode);
        if (foundTeam != null) {
            System.out.println("Team found:\n" + foundTeam);
        } else {
            System.out.println("Team with code " + teamCode + " not found.");
        }
    }

    private void deleteTeam(Scanner scanner) {
        System.out.println("\n===== Delete Team =====");
        System.out.print("Enter Team Code to delete: ");
        String teamCode = scanner.nextLine();

        Team deletedTeam = controller.removeTeam(teamCode);
        if (deletedTeam != null) {
            System.out.println("Team deleted successfully:\n" + deletedTeam);
        } else {
            System.out.println("Team with code " + teamCode + " not found.");
        }
    }

    private void listAllTeams() {
        System.out.println("\n===== All Teams =====");
        controller.getAllTeams().forEach((code, team) -> {
            System.out.println("Team Code: " + code);
            System.out.println("Team Details: " + team);
            System.out.println("------------------------");
        });
    }
}
