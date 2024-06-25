package com.soccer.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.soccer.model.entity.Player;

public class PlayerView {

    private static List<Player> players = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Player Management System =====");
            System.out.println("1. Create Player");
            System.out.println("2. View All Players");
            System.out.println("3. Update Player");
            System.out.println("4. Delete Player");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createPlayer(scanner);
                    break;
                case 2:
                    viewAllPlayers();
                    break;
                case 3:
                    updatePlayer(scanner);
                    break;
                case 4:
                    deletePlayer(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    private static void createPlayer(Scanner scanner) {
        System.out.println("\n===== Create Player =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Dorsal: ");
        int dorsal = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Posición: ");
        String posicion = scanner.nextLine();

        Player newPlayer = new Player(nextId, nombre, apellido, edad, dorsal, posicion);
        players.add(newPlayer);
        nextId++;

        System.out.println("Player created successfully:\n" + newPlayer);
    }

    private static void viewAllPlayers() {
        System.out.println("\n===== All Players =====");
        if (players.isEmpty()) {
            System.out.println("No players found.");
        } else {
            for (Player player : players) {
                System.out.println(player);
            }
        }
    }

    private static void updatePlayer(Scanner scanner) {
        System.out.println("\n===== Update Player =====");
        System.out.print("Enter Player ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Player player : players) {
            if (player.getId() == idToUpdate) {
                System.out.println("Current details:\n" + player);
                System.out.print("New Nombre (press Enter to keep current value '" + player.getNombre() + "'): ");
                String newNombre = scanner.nextLine();
                if (!newNombre.isEmpty()) {
                    player.setNombre(newNombre);
                }

                System.out.print("New Apellido (press Enter to keep current value '" + player.getApellido() + "'): ");
                String newApellido = scanner.nextLine();
                if (!newApellido.isEmpty()) {
                    player.setApellido(newApellido);
                }

                System.out.print("New Edad (press Enter to keep current value '" + player.getEdad() + "'): ");
                String newEdadStr = scanner.nextLine();
                if (!newEdadStr.isEmpty()) {
                    int newEdad = Integer.parseInt(newEdadStr);
                    player.setEdad(newEdad);
                }

                System.out.print("New Dorsal (press Enter to keep current value '" + player.getDorsal() + "'): ");
                String newDorsalStr = scanner.nextLine();
                if (!newDorsalStr.isEmpty()) {
                    int newDorsal = Integer.parseInt(newDorsalStr);
                    player.setDorsal(newDorsal);
                }

                System.out.print("New Posición (press Enter to keep current value '" + player.getPosicion() + "'): ");
                String newPosicion = scanner.nextLine();
                if (!newPosicion.isEmpty()) {
                    player.setPosicion(newPosicion);
                }

                System.out.println("Player with ID " + idToUpdate + " updated successfully:\n" + player);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Player with ID " + idToUpdate + " not found.");
        }
    }

    private static void deletePlayer(Scanner scanner) {
        System.out.println("\n===== Delete Player =====");
        System.out.print("Enter Player ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == idToDelete) {
                Player deletedPlayer = players.remove(i);
                System.out.println("Player with ID " + idToDelete + " deleted successfully:\n" + deletedPlayer);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Player with ID " + idToDelete + " not found.");
        }
    }
}
