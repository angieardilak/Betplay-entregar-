package com.soccer.view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.soccer.model.entity.Coach;

public class CoachView {

    private static List<Coach> coaches = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Coach Management System =====");
            System.out.println("1. Create Coach");
            System.out.println("2. View All Coaches");
            System.out.println("3. Update Coach");
            System.out.println("4. Delete Coach");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createCoach(scanner);
                    break;
                case 2:
                    viewAllCoaches();
                    break;
                case 3:
                    updateCoach(scanner);
                    break;
                case 4:
                    deleteCoach(scanner);
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

    private static void createCoach(Scanner scanner) {
        System.out.println("\n===== Create Coach =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("ID Federación: ");
        int idFederacion = scanner.nextInt();
        scanner.nextLine();

        Coach newCoach = new Coach(nextId, nombre, apellido, edad, idFederacion);
        coaches.add(newCoach);
        nextId++;

        System.out.println("Coach created successfully:\n" + newCoach);
    }

    private static void viewAllCoaches() {
        System.out.println("\n===== All Coaches =====");
        if (coaches.isEmpty()) {
            System.out.println("No coaches found.");
        } else {
            for (Coach coach : coaches) {
                System.out.println(coach);
            }
        }
    }

    private static void updateCoach(Scanner scanner) {
        System.out.println("\n===== Update Coach =====");
        System.out.print("Enter Coach ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (Coach coach : coaches) {
            if (coach.getId() == idToUpdate) {
                System.out.println("Current details:\n" + coach);
                System.out.print("New Nombre (press Enter to keep current value '" + coach.getNombre() + "'): ");
                String newNombre = scanner.nextLine();
                if (!newNombre.isEmpty()) {
                    coach.setNombre(newNombre);
                }

                System.out.print("New Apellido (press Enter to keep current value '" + coach.getApellido() + "'): ");
                String newApellido = scanner.nextLine();
                if (!newApellido.isEmpty()) {
                    coach.setApellido(newApellido);
                }

                System.out.print("New Edad (press Enter to keep current value '" + coach.getEdad() + "'): ");
                String newEdadStr = scanner.nextLine();
                if (!newEdadStr.isEmpty()) {
                    int newEdad = Integer.parseInt(newEdadStr);
                    coach.setEdad(newEdad);
                }

                System.out.print("New ID Federación (press Enter to keep current value '" + coach.getIdFederacion() + "'): ");
                String newIdFederacionStr = scanner.nextLine();
                if (!newIdFederacionStr.isEmpty()) {
                    int newIdFederacion = Integer.parseInt(newIdFederacionStr);
                    coach.setIdFederacion(newIdFederacion);
                }

                System.out.println("Coach with ID " + idToUpdate + " updated successfully:\n" + coach);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Coach with ID " + idToUpdate + " not found.");
        }
    }

    private static void deleteCoach(Scanner scanner) {
        System.out.println("\n===== Delete Coach =====");
        System.out.print("Enter Coach ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getId() == idToDelete) {
                Coach deletedCoach = coaches.remove(i);
                System.out.println("Coach with ID " + idToDelete + " deleted successfully:\n" + deletedCoach);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Coach with ID " + idToDelete + " not found.");
        }
    }
}
